package bg.softUni.advanced.multidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][];
        for (int row = 0; row < size; row++) {
            String[] columnData = scanner.nextLine().split(" ");
//            int[] currentRow = new int[size];
//            String[] columnData = scanner.nextLine().split(" ");
//            for (int col = 0; col < columnData.length; col++) {
//                currentRow[col] = Integer.parseInt(columnData[col]);
//            }
            int[] currentRow = Arrays.stream(columnData).mapToInt(Integer::parseInt).toArray();
            matrix[row] = currentRow;
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        for (int row = matrix.length - 1, col = 0; row > -1; row--, col++) {
            System.out.print(matrix[row][col] + " ");
        }
        System.out.println();

    }


}
