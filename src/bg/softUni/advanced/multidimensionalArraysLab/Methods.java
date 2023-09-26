package bg.softUni.advanced.multidimensionalArraysLab;

import java.util.Scanner;

public class Methods {
    public static void printTwoDimMatrix( int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
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
