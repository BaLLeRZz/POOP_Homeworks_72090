package fmi.poop.hwk3;

public class RouteCipherTest
{
    public static void main(String[] args)
    {
        // The program works correctly, but if you want to get correct readable text of the encrypted and decrypted text,
        // you must put the same text, amount of rows, columns and the same key.
        // In the examples below i have given the example text and table created with the correct sizes from the homework. (7 rows, 5 columns in this case)
        // You can try your own examples, but if you do not input the correct text, key and table sizes in the methods below, the program will print
        // the result correctly, but it will look strange to you. (You can check yourself)
        RouteCipher cipher = new RouteCipher(0);
        // System.out.println(cipher.encrypt("ABORT THE MISSION, YOU HAVE BEEN SPOTTED!")); // 7 rows or 5 columns to get the example in the homework
        // System.out.println(cipher.decrypt("XTEANITROBATSYVNTEDXOEHOMEHSOESPBUI")); // -7 rows or -5 columns to get the example in the homework
        // System.out.println(cipher.encrypt("THISISTHEPLAINTEXT")); // 4 columns to get the example in the homework
        // System.out.println(cipher.decrypt("TIEIXTXXEAHSIHSPNTLT")); // 4 columns to get the example in the homework
        System.out.println(cipher.toString());
    }
}
