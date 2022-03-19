package fmi.poop.zad2;

import java.util.Scanner;

public class Number
{
    private static int originalNumber;
    private static String resultString;
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a five-digit number: ");
        originalNumber = input.nextInt();
        int firstDigit = originalNumber / 10000;
        int secondDigit = (originalNumber / 1000) % 10;
        int thirdDigit = (originalNumber / 100) % 10;
        int fourthDigit = (originalNumber / 10) % 10;
        int fifthDigit = originalNumber % 10;

        if (firstDigit < 1)
        {
            System.out.println("The number is not 5 digit");
            return;
        }

        if (firstDigit == fifthDigit)
        {
            System.out.println("First and last digits are identical.");
        }
        else
        {
            System.out.println("First and last digits are not identical.");
        }

        if (secondDigit == fourthDigit)
        {
            System.out.println("Second and fourth digits are identical.");
        }
        else
        {
            System.out.println("Second and fourth digits are not identical.");
        }

        if (firstDigit == fifthDigit && secondDigit == fourthDigit)
        {
            resultString = "The number is palindrome";
            System.out.println("The number is palindrome.");
        }
        else
        {
            System.out.println("The number is not palindrome.");
        }
    }
}
