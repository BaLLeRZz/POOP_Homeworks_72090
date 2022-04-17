package fmi.poop.hwk3;

import java.util.Scanner;

public class RouteCipher
{
    private int key;

    public RouteCipher(int key)
    {
        this.setKey(key);
    }

    public int getKey()
    {
        return this.key;
    }

    public void setKey(int key)
    {
        if (key != 0)
        {
            this.key = key;
            System.out.println("The key's value is set to " + this.key);
        }
        else
        {
            Scanner input = new Scanner(System.in);
            System.out.println("The key cannot be 0!");
            System.out.print("Input key value: ");
            do
            {
                key = input.nextInt();
                if (key == 0)
                    System.out.print("The key cannot be 0. Input again: ");
                else
                {
                    this.key = key;
                    System.out.println("The key's value is set to " + this.key);
                }
            }
            while (key == 0);
        }
    }

    public String encrypt(String plainText)
    {
        boolean choseRows = false; // Variable to determine whether the key is for rows or columns
        boolean fromTopLeft = this.key > 0; // Determining whether the route will be from the top left or the bottom right corner
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.print("What does the key refer to? Input 1 for rows or 2 for columns: ");

        do
        {
            choice = input.nextInt();
            if (choice == 1)
            {
                choseRows = true;
                System.out.println("The key has been set for rows.");
                break;
            }

            if (choice == 2)
            {
                System.out.println("The key has been set for columns.");
                break;
            }

            System.out.print("Incorrect input! Input again: ");
        }
        while (choice != 1 && choice != 2);

        char [] plainTextChars = plainText.toCharArray();
        String fixedText = ""; // String for getting only the letters of a message
        int plainTextLength = plainTextChars.length;

        for (int i = 0; i < plainTextLength; i++)
            if ((plainTextChars[i] >= 'a' && plainTextChars[i] <= 'z') || (plainTextChars[i] >= 'A' && plainTextChars[i] <= 'Z'))
                fixedText += plainTextChars[i];

        char[] fixedTextChars = fixedText.toCharArray();
        int fixedTextLength = fixedTextChars.length;
        int keyCopy = Math.abs(key);
        int columnNumber = 0;
        int count = 0; // Helper counter
        String encryptedText = "";

        if (choseRows)
        {
            columnNumber = (int) Math.ceil((double) fixedTextLength / keyCopy);
            count = fixedTextLength - keyCopy * columnNumber;
            while (count < 0) // Filling the blank spaces with "X"
            {
                fixedText += 'X';
                count++;
            }

            fixedTextChars = fixedText.toCharArray(); // Getting the new message with the added "X" letters
            fixedTextLength = fixedTextChars.length;
        }
        else
        {
            columnNumber = keyCopy;
            count = fixedTextLength - keyCopy * (int) Math.ceil((double) fixedTextLength / keyCopy);
            while (count < 0)
            {
                fixedText += 'X';
                count++;
            }

            fixedTextChars = fixedText.toCharArray(); // Getting the new message with the added "X" letters
            fixedTextLength = fixedTextChars.length;
        }

        System.out.println("Plain text: " + plainText);
        System.out.println("Text table:");
        for (int i = 0; i < fixedTextLength; i++) // Cycle to print out all the letters in the message
        {
            if (count == columnNumber)
            {
                System.out.println();
                count = 0;
            }
            System.out.print(fixedTextChars[i] + " ");
            count++;
        }

        if (fromTopLeft)
        {
            count = 0;
            int lettersCount = 0; // Variable for counting how many letters of the message we got
            int fixedTextLengthCopy = fixedTextLength; // Copying the text length so we can change it
            int topRightCorner = 1; // Variable to help calculating the top right corners
            int topLeftCorner = 1; // Variable to help calculating the top left corners

            while (lettersCount < fixedTextLength) // Cycling until we have all letters from the message
            {
                while (count < fixedTextLengthCopy && lettersCount < fixedTextLength) // Cycle for the left side of the text rectangle
                {
                    encryptedText += fixedTextChars[count];
                    lettersCount++;
                    count += columnNumber;
                }
                count -= columnNumber - 1;

                while (count < fixedTextLengthCopy && lettersCount < fixedTextLength) // Cycle for the bottom side of the text rectangle
                {
                    encryptedText += fixedTextChars[count];
                    lettersCount++;
                    count++;
                }
                count -= columnNumber + 1;

                while (count >= topRightCorner * columnNumber - topRightCorner && lettersCount < fixedTextLength) // Cycle for the right side of the text rectangle
                {
                    encryptedText += fixedTextChars[count];
                    lettersCount++;
                    count -= columnNumber;
                }
                count += columnNumber - 1;

                while (count >= topLeftCorner && lettersCount < fixedTextLength) // Cycle for the top side of the text rectangle
                {
                    encryptedText += fixedTextChars[count];
                    lettersCount++;
                    count--;
                }

                fixedTextLengthCopy -= columnNumber + 1;
                topRightCorner++;
                topLeftCorner += columnNumber + 1;
                count += columnNumber + 1;
            }
        }
        else
        {
            count = fixedTextLength - 1;
            int lettersCount = 0;
            int fixedTextLengthCopy = fixedTextLength;
            int topRightCorner = 1;
            int topLeftCorner = 0;

            while (lettersCount < fixedTextLength)
            {
                while (count >= topRightCorner * columnNumber - topRightCorner && lettersCount < fixedTextLength) // Cycle for the right side of the text rectangle
                {
                    encryptedText += fixedTextChars[count];
                    lettersCount++;
                    count -= columnNumber;
                }
                count += columnNumber - 1;

                while (count >= topLeftCorner && lettersCount < fixedTextLength) // Cycle for the top side of the text rectangle
                {
                    encryptedText += fixedTextChars[count];
                    lettersCount++;
                    count--;
                }
                count += columnNumber + 1;

                while (count < fixedTextLengthCopy && lettersCount < fixedTextLength) // Cycle for the left side of the text rectangle
                {
                    encryptedText += fixedTextChars[count];
                    lettersCount++;
                    count += columnNumber;
                }
                count -= columnNumber - 1;

                while (count < fixedTextLengthCopy - 1 && lettersCount < fixedTextLength) // Cycle for the bottom side of the text rectangle
                {
                    encryptedText += fixedTextChars[count];
                    lettersCount++;
                    count++;
                }

                fixedTextLengthCopy -= columnNumber + 1;
                topRightCorner++;
                topLeftCorner += columnNumber + 1;
                count -= columnNumber + 1;
            }
        }

        System.out.print("\n\nEncrypted text: ");
        return encryptedText;
    }

