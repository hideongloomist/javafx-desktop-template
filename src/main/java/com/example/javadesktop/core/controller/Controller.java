package com.example.javadesktop.core.controller;

import javafx.stage.Stage;

public class Controller {
    private Stage currentStage;

    void setCurrentStage(Stage currentStage) {
        this.currentStage = currentStage;
    }

    protected void closeCurrentWindow() {
        this.currentStage.close();
    }
}
