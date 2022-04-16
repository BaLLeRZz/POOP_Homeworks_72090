package fmi.poop.zad2;

public class SquareMatrixTest
{
    public static void main(String[] args)
    {
        // Testing the methods
        // {
        SquareMatrix matrix1 = new SquareMatrix();
        String testString = matrix1.toString();
        System.out.println("Data array1 table:\n" + testString);
        System.out.println("Maximum sum from 2x2 submatrices: " + matrix1.findMaxSum());
        //System.out.println(matrix.getDataArray());
        int [][] testArray = new int[3][3];
        int count = 1;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                testArray[i][j] = count++;

        SquareMatrix matrix2 = new SquareMatrix(testArray);
        System.out.println("Data array2 table:\n" + matrix2.toString());
        SquareMatrix matrix3 = new SquareMatrix(matrix2);
        System.out.println("Data array3 table:\n" + matrix3.toString());
        SquareMatrix matrix4 = new SquareMatrix();
        matrix4.printAll();
        // }
    }
}
