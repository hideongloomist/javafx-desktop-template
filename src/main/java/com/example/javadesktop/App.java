package com.example.javadesktop;

import com.example.javadesktop.constants.Constants;
import com.example.javadesktop.core.controller.WindowController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            WindowController.openLoginWindow();
        } catch (Exception e) {
            WindowController.displayError(Constants.AppMessage.ClosingMessage+":\n" + e.getMessage());
            Platform.exit();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}