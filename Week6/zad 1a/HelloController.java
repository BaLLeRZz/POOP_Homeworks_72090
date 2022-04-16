package com.example.vbox;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGCD;

    @FXML
    private Button btnQuit;

    @FXML
    private Label lblA;

    @FXML
    private Label lblB;

    @FXML
    private Label lblGCD;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtB;

    @FXML
    private TextField txtGCD;

    @FXML
    void btnGCDOnActionHandler(ActionEvent event) {
        int a = Integer.parseInt(txtA.getText());
        int b = Integer.parseInt(txtB.getText());
        int gcd = computeGCD(a, b);
        txtGCD.setText(Integer.toString(gcd));
    }

    @FXML
    void btnQuitOnActionHandler(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert btnGCD != null : "fx:id=\"btnGCD\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblA != null : "fx:id=\"lblA\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblB != null : "fx:id=\"lblB\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert lblGCD != null : "fx:id=\"lblGCD\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtA != null : "fx:id=\"txtA\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtB != null : "fx:id=\"txtB\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtGCD != null : "fx:id=\"txtGCD\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

    //gcd(a,b) = gcd(n, a mod b) = ... = gcd(r, 0) = r
    private int computeGCD(int a, int b) {
        if (b == 0)
            return a;

        return computeGCD(b, a % b);
    }
}
