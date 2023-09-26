package bg.softUni.advanced.multidimensionalArraysLab;

import java.util.Scanner;

public class SumOf2x2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rowsAndCols = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        int[][] matrix = new int[rows][cols];
       readTwoDimMatrix(scanner, matrix);
        int maxSumTopLeftRow = -1;
        int maxSumTopLeftCol = -1;
        // FIXME: Is 0 good enough default value ?
        int maxSum = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if(currentSum > maxSum){
                    maxSum = currentSum;

                    maxSumTopLeftRow = row;
                    maxSumTopLeftCol = col;
                }
            }
        }
        System.out.println(matrix[maxSumTopLeftRow][maxSumTopLeftCol] + " " + matrix[maxSumTopLeftRow][maxSumTopLeftCol + 1]);
        System.out.println(matrix[maxSumTopLeftRow + 1][maxSumTopLeftCol] + " " + matrix[maxSumTopLeftRow + 1][maxSumTopLeftCol + 1]);
        System.out.println(maxSum);
    }
    public static void readTwoDimMatrix(Scanner scanner, int[][] firstMatrix) {
        for (int i = 0; i < firstMatrix.length; i++) {
            String[] parts = scanner.nextLine().split(", ");
            for (int j = 0; j < firstMatrix[i].length; j++) {
                firstMatrix[i][j] = Integer.parseInt(parts[j]);
            }
        }
    }
}
