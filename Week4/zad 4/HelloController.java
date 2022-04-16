package com.example.converter;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBinary;

    @FXML
    private Button btnDecimal;

    @FXML
    private Button btnHex;

    @FXML
    private MenuItem mniBinary;

    @FXML
    private MenuItem mniDecimal;

    @FXML
    private MenuItem mniHex;

    @FXML
    private Menu mnuQuit;

    @FXML
    private TextField txtBinary;

    @FXML
    private TextField txtDecimal;

    @FXML
    private TextField txtHex;

    @FXML
    void btnBinaryOnActionHandler(ActionEvent event) {

    }

    @FXML
    void btnDecimalOnActionHandler(ActionEvent event) {
        this.calculateDecimal();
    }

    @FXML
    void btnHexOnActionHandler(ActionEvent event) {
        this.calculateHex();
    }

    @FXML
    void mniBinaryOnActionHandler(ActionEvent event) {

    }

    @FXML
    void mniDecimalOnActionHandler(ActionEvent event) {
        this.calculateDecimal();
    }

    @FXML
    void mniHexOnActionHandler(ActionEvent event) {
        this.calculateHex();
    }

    @FXML
    void mnuQuitOnActionHandler(ActionEvent event)
    {
        Platform.exit();
    }

    @FXML
    void txtBinaryOnActionHandler(ActionEvent event) {

    }

    @FXML
    void txtDecimalOnActionHandler(ActionEvent event) {
        this.calculateDecimal();
    }

    @FXML
    void txtHexOnActionHandler(ActionEvent event) {
        this.calculateHex();
    }

    @FXML
    void initialize() {
        assert btnBinary != null : "fx:id=\"btnBinary\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnDecimal != null : "fx:id=\"btnDecimal\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnHex != null : "fx:id=\"btnHex\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert mniBinary != null : "fx:id=\"mniBinary\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert mniDecimal != null : "fx:id=\"mniDecimal\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert mniHex != null : "fx:id=\"mniHex\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtBinary != null : "fx:id=\"txtBinary\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtDecimal != null : "fx:id=\"txtDecimal\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtHex != null : "fx:id=\"txtHex\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

    private void calculateHex()
    {
        String hexText = txtHex.getText();
        int hex = Integer.//parseInt(hexText);
        txtBinary.setText(Integer.toBinaryString(hex));
        txtDecimal.setText(Integer.toString(hex));
    }

    private void calculateBinary()
    {
        String binaryText = txtBinary.getText();
        int binary = Integer.parseInt(binaryText);
        txtHex.setText(Integer.toHexString(binary).toUpperCase());
        //txtDecimal.setText(Integer.parseInt((binary)));
    }

    private void calculateDecimal()
    {
        String decimalText = txtDecimal.getText();
        int decimal = Integer.parseInt(decimalText);
        txtBinary.setText(Integer.toBinaryString(decimal));
        txtHex.setText(Integer.toHexString(decimal).toUpperCase());
    }
}
