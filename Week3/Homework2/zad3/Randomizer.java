package fmi.poop.zad3;

import java.text.NumberFormat;

public class Randomizer {
    private static int drawRandomNumber()
    {
        double number = Math.random();
        System.out.print(NumberFormat.getPercentInstance().format(number) + " -> ");

        if (number >= 0.01 && number <= 0.2)
            return 1;

        if (number > 0.2 && number <= 0.5)
            return 2;

        return 3;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++)
            System.out.println(drawRandomNumber());
    }
}
