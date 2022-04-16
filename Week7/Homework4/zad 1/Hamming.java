package fmi.poop.zad1;

import java.util.Scanner;

public class Hamming
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Input two 8 bit numbers (from 0 to 255).");
        String number1, number2;
        System.out.print("Input the first number: ");
        number1 = input.nextLine();

        while (Integer.parseInt(number1) < 0 || Integer.parseInt(number1) > 255)
        {
            System.out.print("Incorrect input! The number is not 8 bit! Input again: ");
            number1 = input.nextLine();
        }

        System.out.print("Input the second number: ");
        number2 = input.nextLine();

        while (Integer.parseInt(number2) < 0 || Integer.parseInt(number2) > 255)
        {
            System.out.print("Incorrect input! The number is not 8 bit! Input again: ");
            number2 = input.nextLine();
        }

        String number1Binary = Integer.toBinaryString(Integer.parseInt(number1));
        String number2Binary = Integer.toBinaryString(Integer.parseInt(number2));
        int num1BinaryLength = number1Binary.length();
        int num2BinaryLength = number2Binary.length();
        int count = 0; // Helper counter

        if (num1BinaryLength < 8) // Checking if the length of the bits of the first binary number displayed is 8
        {
            count = num1BinaryLength;
            while (count < 8)
            {
                number1Binary = '0' + number1Binary;
                count++;
            }
        }

        if (num2BinaryLength < 8) // The same as the above
        {
            count = num2BinaryLength;
            while (count < 8)
            {
                number2Binary = '0' + number2Binary;
                count++;
            }
        }

        char[] num1BinaryChar = number1Binary.toCharArray();
        char[] num2BinaryChar = number2Binary.toCharArray();
        count = 0;
        for (int i = 0; i < 8; i++)
        {
            if (num1BinaryChar[i] != num2BinaryChar[i]) // Counting the bit position differences, because that is the Hamming distance
                count++;
        }

        System.out.println("Number 1 in Decimal state: " + number1);
        System.out.println("Number 2 in Decimal state: " + number2);
        System.out.println("Number 1 in Binary state: " + number1Binary);
        System.out.println("Number 2 in Binary state: " + number2Binary);
        System.out.println("Hamming distance between them (Bit position differences): " + count);
    }
}
