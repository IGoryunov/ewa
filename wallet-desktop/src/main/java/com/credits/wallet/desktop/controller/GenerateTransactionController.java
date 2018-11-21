package com.credits.wallet.desktop.controller;


import com.credits.client.node.pojo.TransactionFlowResultData;
import com.credits.general.exception.CreditsException;
import com.credits.general.util.Callback;
import com.credits.general.util.Converter;
import com.credits.wallet.desktop.AppState;
import com.credits.wallet.desktop.VistaNavigator;
import com.credits.wallet.desktop.utils.ApiUtils;
import com.credits.wallet.desktop.utils.FormUtils;
import com.credits.wallet.desktop.utils.TransactionIdCalculateUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;

import static com.credits.client.node.service.NodeApiServiceImpl.handleCallback;
import static com.credits.general.util.Utils.threadPool;
import static com.credits.wallet.desktop.AppState.*;
import static com.credits.wallet.desktop.utils.ApiUtils.createTransaction;

/**
 * Created by Rustem.Saidaliyev on 26.01.2018.
 */
public class GenerateTransactionController implements Initializable {
    private final static Logger LOGGER = LoggerFactory.getLogger(GenerateTransactionController.class);
    private final static String CREDITS_SYMBOL = "CS";

    @FXML
    BorderPane bp;

    @FXML
    private TextField toAddress; //todo remove global variable

    @FXML TextField transactionText;

    @FXML
    private TextField amountInCs;

    @FXML
    private TextField transactionFeeValue;

    @FXML
    private void handleBack() {
        noClearForm6 = true;
        VistaNavigator.loadVista(VistaNavigator.WALLET);
    }

    @FXML
    private void handleGenerate() {
        try {
            if(coin.equals(CREDITS_SYMBOL)) {
                CompletableFuture
                    .supplyAsync(() -> TransactionIdCalculateUtils.calcTransactionIdSourceTarget(account,toAddress.getText()),threadPool)
                    .thenApply((transactionData) -> createTransaction(transactionData, AppState.amount, AppState.transactionText))
                    .whenComplete(handleCallback(handleTransactionResult()));
            } else {
                coinsKeeper.getKeptObject().ifPresent(coinsMap ->
                    Optional.ofNullable(coinsMap.get(coin)).ifPresent(
                        coin -> contractInteractionService.transferTo(coin, AppState.toAddress, amount, handleTransferTokenResult())));
            }
        } catch (CreditsException e) {
            LOGGER.error(NODE_ERROR + ": " + e.getMessage(), e);
            FormUtils.showError(NODE_ERROR);
            return;
        }

        VistaNavigator.loadVista(VistaNavigator.WALLET);
    }

    private Callback<String> handleTransferTokenResult() {
        return new Callback<String>() {
            @Override
            public void onSuccess(String message) throws CreditsException {
                FormUtils.showPlatformInfo(message);
            }

            @Override
            public void onError(Throwable e) {
                FormUtils.showPlatformError(e.getLocalizedMessage());
            }
        };
    }

    private Callback<Pair<Long, TransactionFlowResultData>> handleTransactionResult() {
        return new Callback<Pair<Long, TransactionFlowResultData>>() {
            @Override
            public void onSuccess(Pair<Long, TransactionFlowResultData> resultData) {
                ApiUtils.saveTransactionRoundNumberIntoMap(resultData.getRight().getRoundNumber(),
                    resultData.getLeft());
                FormUtils.showPlatformInfo("Transaction created");
            }

            @Override
            public void onError(Throwable e) {
                LOGGER.error("Failed!", e);
                FormUtils.showPlatformError(e.getMessage());
            }
        };
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FormUtils.resizeForm(bp);
        this.toAddress.setText(AppState.toAddress);
        this.amountInCs.setText(Converter.toString(amount) + " " + coin);
        this.transactionText.setText(AppState.transactionText);
    }

}