    public String decrypt(String cipherText)
    {
        char [] encryptedTextChars = cipherText.toCharArray();
        int encryptedTextLength = encryptedTextChars.length;
        for (int i = 0; i < encryptedTextLength; i++) // Cycle to check if the encrypted text is correct
            if (!(encryptedTextChars[i] >= 'a' && encryptedTextChars[i] <= 'z') && !(encryptedTextChars[i] >= 'A' && encryptedTextChars[i] <= 'Z'))
                return "Incorrect encrypted text!";

        int keyCopy = Math.abs(this.key);
        if ((int) Math.ceil((double) encryptedTextLength / keyCopy) * keyCopy != encryptedTextLength) // Checking if the size of the text table and the size of the text match
        {
            do
            {
                System.out.println("The size of the text table does not match the size of the encrypted text! Input the key again!");
                this.setKey(0);
                keyCopy = Math.abs(this.key);
            }
            while ((int) Math.ceil((double) encryptedTextLength / keyCopy) * keyCopy != encryptedTextLength);
        }

        int choice;
        Scanner input = new Scanner(System.in);
        boolean choseRows = false; // Variable to determine whether the key is for rows or columns
        System.out.print("What does the key refer to? Input 1 for rows or 2 for columns: ");

        do
        {
            choice = input.nextInt();
            if (choice == 1)
            {
                choseRows = true;
                System.out.println("The key has been set for rows.");
                break;
            }

            if (choice == 2)
            {
                System.out.println("The key has been set for columns.");
                break;
            }

            System.out.print("Incorrect input! Input again: ");
        }
        while (choice != 1 && choice != 2);

        boolean fromTopLeft = this.key > 0; // Determining whether the route will be from the top left or the bottom right corner
        int columnNumber = 0;
        int rowNumber = 0;
        int count = 0;

        if (choseRows)
        {
            rowNumber = keyCopy;
            columnNumber = (int) Math.ceil((double) encryptedTextLength / keyCopy);
        }
        else
        {
            rowNumber = (int) Math.ceil((double) encryptedTextLength / keyCopy);
            columnNumber = keyCopy;
        }

        System.out.println("Encrypted text: " + cipherText);
        System.out.println("Encrypted text table:");
        for (int i = 0; i < encryptedTextLength; i++) // Cycle for printing the letters of the encrypted text into a table
        {
            if (count == columnNumber)
            {
                System.out.println();
                count = 0;
            }
            System.out.print(encryptedTextChars[i] + " ");
            count++;
        }

        System.out.println("\n");
        String decryptedText = "";
        char [][] decryptedTextTable = new char[rowNumber][columnNumber]; // Creating blank table to fill with the letters on the correct positions

        if (fromTopLeft)
        {
            count = 0;
            int lettersCount = 0; // Variable for counting how many letters of the message we got
            int tableRow = 0; // Row position in the blank table
            int tableColumn = 0; // Column position in the blank table
            int rowSubtract = 0; // Subtracting however many rows we cycled through (and using its value in some places)
            int columnSubtract = 0; // Subtracting however many columns we cycled through (and using its value in some places)

            while (lettersCount < encryptedTextLength)
            {
                while (tableRow < rowNumber - rowSubtract && lettersCount < encryptedTextLength) // Cycle for filling the left side of the blank table
                {
                    decryptedTextTable[tableRow][tableColumn] = encryptedTextChars[count];
                    lettersCount++;
                    count++;
                    tableRow++;
                }
                tableRow--;
                tableColumn++;

                while (tableColumn < columnNumber - columnSubtract && lettersCount < encryptedTextLength) // Cycle for filling the bottom side of the blank table
                {
                    decryptedTextTable[tableRow][tableColumn] = encryptedTextChars[count];
                    lettersCount++;
                    count++;
                    tableColumn++;
                }
                tableRow--;
                tableColumn--;

                while (tableRow >= rowSubtract && lettersCount < encryptedTextLength) // Cycle for filling the right side of the blank table
                {
                    decryptedTextTable[tableRow][tableColumn] = encryptedTextChars[count];
                    lettersCount++;
                    count++;
                    tableRow--;
                }
                tableRow++;
                tableColumn--;

                while (tableColumn > columnSubtract && lettersCount < encryptedTextLength) // Cycle for filling the top side of the blank table
                {
                    decryptedTextTable[tableRow][tableColumn] = encryptedTextChars[count];
                    lettersCount++;
                    count++;
                    tableColumn--;
                }

                rowSubtract++;
                columnSubtract++;
                tableRow = rowSubtract;
                tableColumn = columnSubtract;
            }

            System.out.println("Decrypted text table:");
            for (int i = 0; i < rowNumber; i++)
            {
                for (int j = 0; j < columnNumber; j++)
                {
                    System.out.print(decryptedTextTable[i][j] + " ");
                }
                System.out.println();
            }
        }
        else
        {
            count = 0;
            int lettersCount = 0; // Variable for counting how many letters of the message we got
            int tableRow = rowNumber - 1;
            int tableColumn = columnNumber - 1;
            int rowSubtract = 0;
            int columnSubtract = 0;

            while (lettersCount < encryptedTextLength)
            {
                while (tableRow >= rowSubtract && lettersCount < encryptedTextLength)
                {
                    decryptedTextTable[tableRow][tableColumn] = encryptedTextChars[count];
                    lettersCount++;
                    count++;
                    tableRow--;
                }
                tableRow++;
                tableColumn--;

                while (tableColumn >= columnSubtract && lettersCount < encryptedTextLength)
                {
                    decryptedTextTable[tableRow][tableColumn] = encryptedTextChars[count];
                    lettersCount++;
                    count++;
                    tableColumn--;
                }
                tableRow++;
                tableColumn++;

                while (tableRow < rowNumber - rowSubtract && lettersCount < encryptedTextLength)
                {
                    decryptedTextTable[tableRow][tableColumn] = encryptedTextChars[count];
                    lettersCount++;
                    count++;
                    tableRow++;
                }
                tableRow--;
                tableColumn++;

                while (tableColumn < columnNumber - columnSubtract - 1 && lettersCount < encryptedTextLength)
                {
                    decryptedTextTable[tableRow][tableColumn] = encryptedTextChars[count];
                    lettersCount++;
                    count++;
                    tableColumn++;
                }

                rowSubtract++;
                columnSubtract++;
                tableRow = rowNumber - rowSubtract - 1;
                tableColumn = columnNumber - columnSubtract - 1;
            }

            System.out.println("Decrypted text table:");
            for (int i = 0; i < rowNumber; i++)
            {
                for (int j = 0; j < columnNumber; j++)
                {
                    System.out.print(decryptedTextTable[i][j] + " ");
                }
                System.out.println();
            }
        }

        boolean xLetters = true;
        for (int i = rowNumber - 1; i >= 0; i--)
        {
            for (int j = columnNumber - 1; j >= 0; j--)
            {
                if (decryptedTextTable[i][j] == 'X' && xLetters)
                    continue;

                xLetters = false;
                decryptedText = decryptedTextTable[i][j] + decryptedText;
            }
        }
        System.out.print("\nDecrypted text: ");
        return decryptedText;
    }

    @Override
    public String toString() {
        return "RouteCipher{" +
                "key=" + key +
                '}';
    }
}
