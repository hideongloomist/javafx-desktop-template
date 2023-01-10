package com.example.javadesktop.core.controller;

import com.example.javadesktop.App;
import com.example.javadesktop.modules.login.controllers.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowController {
    /**
     * @param layout layout file in .fxml
     * @param title  Tilt of the window to be created
     * @return Object to be cast to a proper controller. Use to send information between app Controllers
     * @throws IOException if the window cannot be created.
     */
    private static Object openNewWindow(String layout, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("layout/" + layout));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Controller controller = fxmlLoader.getController();
        controller.setCurrentStage(stage);
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        // Force FXML min sizes (width/height)
        stage.setMinWidth(root.minWidth(-1));
        stage.setMinHeight(root.minHeight(-1));
        stage.show();
        return controller;
    }

    public static LoginController openLoginWindow() throws IOException {
        return (LoginController) openNewWindow("login.fxml", "Login");
    }

    public static void displayInformation(String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        styleDialog(alert);
        alert.setContentText(content);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public static boolean displayConfirmation(String question) {
        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        styleDialog(alert);
        alert.setContentText(question);
        alert.setHeaderText(null);
        alert.showAndWait();
        return (alert.getResult() == ButtonType.OK);
    }

    public static void displayError(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        styleDialog(alert);
        alert.setContentText(content);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public  static void styleDialog(Dialog dialog) {
        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getStylesheets().add(
                App.class.getResource("style/application.css").toExternalForm()
        );
        dialogPane.getStyleClass().add("myDialog");
    }

    public static void higlightInvalidInput(TextField field) {
        field.setStyle("-fx-border-color: red");
    }
}
