module com.example.javadesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.swing;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.net.http;
    requires com.google.gson;
    requires java.logging;

    opens com.example.javadesktop to javafx.fxml;
    exports com.example.javadesktop;
    exports com.example.javadesktop.modules.login.controllers;
    opens com.example.javadesktop.modules.login.controllers to javafx.fxml;
}