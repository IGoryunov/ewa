package com.credits.wallet.desktop.controller;

import com.credits.general.exception.CreditsException;
import com.credits.general.pojo.ApiResponseData;
import com.credits.general.pojo.SmartContractData;
import com.credits.general.util.Callback;
import com.credits.wallet.desktop.AppState;
import com.credits.wallet.desktop.VistaNavigator;
import com.credits.wallet.desktop.struct.ErrorCodeTabRow;
import com.credits.wallet.desktop.utils.ApiUtils;
import com.credits.wallet.desktop.utils.CodeAreaUtils;
import com.credits.wallet.desktop.utils.FormUtils;
import com.credits.wallet.desktop.utils.SmartContractsUtils;
import com.credits.wallet.desktop.utils.TransactionIdCalculateUtils;
import com.credits.wallet.desktop.utils.compiler.InMemoryCompiler;
import com.credits.wallet.desktop.utils.compiler.model.CompilationPackage;
import com.credits.wallet.desktop.utils.compiler.model.CompilationResult;
import com.credits.wallet.desktop.utils.compiler.model.CompilationUnit;
import com.credits.wallet.desktop.utils.sourcecode.SourceCodeUtils;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import org.eclipse.jdt.core.dom.BodyDeclaration;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.fxmisc.richtext.CodeArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

import static com.credits.client.node.service.NodeApiServiceImpl.handleCallback;
import static com.credits.general.util.Converter.decodeFromBASE58;
import static com.credits.general.util.Utils.threadPool;
import static com.credits.wallet.desktop.AppState.account;
import static com.credits.wallet.desktop.utils.ApiUtils.createSmartContractTransaction;

/**
 * Created by goncharov-eg on 30.01.2018.
 */
//TODO: This class is a GODZILLA please refactor it ASAP!
public class SmartContractDeployController implements Initializable {

    public static final String BUILD = "Build";
    public static final String COMPILING = "Compiling...";
    //    private static final String NON_CHANGED_STR = "public class Contract extends SmartContract {";
    private static Logger LOGGER = LoggerFactory.getLogger(SmartContractDeployController.class);

    private CodeArea codeArea;


    @FXML
    private TableView<ErrorCodeTabRow> errorTableView;

    @FXML
    private SplitPane splitPane;

    @FXML
    BorderPane bp;

    @FXML
    private Pane paneCode;

    @FXML
    private Pane debugPane;

    @FXML
    private TreeView<Label> classTreeView;

    @FXML
    public Button deployButton;

    @FXML
    public Button buildButton;

    public CompilationPackage compilationPackage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FormUtils.resizeForm(bp);

        if (AppState.executor != null) {
            AppState.executor.shutdown();
        }
        AppState.executor = Executors.newSingleThreadExecutor();

        codeArea = CodeAreaUtils.initCodeArea(paneCode, false);

        CodeAreaUtils.initCodeAreaLogic(codeArea);

        codeArea.addEventHandler(KeyEvent.KEY_PRESSED, (evt) -> {
            compilationPackage = null;
            deployButton.setDisable(true);
            buildButton.setDisable(false);
        });



        for (SplitPane.Divider d : splitPane.getDividers()) {
            d.positionProperty()
                .addListener((observable, oldValue, newValue) -> errorTableView.setPrefHeight(debugPane.getHeight()));
        }

