package com.example.spiral;

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
        int RANGE = 25; // Range between the lines
        int LENGTH = RANGE; // Length of the lines
        Group group = new Group();
        Scene scene = new Scene(group, 600, 600);
        double width = scene.getWidth();
        double height = scene.getHeight();
        double xB = width / 2, xE = height / 2, yB = xB, yE = xE + RANGE; // xB = x Beginning point, xE = x Ending point (The same for y)
        while(xB > 0 && xB < width && yE > 0 && yE < height)
        {
            Line line1 = new Line(xB, xE, yB, yE);
            line1.setStroke(Color.DARKORANGE);
            line1.setStrokeWidth(2);
            group.getChildren().add(line1);

            xE = yE;
            yB -= LENGTH;
            Line line2 = new Line(xB , xE, yB, yE);
            line2.setStroke(Color.DARKORANGE);
            line2.setStrokeWidth(2);
            group.getChildren().add(line2);

            xB = yB;
            xE = yE;
            LENGTH += RANGE;
            yE -= LENGTH;
            Line line3 = new Line(xB, xE, yB, yE);
            line3.setStroke(Color.DARKORANGE);
            line3.setStrokeWidth(2);
            group.getChildren().add(line3);

            xB = yB;
            xE = yE;
            yB += LENGTH;
            Line line4 = new Line(xB, xE, yB, yE);
            line4.setStroke(Color.DARKORANGE);
            line4.setStrokeWidth(2);
            group.getChildren().add(line4);

            xB = yB;
            xE = yE;
            LENGTH += RANGE;
            yE += LENGTH;
        }
        stage.setTitle("Squared Spiral");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}