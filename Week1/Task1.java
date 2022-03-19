package fmi.poop.zad1;

import java.util.Scanner;

public class Task1
{
    private static double fahrenheit;
    private static double celsius;

    public static void zad1a()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Input fahrenheit temperature: ");
        fahrenheit = input.nextDouble();
        celsius = 5.0 / 9.0 * (fahrenheit - 32.0);
        System.out.println("Celsius temperature: ");
        System.out.println(celsius);
    }

    public static void zad1b()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Input celsius temperature: ");
        celsius = input.nextDouble();
        fahrenheit = 9.0 / 5.0 * celsius + 32.0;
        System.out.println("Fahrenheit temperature: ");
        System.out.println(fahrenheit);
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Input 1 to transfer from fahrenheit to celsius or input 2 otherwise: ");
        int choice;
        choice = input.nextInt();
        if(choice == 1)
        {
            Task1.zad1a();
        }
        else
            if(choice == 2)
            {
                Task1.zad1b();
            }
            else
                System.out.println("Invalid Input!\n");
    }
}
