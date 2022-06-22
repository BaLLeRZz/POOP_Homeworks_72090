package com.example.generator;

import java.net.URL;
import java.util.ResourceBundle;

import com.providers.CipherGenerator;
import com.providers.Wrapper;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnRandom;

    @FXML
    private Button btnSubset;

    @FXML
    private TextField txtSeed;

    @FXML
    private TextField txtSize;

    @FXML
    void btnQuitOnActionHandler(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnRandomOnActionHandler(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Random subsequence of letters A-Z");
        alert.setHeaderText("Count distinct characters out of " + txtSize.getText());
        Wrapper wrapper = new Wrapper(Integer.parseInt(txtSize.getText()));
        alert.setContentText(CipherGenerator.countDistinct(wrapper.makeFixedRandom(), Integer.parseInt(txtSeed.getText())).toString());
        alert.showAndWait();
    }

    @FXML
    void btnSubsetOnActionHandler(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Generate random subset A-Z");
        alert.setHeaderText("Count distinct characters out of " + txtSize.getText());
        Wrapper wrapper = new Wrapper(Integer.parseInt(txtSize.getText()));
        alert.setContentText(CipherGenerator.countDistinct(wrapper.makeFixedSelection(), Integer.parseInt(txtSeed.getText())).toString());
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnRandom != null : "fx:id=\"btnRandom\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnSubset != null : "fx:id=\"btnSubset\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtSeed != null : "fx:id=\"txtSeed\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtSize != null : "fx:id=\"txtSize\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

}
