package com.example.calendar;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Scene scene = new Scene(group, 600, 400);
        int month = this.getMonth();
        int year = this.getYear();
        double rangeWidth = scene.getWidth() / 8.5; // Width range between the days in the calendar
        double rangeHeight = scene.getHeight() / 4; // Height range between the days in the calendar
        Text day1 = new Text(rangeWidth, rangeHeight, "Пн"); // dayN of the week
        day1.setFont(Font.font("", FontWeight.BOLD, 20));
        group.getChildren().add(day1);
        Text day2 = new Text(rangeWidth * 2, rangeHeight, "Вт");
        day2.setFont(Font.font("", FontWeight.BOLD, 20));
        group.getChildren().add(day2);
        Text day3 = new Text(rangeWidth * 3, rangeHeight, "Ср");
        day3.setFont(Font.font("", FontWeight.BOLD, 20));
        group.getChildren().add(day3);
        Text day4 = new Text(rangeWidth * 4, rangeHeight, "Чт");
        day4.setFont(Font.font("", FontWeight.BOLD, 20));
        group.getChildren().add(day4);
        Text day5 = new Text(rangeWidth * 5, rangeHeight, "Пт");
        day5.setFont(Font.font("", FontWeight.BOLD, 20));
        group.getChildren().add(day5);
        Text day6 = new Text(rangeWidth * 6, rangeHeight, "Сб");
        day6.setFont(Font.font("", FontWeight.BOLD, 20));
        group.getChildren().add(day6);
        Text day7 = new Text(rangeWidth * 7, rangeHeight, "Нд");
        day7.setFont(Font.font("", FontWeight.BOLD, 20));
        group.getChildren().add(day7);
        LocalDate tempDate = LocalDate.of(year, month, 1); // Temporary date for getting the month length
        int lengthMonth = tempDate.lengthOfMonth(); // getting the month length for the loop below
        rangeHeight += 30; // Starting from below the days of the week
        for (int i = 1; i <= lengthMonth; i++)
        {
            LocalDate date = LocalDate.of(year, month, i);
            if (date.getDayOfWeek() == DayOfWeek.MONDAY)
            {
                Text day = new Text(rangeWidth + 5, rangeHeight, i + "");
                day.setFont(Font.font("",15));
                if (date.isEqual(LocalDate.now()))
                {
                    day.setFont(Font.font("", FontWeight.BOLD, 15));
                    day.setStroke(Color.RED);
                }
                group.getChildren().add(day);
            }

            if (date.getDayOfWeek() == DayOfWeek.TUESDAY)
            {
                Text day = new Text(rangeWidth * 2 + 5, rangeHeight, i + "");
                day.setFont(Font.font("",15));
                if (date.isEqual(LocalDate.now()))
                {
                    day.setFont(Font.font("", FontWeight.BOLD, 15));
                    day.setStroke(Color.RED);
                }
                group.getChildren().add(day);
            }

            if (date.getDayOfWeek() == DayOfWeek.WEDNESDAY)
            {
                Text day = new Text(rangeWidth * 3 + 5, rangeHeight, i + "");
                day.setFont(Font.font("",15));
                if (date.isEqual(LocalDate.now()))
                {
                    day.setFont(Font.font("", FontWeight.BOLD, 15));
                    day.setStroke(Color.RED);
                }
                group.getChildren().add(day);
            }

            if (date.getDayOfWeek() == DayOfWeek.THURSDAY)
            {
                Text day = new Text(rangeWidth * 4 + 5, rangeHeight, i + "");
                day.setFont(Font.font("",15));
                if (date.isEqual(LocalDate.now()))
                {
                    day.setFont(Font.font("", FontWeight.BOLD, 15));
                    day.setStroke(Color.RED);
                }
                group.getChildren().add(day);
            }

            if (date.getDayOfWeek() == DayOfWeek.FRIDAY)
            {
                Text day = new Text(rangeWidth * 5 + 5, rangeHeight, i + "");
                day.setFont(Font.font("",15));
                if (date.isEqual(LocalDate.now()))
                {
                    day.setFont(Font.font("", FontWeight.BOLD, 15));
                    day.setStroke(Color.RED);
                }
                group.getChildren().add(day);
            }

            if (date.getDayOfWeek() == DayOfWeek.SATURDAY)
            {
                Text day = new Text(rangeWidth * 6 + 5, rangeHeight, i + "");
                day.setFont(Font.font("",15));
                if (date.isEqual(LocalDate.now()))
                {
                    day.setFont(Font.font("", FontWeight.BOLD, 15));
                    day.setStroke(Color.RED);
                }
                group.getChildren().add(day);
            }

            if (date.getDayOfWeek() == DayOfWeek.SUNDAY)
            {
                Text day = new Text(rangeWidth * 7 + 5, rangeHeight, i + "");
                day.setFont(Font.font("",15));
                if (date.isEqual(LocalDate.now()))
                {
                    day.setFont(Font.font("", FontWeight.BOLD, 15));
                    day.setStroke(Color.RED);
                }
                group.getChildren().add(day);
                rangeHeight += 30;
            }
        }
        stage.setTitle("Calendar For " + tempDate.getMonth() + " " + year);
        stage.setScene(scene);
        stage.show();
    }

    private int getMonth() // Function for month input
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Prompt");
        dialog.setContentText("Input month number: ");
        boolean invalid = true;
        int month = 0;
        do {
            Optional<String> userInput = dialog.showAndWait();
            if (userInput.isPresent()) {
                month = Integer.parseInt(userInput.get());
                if (month > 0 && month < 13)
                    invalid = false;
                else
                    showErrorMonth();
            }
            else
                invalid = false;
        }
        while (invalid);
        return month;
    }

    private int getYear() // Function for year input
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Prompt");
        dialog.setContentText("Input year: ");
        boolean invalid = true;
        int year = 0;
        do {
            Optional<String> userInput = dialog.showAndWait();
            if (userInput.isPresent()) {
                year = Integer.parseInt(userInput.get());
                if (year > 0)
                    invalid = false;
                else
                    showErrorYear();
            }
            else
                invalid = false;
        }
        while (invalid);
        return year;
    }

    private void showErrorMonth() // Function for showing an error message if the month input is incorrect
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Problem");
        alert.setContentText("Input the month within bounds! (1 - 12)");
        alert.showAndWait();
    }

    private void showErrorYear() // Function for showing an error message if the year input is incorrect
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Problem");
        alert.setContentText("The Year must be > 0");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}