package bg.softUni.advanced.multidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rowsAndCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        int[][] matrix = new int[rows][cols];

        fillIntMatrix(matrix, scanner);
        findMaximumSumOf3x3SquareInMatrix(matrix);


    }


    private static void findMaximumSumOf3x3SquareInMatrix(int[][] matrix) {
        int maximumSum = Integer.MIN_VALUE;


        int startRowIndex = 0;
        int startColIndex = 0;
        int endRowIndex = 3;
        int endColIndex = 3;

        int startMaxRowIndex = -1;
        int endMaxRowIndex = -1;
        int startMaxColIndex = -1;
        int endMaxColIndex = -1;
        boolean isMatrixRead = false;
        int countReads = 0;
        while (!isMatrixRead) {


            int currentSum = 0;
            for (int row = startRowIndex; row < endRowIndex; row++) {
                for (int col = startColIndex; col < endColIndex; col++) {
                       currentSum += matrix[row][col];
                }
            }
            if (currentSum > maximumSum) {
                maximumSum = currentSum;
                startMaxRowIndex = startRowIndex;
                endMaxRowIndex = endRowIndex;
                startMaxColIndex = startColIndex;
                endMaxColIndex = endColIndex;

            }
            startColIndex++;
            endColIndex++;
            if (matrix[startRowIndex].length - startColIndex < 3) {
                startRowIndex++;
                endRowIndex++;
                startColIndex = 0;
                endColIndex = 3;

            }
            if (matrix.length - startRowIndex < 3) {
                isMatrixRead = true;
            }
        }
        System.out.printf("Sum = %d\n", maximumSum);
        printMaximalSquare(matrix, startMaxRowIndex, endMaxRowIndex, startMaxColIndex, endMaxColIndex);


    }

    private static void fillIntMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] rowNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = rowNumbers;

        }
    }

    private static void printMaximalSquare(int[][] matrix, int startMaxRowIndex, int endMaxRowIndex, int startMaxColIndex, int endMaxColIndex) {
        for (int row = startMaxRowIndex; row < endMaxRowIndex; row++) {
            for (int col = startMaxColIndex; col < endMaxColIndex; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
