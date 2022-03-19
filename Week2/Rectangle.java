package fmi.poop.zad1;

public class Rectangle {
    private double width;
    private double height;
    private String color;

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
        color = "None";
    }

    public Rectangle() {
        width = 1;
        height = 1;
        color = "Green";
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        if (width > 0)
            this.width = width;
        else
            this.width = 1;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        if (height > 0)
            this.height = height;
        else
            this.height = 1;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        if (color != null)
            this.color = color;
        else
            System.out.println("Color argument cannot be null!\n");
    }

    public double getArea() {
        return this.height * this.width;
    }

    public double getPerimeter() {
        return 2 * (this.height + this.width);
    }
}
