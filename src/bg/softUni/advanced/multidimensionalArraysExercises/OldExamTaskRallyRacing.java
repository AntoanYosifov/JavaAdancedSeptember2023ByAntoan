package bg.softUni.advanced.multidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OldExamTaskRallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();
        String[][] trace = new String[n][n];
        int km = 0;

        fillStringMatrix(trace, scanner);

        int currentRow = 0;
        int currentCol = 0;
        int countTunnels = 0;

        List<Integer> tunnelsCoordinates = new ArrayList<>();

        findTunnels(trace, tunnelsCoordinates);
        String directions = scanner.nextLine();
        while (!directions.equals("End")) {
            switch (directions) {
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
            }

            String movedPlace = trace[currentRow][currentCol];
            if (movedPlace.equals(".")) {
                km += 10;
            } else if (movedPlace.equals("F")) {
                System.out.println("Racing car " + carNumber + " finished the stage!");
                km += 10;
                break;
            } else if (movedPlace.equals("T")) {

                    currentRow = tunnelsCoordinates.get(2);
                    currentCol = tunnelsCoordinates.get(3);
                    km += 30;
                    trace[tunnelsCoordinates.get(0)][tunnelsCoordinates.get(1)] = ".";
                    trace[tunnelsCoordinates.get(2)][tunnelsCoordinates.get(3)] = ".";

            }

            directions = scanner.nextLine();

        }
        if(directions.equals("End")){
            System.out.println("Racing car " + carNumber + " DNF.");

        }
        System.out.printf("Distance covered %d km.\n", km );
        trace[currentRow][currentCol] = "C";
        printStringMatrix(trace);

    }

    private static void findTunnels(String[][] trace, List<Integer> tunnelsCoordinates) {
        for (int row = 0; row < trace.length; row++) {
            for (int col = 0; col < trace[row].length; col++) {
                if (trace[row][col].equals("T")) {
                    tunnelsCoordinates.add(row);
                    tunnelsCoordinates.add(col);
                }
            }
        }
    }

    private static void fillStringMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
    private static void printStringMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
