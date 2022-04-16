package fmi.poop.zad9;

public class RecursiveSums {
    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++)
            System.out.printf("%-10d%-10.2f\n", i, computeSum(i));
    }

    private static double computeSum(int i)
    {
        if (i <= 0)
            return 0;

        return i / (2.0 * i + 1) + computeSum(i - 1);
    }
}
