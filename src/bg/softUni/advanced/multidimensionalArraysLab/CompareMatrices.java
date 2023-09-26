package bg.softUni.advanced.multidimensionalArraysLab;

import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputDimensions = scanner.nextLine().split(" ");
        int firstRows = Integer.parseInt(inputDimensions[0]);
        int firstCows = Integer.parseInt(inputDimensions[1]);

        int[][] firstMatrix = new int[firstRows][firstCows];

        readTwoDimMatrix(scanner, firstMatrix);
        inputDimensions = scanner.nextLine().split(" ");
        int secondRows = Integer.parseInt(inputDimensions[0]);
        int secondCows = Integer.parseInt(inputDimensions[1]);

        int[][] secondMatrix = new int[secondRows][secondCows];
        readTwoDimMatrix(scanner, secondMatrix);

        boolean areEqual = equalOrNot(firstMatrix, secondMatrix, firstCows, secondCows);
        if(areEqual){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }


    }

    private static void readTwoDimMatrix(Scanner scanner, int[][] firstMatrix) {
        for (int i = 0; i < firstMatrix.length; i++) {
            String[] parts = scanner.nextLine().split(" ");
            for (int j = 0; j < firstMatrix[i].length; j++) {
                firstMatrix[i][j] = Integer.parseInt(parts[j]);
            }
        }
    }

    private static boolean equalOrNot(int[][] firstMatrix, int[][] secondMatrix, int firstCows, int secondCows) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        if (firstCows != secondCows) {
            return false;
        }
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
