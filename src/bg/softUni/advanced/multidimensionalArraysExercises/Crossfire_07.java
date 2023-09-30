package bg.softUni.advanced.multidimensionalArraysExercises;


import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Scanner;

public class Crossfire_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dimensions = scanner.nextLine();

        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split("\\s+")[1]);
        int number = 1;
        int[][] initialMatrix = new int[rows][cols];
        for (int row = 0; row < initialMatrix.length; row++) {
            for (int col = 0; col < initialMatrix[row].length; col++) {
                initialMatrix[row][col] = number;
                number++;
            }
        }


        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String coordinates = input;

            int matrixRow = Integer.parseInt(coordinates.split("\\s+")[0]);
            int matrixCol = Integer.parseInt(coordinates.split("\\s+")[1]);
            int matrixRadius = Integer.parseInt(coordinates.split("\\s+")[2]);


            int numRows = initialMatrix.length;
            int[][] postDestructMatrix = new int[numRows][];
            for (int i = 0; i < numRows; i++) {
                postDestructMatrix[i] = new int[initialMatrix[i].length];
            }


            for (int row = 0; row < initialMatrix.length; row++) {

                for (int col = 0; col < initialMatrix[row].length; col++) {


                    if (row >= (matrixRow - matrixRadius) && row < matrixRow) {

                        if (col == matrixCol) {
                            continue;
                        }
                    } else if (row == matrixRow) {
                        if (col >= (matrixCol - matrixRadius) && col <= (matrixCol + matrixRadius)) {
                            continue;
                        }
                    } else if (row > matrixRow && row <= (matrixRow + matrixRadius)) {
                        if (col == matrixCol) {
                            continue;
                        }
                    }

                    postDestructMatrix[row][col] = initialMatrix[row][col];

                }
            }


            List<int[]> result = new ArrayList<>();
            for (int[] ints : postDestructMatrix) {
                int[] array = Arrays.stream(ints).filter(value -> value > 0)
                        .toArray();
                result.add(array);
            }
            initialMatrix = result.toArray(new int[0][]);

            List<int[]> list = new ArrayList<>();
            for (int[] row : initialMatrix) {
                if (row.length > 0) {
                    list.add(row);
                }
            }

            initialMatrix = list.toArray(new int[0][]);


            input = scanner.nextLine();
        }

        printMatrix(initialMatrix);


    }


    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}


