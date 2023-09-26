package bg.softUni.advanced.multidimensionalArraysExercises;

import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        fillMatrix(matrix, scanner);

        int sumPrimary = getSumElementsPrimaryDiagonal(matrix);
        int sumSecondary = getSumElementsSecondaryDiagonal(matrix);
        int diff = Math.abs(sumPrimary - sumSecondary);
        System.out.println(diff);

    }

    private static int getSumElementsSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = matrix.length - 1, col = 0; row >= 0 ; row-- , col++) {
              sum += matrix[row][col];
        }
        return sum;
    }

    private static int getSumElementsPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[row][row];
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();

            }
        }
    }

}