        panelCodeKeyReleased();
        initErrorTableView();

    }




    @FXML
    private void handleBack() {
        if (AppState.executor != null) {
            AppState.executor.shutdown();
            AppState.executor = null;
        }
        VistaNavigator.loadVista(VistaNavigator.SMART_CONTRACT);
    }

    @FXML
    private void panelCodeKeyReleased() {
        Thread t = new Thread(this::refreshClassMembersTree);
        t.setDaemon(true);
        t.start();
    }

    private synchronized void refreshClassMembersTree() {
        Platform.runLater(() -> {
            classTreeView.setRoot(null);
            String sourceCode = codeArea.getText();
            String className = SourceCodeUtils.parseClassName(sourceCode);
            Label labelRoot = new Label(className);
            TreeItem<Label> treeRoot = new TreeItem<>(labelRoot);

            List<FieldDeclaration> fields = SourceCodeUtils.parseFields(sourceCode);
            List<MethodDeclaration> constructors = SourceCodeUtils.parseConstructors(sourceCode);
            List<MethodDeclaration> methods = SourceCodeUtils.parseMethods(sourceCode);

            List<BodyDeclaration> classMembers = new ArrayList<>();
            classMembers.addAll(fields);
            classMembers.addAll(constructors);
            classMembers.addAll(methods);

            classMembers.forEach(classMember -> {
                if (classMember instanceof MethodDeclaration) {
                    ((MethodDeclaration) classMember).setBody(null);
                }

                Label label = new Label(classMember.toString());
                label.setOnMousePressed(event -> {
                    if (event.isPrimaryButtonDown()) {
                        CodeAreaUtils.positionCursorToLine(codeArea,SourceCodeUtils.getLineNumber(sourceCode, classMember));
                    }
                });
                TreeItem<Label> treeItem = new TreeItem<>();
                treeItem.setValue(label);
                treeRoot.getChildren().add(treeItem);
            });

            treeRoot.setExpanded(true);
            classTreeView.setRoot(treeRoot);
        });
    }

    @FXML
    private void handleCheck() {
        buildButton.setText(COMPILING);
        buildButton.setDisable(true);
        errorTableView.setVisible(false);
        CompletableFuture.supplyAsync(() -> InMemoryCompiler.compileSourceCode(codeArea.getText()))
            .whenComplete(handleCallback(handleCheckResult()));
    }


    private Callback<CompilationResult> handleCheckResult() {
        return new Callback<CompilationResult>() {
            @Override
            @SuppressWarnings("unchecked")
            public void onSuccess(CompilationResult compilationResult) {
                List errorsList = compilationResult.getErrors();
                Platform.runLater(() -> {
                    buildButton.setText(BUILD);
                });

                if (errorsList.size() > 0) {
                    Platform.runLater(() -> {
                        buildButton.setDisable(false);
                        addErrorsToErrorTable(errorsList);
                    });
                } else {
                    compilationPackage = compilationResult.getCompilationPackage();
                    Platform.runLater(() -> {
                        buildButton.setDisable(true);
                        deployButton.setDisable(false);
                    });
                }
            }

            @Override
            public void onError(Throwable e) {
                Platform.runLater(() -> {
                    buildButton.setDisable(false);
                    buildButton.setText(BUILD);
                    FormUtils.showPlatformError(e.getMessage());
                });
                LOGGER.error("failed!", e);
            }
        };
    }




    private void addErrorsToErrorTable(List<ErrorCodeTabRow> listOfError) {
        errorTableView.getItems().clear();
        errorTableView.getItems().addAll(listOfError);
        errorTableView.setVisible(true);
        errorTableView.setPrefHeight(30 + errorTableView.getItems().size() * 25);
    }

    @FXML
    private void handleDeploy() {

        String className = SourceCodeUtils.parseClassName(codeArea.getText(), "SmartContract");
        try {
            String javaCode = SourceCodeUtils.normalizeSourceCode(codeArea.getText());
            if (compilationPackage==null) {
                buildButton.setDisable(false);
                deployButton.setDisable(true);
                throw new CreditsException("Source code is not compiled");
            } else {
                if (compilationPackage.isCompilationStatusSuccess()) {
                    List<CompilationUnit> compilationUnits = compilationPackage.getUnits();
                    CompilationUnit compilationUnit = compilationUnits.get(0);
                    byte[] byteCode = compilationUnit.getBytecode();

                    SmartContractData smartContractData =
                        new SmartContractData(SmartContractsUtils.generateSmartContractAddress(), decodeFromBASE58(account),
                            javaCode, byteCode, null);

                    CompletableFuture.supplyAsync(
                        () -> TransactionIdCalculateUtils.calcTransactionIdSourceTarget(account, smartContractData.getBase58Address()), threadPool)
                        .thenApply(
                            (transactionData) -> createSmartContractTransaction(transactionData, smartContractData))
                        .whenComplete(handleCallback(handleDeployResult()));
                    AppState.lastSmartContract = codeArea.getText();
                    VistaNavigator.loadVista(VistaNavigator.WALLET);
                }
            }
        } catch (CreditsException e) {
            LOGGER.error("failed!", e);
            FormUtils.showError(AppState.NODE_ERROR + ": " + e.getMessage());
        }
    }

    private Callback<ApiResponseData> handleDeployResult() {
        return new Callback<ApiResponseData>() {
            @Override
            public void onSuccess(ApiResponseData resultData) {
                ApiUtils.saveTransactionRoundNumberIntoMap(resultData);
                String target = resultData.getTarget();
                StringSelection selection = new StringSelection(target);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, selection);
                FormUtils.showPlatformInfo(
                    String.format("Smart-contract address\n\n%s\n\nhas generated and copied to clipboard", target));
            }

            @Override
            public void onError(Throwable e) {
                LOGGER.error("failed!", e);
                FormUtils.showPlatformError(e.getMessage());
            }
        };
    }


    private void initErrorTableView() {
        TableColumn<ErrorCodeTabRow, String> tabErrorsColLine = new TableColumn<>();
        tabErrorsColLine.setText("Line");
        tabErrorsColLine.setCellValueFactory(new PropertyValueFactory<>("line"));
        tabErrorsColLine.setPrefWidth(debugPane.getPrefWidth() * 0.1);

        TableColumn<ErrorCodeTabRow, String> tabErrorsColText = new TableColumn<>();
        tabErrorsColText.setText("Error");
        tabErrorsColText.setCellValueFactory(new PropertyValueFactory<>("text"));
        tabErrorsColText.setPrefWidth(debugPane.getPrefWidth() * 0.88);

        errorTableView.setVisible(false);
        errorTableView.setPrefHeight(debugPane.getPrefHeight());
        errorTableView.setPrefWidth(debugPane.getPrefWidth());

        errorTableView.getColumns().add(tabErrorsColLine);
        errorTableView.getColumns().add(tabErrorsColText);

        errorTableView.setOnMousePressed(event -> {
            if (event.isPrimaryButtonDown()) {
                ErrorCodeTabRow tabRow = errorTableView.getSelectionModel().getSelectedItem();
                if (tabRow != null) {
                    CodeAreaUtils.positionCursorToLine(codeArea,Integer.valueOf(tabRow.getLine()));
                }
            }
        });
    }

}