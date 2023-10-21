package bg.softUni.advanced.regularExam21October;

import java.util.Scanner;

public class P_2 {
    public static int shipRow;
    public static int shipCol;
    public static int cachedFishTones;
    public static int requiredTones = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        char[][] fishingArea = new char[n][n];
        fillCharMatrix(fishingArea, n, scanner);
        findShipPosition(fishingArea);
        String input = scanner.nextLine();
        boolean reachedWhirlpool = false;
        while (!reachedWhirlpool && !"collect the nets".equals(input)) {

            String direction = input;


            reachedWhirlpool = hasReachedWhirlpool(fishingArea, direction);

            input = scanner.nextLine();
        }

        if (!reachedWhirlpool) {
            if (cachedFishTones >= requiredTones) {
                System.out.println("Success! You managed to reach the quota!");

            } else {
                System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.\n",
                        requiredTones - cachedFishTones);
            }

            if (cachedFishTones > 0) {
                System.out.printf("Amount of fish caught: %d tons.\n", cachedFishTones);
            }

            printMatrix(fishingArea);
        }

    }

    private static boolean hasReachedWhirlpool(char[][] matrix, String direction) {
        int rowToGo = shipRow;
        int colToGo = shipCol;

        switch (direction) {
            case "up":
                rowToGo--;
                break;
            case "down":
                rowToGo++;
                break;
            case "right":
                colToGo++;
                break;
            case "left":
                colToGo--;
                break;
        }

        if (!isInBounds(matrix, rowToGo, colToGo)) {

            switch (direction) {
                case "up":
                    rowToGo = matrix.length - 1;
                    break;
                case "down":
                    rowToGo = 0;
                    break;
                case "right":
                    colToGo = 0;
                    break;
                case "left":
                    colToGo = matrix[shipRow].length - 1;
                    break;
            }

        }


        char c = matrix[rowToGo][colToGo];

        if (c == '-') {
            matrix[shipRow][shipCol] = '-';
            matrix[rowToGo][colToGo] = 'S';
            shipRow = rowToGo;
            shipCol = colToGo;
            return false;
        } else if (Character.isDigit(c)) {
            int characterNumber = c - '0';
            cachedFishTones += characterNumber;
            matrix[shipRow][shipCol] = '-';
            matrix[rowToGo][colToGo] = 'S';
            shipRow = rowToGo;
            shipCol = colToGo;
            return false;
        }

        shipRow = rowToGo;
        shipCol = colToGo;
        System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]\n",
                shipRow, shipCol);
        return true;

    }

    private static void fillCharMatrix(char[][] matrix, int rows, Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            String currentRow = scanner.nextLine();
            matrix[i] = currentRow.toCharArray();
        }
    }

    private static void findShipPosition(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
                    shipRow = row;
                    shipCol = col;
                    break;
                }
            }
        }
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

}
