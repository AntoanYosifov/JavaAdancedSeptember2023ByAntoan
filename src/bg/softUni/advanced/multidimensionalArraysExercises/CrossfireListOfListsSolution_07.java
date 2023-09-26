package bg.softUni.advanced.multidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrossfireListOfListsSolution_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        List<List<Integer>> matrix = new ArrayList<>();
        fillListMatrix(matrix, rows, cols);


        String parameters = scanner.nextLine();
        while (!"Nuke it from orbit".equals(parameters)) {
            int matrixRow = Integer.parseInt(parameters.split("\\s+")[0]);
            int matrixCol = Integer.parseInt(parameters.split("\\s+")[1]);
            int matrixRadius = Integer.parseInt(parameters.split("\\s+")[2]);


            if (isInMatrix(matrixRow, matrixCol, matrix)) {
                List<Integer> collectionOfElementsToRemove = new ArrayList<>();
                int startingRow = matrixRow - matrixRadius;
                int endRow = matrixRow + matrixRadius;
                int startingCol = matrixCol - matrixRadius;
                int endCol = matrixCol + matrixRadius;

                if (startingRow < 0) {
                    startingRow = 0;
                } else if (startingRow > matrix.size() - 1) {
                    startingRow = matrix.size() - 1;
                }
                if (endRow > matrix.size() - 1) {
                    endRow = matrix.size() - 1;
                }
                if (startingCol < 0) {
                    startingCol = 0;
                } else if (startingCol > matrix.get(matrixRow).size() - 1) {
                    startingCol = matrix.get(matrixRow).size() - 1;
                }
                if (endCol > matrix.get(matrixRow).size() - 1) {
                    endCol = matrix.get(matrixRow).size() - 1;
                }
                for (int row = startingRow; row <= endRow; row++) {
                    if (matrixCol > matrix.get(row).size() - 1) {
                        continue;
                    }
                    collectionOfElementsToRemove.add(matrix.get(row).get(matrixCol));
                }
                for (int row = matrixRow; row < matrixRow + 1; row++) {
                    for (int col = startingCol; col <= endCol; col++) {
                        collectionOfElementsToRemove.add(matrix.get(row).get(col));
                    }
                }
                for (List<Integer> innerList : matrix) {
                    innerList.removeAll(collectionOfElementsToRemove);
                }


            } else {
                parameters = scanner.nextLine();
                continue;
            }


            parameters = scanner.nextLine();

        }

        printListMatrix(matrix);


    }

    private static boolean isInMatrix(int matrixRow, int matrixCol, List<List<Integer>> matrix) {
        return matrixRow > -1 && matrixRow < matrix.size() && matrixCol > -1 && matrixCol < matrix.get(matrixRow).size();
    }

    private static void printListMatrix(List<List<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                System.out.print(matrix.get(row).get(col) + " ");
            }
            System.out.println();
        }
    }

    private static void fillListMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int counter = 1;
        for (int row = 0; row < rows; row++) {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int col = 0; col < cols; col++) {

                numbers.add(counter++);
            }
            matrix.add(numbers);

        }

    }
}
