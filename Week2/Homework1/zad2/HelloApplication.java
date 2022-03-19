package com.example.canvas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Scene scene = new Scene(group, 600, 600);
        final int RANGE = 20; // Range between the lines
        double height = scene.getHeight();
        double width = scene.getWidth();
        double xB = 0, xE = 0, yB = 0, yE = 0; // xB = x Beginning point, xE = x Ending point (The same for y)
        double widthRange; // Range between the width points of the lines
        double heightRange; // Range between the height points of the lines
        if (width > height) // Determining the proportion between the width and the height
        {
            widthRange = width / height;
            heightRange = 1;
        }
        else
        {
            heightRange = height / width;
            widthRange = 1;
        }
        int count = 1; // Counter for each edge of the scene
        while (count < 5) // Cycling until all 4 edges of the scene are covered
        {
            if ((xB < width || yE < height) && count == 1)
            {
                Line line = new Line(xB, 0, width, yE);
                line.setStroke(Color.DARKORANGE);
                line.setStrokeWidth(2);
                group.getChildren().add(line);
                xB += RANGE * widthRange;
                yE += RANGE * heightRange;
                continue;
            }

            if (xB >= width && yE >= height && count == 1)
            {
                count++;
                yB = width;
            }

            if ((xE < height || yB > 0) && count == 2)
            {
                Line line = new Line(width, xE, yB, height);
                line.setStroke(Color.DARKORANGE);
                line.setStrokeWidth(2);
                group.getChildren().add(line);
                xE += RANGE * heightRange;
                yB -= RANGE * widthRange;
                continue;
            }

            if (xE >= height && yB <= 0 && count == 2)
            {
                count++;
                xB = width;
                yE = height;
            }

            if ((xB > 0 || yE > 0) && count == 3)
            {
                Line line = new Line(xB, height, 0, yE);
                line.setStroke(Color.DARKORANGE);
                line.setStrokeWidth(2);
                xB -= RANGE * widthRange;
                yE -= RANGE * heightRange;
                group.getChildren().add(line);
                continue;
            }

            if (xB <= 0 && yE <= 0 && count == 3)
            {
                count++;
                xE = height;
                yB = 0;
            }

            if ((xE > 0 || yB < width) && count == 4)
            {
                Line line = new Line(0, xE, yB, 0);
                line.setStroke(Color.DARKORANGE);
                line.setStrokeWidth(2);
                group.getChildren().add(line);
                xE -= RANGE * heightRange;
                yB += RANGE * widthRange;
                continue;
            }

            if (xE <= 0 && yB >= width && count == 4)
                break;
        }
        stage.setTitle("Canvas Drawing");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}