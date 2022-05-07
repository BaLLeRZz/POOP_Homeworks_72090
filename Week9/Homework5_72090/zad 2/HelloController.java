package com.example.calculator;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    private String mathString1 = "";
    private String mathString2 = "";
    private double leftNumber = 0;
    private double rightNumber = 0;
    private char previousOperation = ' ';

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnC;

    @FXML
    private Button btnCA;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnDot;

    @FXML
    private Button btnEight;

    @FXML
    private Button btnEquals;

    @FXML
    private Button btnFive;

    @FXML
    private Button btnFour;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btnMultiply;

    @FXML
    private Button btnNine;

    @FXML
    private Button btnOFF;

    @FXML
    private Button btnOne;

    @FXML
    private Button btnPlus;

    @FXML
    private Button btnSeven;

    @FXML
    private Button btnSix;

    @FXML
    private Button btnThree;

    @FXML
    private Button btnTwo;

    @FXML
    private Button btnZero;

    @FXML
    private Button btnZeroZero;

    @FXML
    private TextField txtLane;

    @FXML
    void btnCAOnActionHandler(ActionEvent event) {
        this.mathString1 = "";
        this.mathString2 = "";
        this.previousOperation = ' ';
        this.leftNumber = 0;
        this.rightNumber = 0;
        this.txtLane.setText("");
    }

    @FXML
    void btnCOnActionHandler(ActionEvent event) {
        this.mathString2 = "";
        this.txtLane.setText("");

        if (this.previousOperation == ' ')
        {
            this.mathString1 = "";
            this.mathString2 = "";
            this.previousOperation = ' ';
            this.leftNumber = 0;
            this.rightNumber = 0;
            this.txtLane.setText("");
        }
    }

    @FXML
    void btnDivideOnActionHandler(ActionEvent event) {
        this.divide();
    }

    @FXML
    void btnDotOnActionHandler(ActionEvent event) {
        if (this.previousOperation == ' ')
        {
            this.mathString1 += '.';
            this.txtLane.setText(this.mathString1);
        }
        else
        {
            this.mathString2 += '.';
            this.txtLane.setText(this.mathString2);
        }
    }

    @FXML
    void btnEightOnActionHandler(ActionEvent event) {
        if (this.previousOperation == ' ')
        {
            this.mathString1 += '8';
            this.txtLane.setText(this.mathString1);
        }
        else
        {
            this.mathString2 += '8';
            this.txtLane.setText(this.mathString2);
        }
    }

    @FXML
    void btnEqualsOnActionHandler(ActionEvent event) {
        if (this.previousOperation == ' ')
            return;

        this.calculate('=');
        this.previousOperation = ' ';
    }

    @FXML
    void btnFiveOnActionHandler(ActionEvent event) {
        if (this.previousOperation == ' ')
        {
            this.mathString1 += '5';
            this.txtLane.setText(this.mathString1);
        }
        else
        {
            this.mathString2 += '5';
            this.txtLane.setText(this.mathString2);
        }
    }

    @FXML
    void btnFourOnActionHandler(ActionEvent event) {
        if (this.previousOperation == ' ')
        {
            this.mathString1 += '4';
            this.txtLane.setText(this.mathString1);
        }
        else
        {
            this.mathString2 += '4';
            this.txtLane.setText(this.mathString2);
        }
    }

    @FXML
    void btnMinusOnActionHandler(ActionEvent event) {
        this.subtract();
    }

    @FXML
    void btnMultiplyOnActionHandler(ActionEvent event) {
        this.multiply();
    }

    @FXML
    void btnNineOnActionHandler(ActionEvent event) {
        if (this.previousOperation == ' ')
        {
            this.mathString1 += '9';
            this.txtLane.setText(this.mathString1);
        }
        else
        {
            this.mathString2 += '9';
            this.txtLane.setText(this.mathString2);
        }
    }

    @FXML
    void btnOFFOnActionHandler(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnOneOnActionHandler(ActionEvent event) {
        if (this.previousOperation == ' ')
        {
            this.mathString1 += '1';
            this.txtLane.setText(this.mathString1);
        }
        else
        {
            this.mathString2 += '1';
            this.txtLane.setText(this.mathString2);
        }
    }

    @FXML
    void btnPlusOnActionHandler(ActionEvent event) {
        this.sum();
    }

    @FXML
    void btnSevenOnActionHandler(ActionEvent event) {
        if (this.previousOperation == ' ')
        {
            this.mathString1 += '7';
            this.txtLane.setText(this.mathString1);
        }
        else
        {
            this.mathString2 += '7';
            this.txtLane.setText(this.mathString2);
        }
    }

    @FXML
    void btnSixOnActionHandler(ActionEvent event) {
        if (this.previousOperation == ' ')
        {
            this.mathString1 += '6';
            this.txtLane.setText(this.mathString1);
        }
        else
        {
            this.mathString2 += '6';
            this.txtLane.setText(this.mathString2);
        }
    }

    @FXML
    void btnThreeOnActionHandler(ActionEvent event) {
        if (this.previousOperation == ' ')
        {
            this.mathString1 += '3';
            this.txtLane.setText(this.mathString1);
        }
        else
        {
            this.mathString2 += '3';
            this.txtLane.setText(this.mathString2);
        }
    }

    @FXML
    void btnTwoOnActionHandler(ActionEvent event) {
        if (this.previousOperation == ' ')
        {
            this.mathString1 += '2';
            this.txtLane.setText(this.mathString1);
        }
        else
        {
            this.mathString2 += '2';
            this.txtLane.setText(this.mathString2);
        }
    }

    @FXML
    void btnZeroOnActionHandler(ActionEvent event) {
        if (this.previousOperation == ' ')
        {
            this.mathString1 += '0';
            this.txtLane.setText(this.mathString1);
        }
        else
        {
            this.mathString2 += '0';
            this.txtLane.setText(this.mathString2);
        }
    }

    @FXML
    void btnZeroZeroOnActionHandler(ActionEvent event) {
        if (this.previousOperation == ' ')
        {
            this.mathString1 += "00";
            this.txtLane.setText(this.mathString1);
        }
        else
        {
            this.mathString2 += "00";
            this.txtLane.setText(this.mathString2);
        }
    }

    @FXML
    void initialize() {
        assert btnC != null : "fx:id=\"btnC\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnCA != null : "fx:id=\"btnCA\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnDivide != null : "fx:id=\"btnDivide\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnDot != null : "fx:id=\"btnDot\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnEight != null : "fx:id=\"btnEight\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnEquals != null : "fx:id=\"btnEquals\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnFive != null : "fx:id=\"btnFive\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnFour != null : "fx:id=\"btnFour\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnMinus != null : "fx:id=\"btnMinus\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnMultiply != null : "fx:id=\"btnMultiply\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnNine != null : "fx:id=\"btnNine\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnOFF != null : "fx:id=\"btnOFF\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnOne != null : "fx:id=\"btnOne\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnPlus != null : "fx:id=\"btnPlus\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnSeven != null : "fx:id=\"btnSeven\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnSix != null : "fx:id=\"btnSix\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnThree != null : "fx:id=\"btnThree\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnTwo != null : "fx:id=\"btnTwo\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnZero != null : "fx:id=\"btnZero\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnZeroZero != null : "fx:id=\"btnZeroZero\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert txtLane != null : "fx:id=\"txtLane\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

    private void sum()
    {
        this.calculate('+');
    }

    private void subtract()
    {
       this.calculate('-');
    }

    private void multiply()
    {
        this.calculate('*');
    }

    private void divide()
    {
        this.calculate('/');
    }

    private void calculate(char previousOperation)
    {
        switch (this.previousOperation)
        {
            case '+':
                this.previousOperation = previousOperation;
                if (!this.mathString2.equals(""))
                    this.rightNumber = Double.parseDouble(this.mathString2);

                this.mathString1 = String.valueOf(this.leftNumber + this.rightNumber);
                this.mathString2 = "";
                this.txtLane.setText(this.mathString1);
                if (this.mathString1 != null && !this.mathString1.equals(""))
                    this.leftNumber = Double.parseDouble(this.mathString1);

                else
                    this.leftNumber = 0;

                if (this.mathString2.equals(""))
                    return;

                this.rightNumber = Double.parseDouble(this.mathString2);
                this.mathString1 = String.valueOf(this.leftNumber + this.rightNumber);
                this.mathString2 = "";
                this.txtLane.setText(this.mathString1);
                break;
            case '-':
                this.previousOperation = previousOperation;
                if (!this.mathString2.equals(""))
                    this.rightNumber = Double.parseDouble(this.mathString2);

                this.mathString1 = String.valueOf(this.leftNumber - this.rightNumber);
                this.mathString2 = "";
                this.txtLane.setText(this.mathString1);
                if (this.mathString1 != null && !this.mathString1.equals(""))
                    this.leftNumber = Double.parseDouble(this.mathString1);

                else
                    this.leftNumber = 0;

                if (this.mathString2.equals(""))
                    return;

                this.rightNumber = Double.parseDouble(this.mathString2);
                this.mathString1 = String.valueOf(this.leftNumber - this.rightNumber);
                this.mathString2 = "";
                this.txtLane.setText(this.mathString1);
                break;
            case '*':
                this.previousOperation = previousOperation;
                if (!this.mathString2.equals(""))
                    this.rightNumber = Double.parseDouble(this.mathString2);

                this.mathString1 = String.valueOf(this.leftNumber * this.rightNumber);
                this.mathString2 = "";
                this.txtLane.setText(this.mathString1);
                if (this.mathString1 != null && !this.mathString1.equals(""))
                    this.leftNumber = Double.parseDouble(this.mathString1);

                else
                    this.leftNumber = 0;

                if (this.mathString2.equals(""))
                    return;

                this.rightNumber = Double.parseDouble(this.mathString2);
                this.mathString1 = String.valueOf(this.leftNumber * this.rightNumber);
                this.mathString2 = "";
                this.txtLane.setText(this.mathString1);
                break;
            case '/':
                this.previousOperation = previousOperation;
                if (!this.mathString2.equals(""))
                    this.rightNumber = Double.parseDouble(this.mathString2);

               if (this.rightNumber == 0)
               {
                   this.mathString1 = "";
                   this.mathString2 = "";
                   this.previousOperation = ' ';
                   this.leftNumber = 0;
                   this.rightNumber = 0;
                   this.txtLane.setText("Cannot divide by 0!");
                   return;
               }

                this.mathString1 = String.valueOf(this.leftNumber / this.rightNumber);
                this.mathString2 = "";
                this.txtLane.setText(this.mathString1);
                if (this.mathString1 != null && !this.mathString1.equals(""))
                    this.leftNumber = Double.parseDouble(this.mathString1);

                else
                    this.leftNumber = 0;

                if (this.mathString2.equals(""))
                    return;

                this.rightNumber = Double.parseDouble(this.mathString2);
                if (this.rightNumber == 0)
                {
                    this.mathString1 = "";
                    this.mathString2 = "";
                    this.previousOperation = ' ';
                    this.leftNumber = 0;
                    this.rightNumber = 0;
                    this.txtLane.setText("Cannot divide by 0!");
                    return;
                }

                this.mathString1 = String.valueOf(this.leftNumber / this.rightNumber);
                this.mathString2 = "";
                this.txtLane.setText(this.mathString1);
                break;
            case ' ':
                this.previousOperation = previousOperation;
                this.txtLane.setText("");
                if (this.mathString1 != null && !this.mathString1.equals(""))
                    this.leftNumber = Double.parseDouble(this.mathString1);

                else
                    this.leftNumber = 0;
        }
    }
}
