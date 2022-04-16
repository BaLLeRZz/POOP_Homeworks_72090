package geometry.zad1ab;

import java.util.Arrays;

public class Point {
    private double[] coordinates;

    public Point(double[] coordinates) {
        this.setCoordinates(coordinates);
    }

    public Point() {
        this(new double[]{0.0, 0.0});
    }

    public Point(Point point)
    {
        this(point.coordinates);
    }

    public double[] getCoordinates() {
        double[] copy = new double[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            copy[i] = coordinates[i];
        }

        return copy;
    }

    public void setCoordinates(double[] coordinates) {
        if (coordinates != null && coordinates.length == 2)
        {
            this.coordinates = new double[2];
            for (int i = 0; i < 2; i++)
                this.coordinates[i] = coordinates[i];
        }
        else
            this.coordinates = new double[]{0.0, 0.0};
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", coordinates[0], coordinates[1]);
    }
}

