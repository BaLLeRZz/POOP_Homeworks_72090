package fmi.poop.zad3;

import java.util.Scanner;

public class Transfer
{
    private static int number;
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Input a four-digit number to encrypt: ");
        number = input.nextInt();
        int firstDigit = number / 1000;
        int secondDigit = (number / 100) % 10;
        int thirdDigit = (number / 10) % 10;
        int fourthDigit = number % 10;
        if (number < 1000 || number > 9999)
        {
            System.out.println("The number is not four-digit!\n");
            return;
        }
        firstDigit = (firstDigit + 7) % 10;
        secondDigit = (secondDigit + 7) % 10;
        thirdDigit = (thirdDigit + 7) % 10;
        fourthDigit = (fourthDigit + 7) % 10;
        int tempDigit;
        tempDigit = firstDigit;
        firstDigit = thirdDigit;
        thirdDigit = tempDigit;
        tempDigit = secondDigit;
        secondDigit = fourthDigit;
        fourthDigit = tempDigit;
        number = firstDigit * 1000 + secondDigit * 100 + thirdDigit * 10 + fourthDigit;
        System.out.println("Encrypted number: " + number);
        System.out.println("Input a four-digit number to decrypt: ");
        number = input.nextInt();
        firstDigit = number / 1000;
        secondDigit = (number / 100) % 10;
        thirdDigit = (number / 10) % 10;
        fourthDigit = number % 10;
        if (number < 1000 || number > 9999)
        {
            System.out.println("The number is not four-digit!\n");
            return;
        }
        tempDigit = firstDigit;
        firstDigit = thirdDigit;
        thirdDigit = tempDigit;
        tempDigit = secondDigit;
        secondDigit = fourthDigit;
        fourthDigit = tempDigit;
        firstDigit = (firstDigit + 3) % 10;
        secondDigit = (secondDigit + 3) % 10;
        thirdDigit = (thirdDigit + 3) % 10;
        fourthDigit = (fourthDigit + 3) % 10;
        number = firstDigit * 1000 + secondDigit * 100 + thirdDigit * 10 + fourthDigit;
        System.out.println("Decrypted number: " + number);
    }
}
