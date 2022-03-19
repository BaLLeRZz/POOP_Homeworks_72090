package com.example.circle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Optional;

public class Geometry extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Scene scene = new Scene(group, 320, 240);
        double width = scene.getWidth();
        double height = scene.getHeight();
        double centerX = width / 2;
        double centerY = height / 2;
        double radius = Math.min(width, height) / 3;
        Circle circle = new Circle(centerX, centerY, radius);
        group.getChildren().add(circle);
        circle.setFill(null);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);
        double lineX = getLineX(width);
        Line line = new Line(lineX, 0, lineX, height);
        line.setStroke(Color.RED);
        group.getChildren().add(line);
        double chSquare = radius * radius - (centerX - lineX) * (centerX - lineX);
        if (chSquare >= 0)
        {
            double crossPoint1 = centerY - Math.sqrt(chSquare);
            this.smallCircle(lineX, crossPoint1, group);
            if (chSquare > 0)
            {
                double crossPoint2 = centerY + Math.sqrt(chSquare);
                this.smallCircle(lineX, crossPoint2, group);
            }
        }
        else
        {
            this.showAlert();
            Platform.exit();
        }
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    private double getLineX(double width)
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Prompt");
        dialog.setContentText("Input X: ");
        boolean invalid = true;
        double x = 0;
        do {
            Optional<String> userInput = dialog.showAndWait();
            if (userInput.isPresent()) {
                x = Double.parseDouble(userInput.get());
                if (x >= 0 && x <= width)
                    invalid = false;
                else
                    showError();
            }
            else
                invalid = false;
        }
        while (invalid);
        return x;
    }
    private void showAlert()
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Problem");
        alert.setContentText("No intersection!");
        alert.showAndWait();
    }
    private void smallCircle(double x, double y, Group group)
    {
        Circle circle = new Circle(x, y, 5);
        Text text = new Text(x + 10, y, String.format("(%.2f, %.2f)", x, y));
        group.getChildren().add(circle);
        group.getChildren().add(text);
    }
    private void showError()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Problem");
        alert.setContentText("Input x with bounds.");
        alert.showAndWait();
    }
}