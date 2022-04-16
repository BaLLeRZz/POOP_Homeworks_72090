package fmi.poop.zad2a;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CeaserCipherTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CeaserCipher ceaserCipher = new CeaserCipher();
        System.out.println("1.Encrypt\n2.Decrypt\nEnter choice: ");
        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1)
        {
            System.out.println("Enter a word: ");
            String plainText = input.nextLine();
            System.out.println("Encrypted text: " + ceaserCipher.encrypt(plainText));
        }
        else
            if (choice == 2)
            {
                System.out.println("Enter a word: ");
                String encryptedText = input.nextLine();
                System.out.println("Encrypted text: " + ceaserCipher.decrypt(encryptedText));
            }
            else
                System.out.println("Incorrect choice input.");
    }
}
