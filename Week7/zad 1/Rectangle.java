package geometry.zad1ab;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Rectangle {
    private Point uPoint;
    private double width;
    private double height;

    public Rectangle(Point uPoint, double width, double height) {
        this.setuPoint(uPoint);
        this.setHeight(height);
        this.setWidth(width);
    }

    public Rectangle() {
        this(new Point(), 1, 1);
    }

    public Rectangle(Rectangle rectangle)
    {
        this(rectangle.uPoint, rectangle.width, rectangle.height);
    }

    public Point getuPoint() {
        return new Point(uPoint);
    }

    public void setuPoint(Point uPoint) {
        if (uPoint != null)
            this.uPoint = new Point(uPoint);
        else
            this.uPoint = new Point();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0)
            this.width = width;
        else
            this.width = 1;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0)
            this.height = height;
        else
            this.height = 1;
    }

    public void draw(Group pane)
    {
        double x = uPoint.getCoordinates()[0];
        double y = uPoint.getCoordinates()[1];
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(x, y, width, height);
        rectangle.setFill(null);
        rectangle.setStroke(Color.BLACK);
        pane.getChildren().add(rectangle);
    }

    @Override
    public String toString() {
        return String.format("Point: %s, width: %.2f, height: %.2f", uPoint.toString(), width, height);
    }
}
