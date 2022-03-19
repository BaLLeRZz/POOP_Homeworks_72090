package fmi.poop.zad1;

import java.util.Scanner;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle();
        Scanner input = new Scanner(System.in);
        System.out.println("Input rectangle height: ");
        double height;
        height = input.nextDouble();
        System.out.println("Input rectangle width: ");
        double width;
        width = input.nextDouble();
        String color = "Green";
        rec.setHeight(height);
        rec.setWidth(width);
        rec.setColor(color);
        System.out.println("Rectangle Area: " + rec.getArea());
        System.out.println("Rectangle Perimeter: " + rec.getPerimeter());
    }
}
