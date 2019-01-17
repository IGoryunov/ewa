package com.credits.wallet.desktop.utils;

import com.credits.wallet.desktop.struct.CoinTabRow;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by goncharov-eg on 26.01.2018.
 */
public class FormUtils {

    public static void showError(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Error");
        alert.setHeaderText("Error!");
        alert.setContentText(text);
        alert.showAndWait();
    }

    public static void showInfo(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Information");
        alert.setHeaderText("Information");
        alert.setContentText(text);
        alert.showAndWait();
    }

    public static void showPlatformWarning(String content) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText(content);
            alert.showAndWait();
        });
    }

    public static void showPlatformError(String content) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(content);
            alert.showAndWait();
        });
    }

    public static void showPlatformInfo(String content) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initStyle(StageStyle.UTILITY);
            alert.setTitle("Info");
            alert.setHeaderText("Info");
            alert.setContentText(content);
            alert.showAndWait();
        });
    }

    public static <V, T> void addTooltipToColumnCells(TableColumn<V, T> column) {

        Callback<TableColumn<V, T>, TableCell<V, T>> existingCellFactory = column.getCellFactory();

        column.setCellFactory(c -> {
            TableCell<V, T> cell = existingCellFactory.call(c);
            Tooltip tooltip = new Tooltip();
            tooltip.textProperty().bind(cell.itemProperty().asString());
            cell.setTooltip(tooltip);
            return cell;
        });
    }


    public static void validateField(TextField textField, Label errorLabel, String errorText,
        AtomicBoolean validationFlag) {
        errorLabel.setText(errorText);
        textField.setStyle(textField.getStyle().replace("-fx-border-color: #ececec", "-fx-border-color: red"));
        validationFlag.set(false);
    }

    public static void validateTable(TableView<CoinTabRow> tableView, Label errorLabel, String errorText,
        AtomicBoolean validationFlag) {
        errorLabel.setText(errorText);
        tableView.getStyleClass().add("credits-border-red");
        validationFlag.set(false);
    }

    public static void clearErrorOnTable(TableView<CoinTabRow> tableView, Label errorLabel) {
        tableView.getStyleClass().remove("credits-border-red");
        errorLabel.setText("");
    }

    public static void clearErrorOnField(TextField textField, Label errorLabel) {
        errorLabel.setText("");
        textField.setStyle(textField.getStyle().replace("-fx-border-color: red", "-fx-border-color: #ececec"));
    }
}

