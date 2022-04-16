package fmi.poop.zad2;

import java.util.Random;

public class SquareMatrix
{
    private Random random = new Random();
    private int size = 2 + random.nextInt(11);
    private int [][] dataArray = new int[this.size][this.size];

    public SquareMatrix()
    {
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++)
                this.dataArray[i][j] = this.random.nextInt(9);
    }

    public SquareMatrix(int[][] dataArray)
    {
        this.size = dataArray.length;
        this.dataArray = new int[this.size][this.size];
        this.setDataArray(dataArray);
    }

    public SquareMatrix(SquareMatrix other)
    {
        this.size = other.dataArray.length;
        this.dataArray = new int[this.size][this.size];
        this.setDataArray(other.dataArray);
    }

    public int[][] getDataArray()
    {
        return this.dataArray;
    }

    public void setDataArray(int[][] dataArray)
    {
        if (this.dataArray.length != dataArray.length)
        {
            System.out.println("The array in the function argument has different size!");
            for (int i = 0; i < this.size; i++)
                for (int j = 0; j < this.size; j++)
                    this.dataArray[i][j] = this.random.nextInt(9);

            System.out.println("This object's array has been randomly filled.");
        }
        else
        {
            for (int i = 0; i < this.size; i++)
                for (int j = 0; j < this.size; j++)
                    this.dataArray[i][j] = dataArray[i][j];
        }
    }

    @Override
    public String toString()
    {
        String arrayString = "";
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++)
                arrayString += this.dataArray[i][j];

        char [] arrayChar = arrayString.toCharArray();
        int arrayLength = arrayChar.length;
        int columnNumber = (int) Math.sqrt(arrayLength);
        int count = 0; // counter for columns
        arrayString = "";
        for (int i = 0; i < arrayLength; i++)
        {
            arrayString += arrayChar[i] + " ";
            count++;

            if (count == columnNumber)
            {
                arrayString += '\n';
                count = 0;
            }
        }

        return arrayString;
    }

    public int findMaxSum()
    {
        int maxSum = -1;
        for (int i = 0; i < this.size - 1; i++)
            for (int j = 0; j < this.size - 1; j++)
                if (maxSum < this.dataArray[i][j] + this.dataArray[i][j + 1] + this.dataArray[i + 1][j] + this.dataArray[i + 1][j + 1])
                    maxSum = this.dataArray[i][j] + this.dataArray[i][j + 1] + this.dataArray[i + 1][j] + this.dataArray[i + 1][j + 1];

        return maxSum;
    }

    public void printAll()
    {
        System.out.println("Data array table:\n" + this.toString());
        System.out.println("Maximum sum from 2x2 submatrices: " + this.findMaxSum());
        System.out.println("Submatrices with maximum sum:");
        int maxSum = this.findMaxSum();
        for (int i = 0; i < this.size - 1; i++)
            for (int j = 0; j < this.size - 1; j++)
                if (maxSum == this.dataArray[i][j] + this.dataArray[i][j + 1] + this.dataArray[i + 1][j] + this.dataArray[i + 1][j + 1])
                    System.out.println("[" + i + "," + j + "]");
    }
}
