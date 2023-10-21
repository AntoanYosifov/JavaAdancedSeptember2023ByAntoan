package bg.softUni.advanced.examPrepTwo;

import java.util.Scanner;

public class ThroneConquering_Matrix {
    public static int parisRow;
    public static int parisCol;
    public static int energy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       /* matrix input :
         ------H---
         -------S--
         --S-------
         ----------
         -----P----
         */
        energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] spartaField = new char[rows][];

        fillCharMatrix(spartaField, rows, scanner);


        for (int row = 0; row < spartaField.length; row++) {
            for (int col = 0; col < spartaField[row].length; col++) {
                if (spartaField[row][col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }


        boolean searchingForHelen = true;
        while (searchingForHelen) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String direction = tokens[0];
            int enemyRow = Integer.parseInt(tokens[1]);
            int enemyCol = Integer.parseInt(tokens[2]);
            searchingForHelen = moveInSpartaField(direction, spartaField, enemyRow, enemyCol);

        }

        printMatrix(spartaField);

    }

    private static boolean moveInSpartaField(String direction, char[][] matrix, int enemyRow, int enemyCol) {
        int rowToGo = parisRow;
        int colToGo = parisCol;

        matrix[enemyRow][enemyCol] = 'S';

        switch (direction) {
            case "down":
                rowToGo++;
                break;
            case "up":
                rowToGo--;
                break;
            case "right":
                colToGo++;
                break;
            case "left":
                colToGo--;
                break;

        }
        if (isInBounds(matrix, rowToGo, colToGo)) {
            // TODO make the prints!
            energy--;

            matrix[parisRow][parisCol] = '-';

            parisRow = rowToGo;
            parisCol = colToGo;

            if (matrix[parisRow][parisCol] == 'S') {
                energy -= 2;

            } else if (matrix[parisRow][parisCol] == 'H') {
                matrix[parisRow][parisCol] = '-';
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d\n", energy);
                return false;
            }


        } else {
            energy--;
        }

        if (energy <= 0) {
            matrix[parisRow][parisCol] = 'X';
            System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
            return false;
        } else {
            matrix[parisRow][parisCol] = 'P';
            return true;
        }

    }

    private static void fillCharMatrix(char[][] matrix, int rows, Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            String currentRow = scanner.nextLine();
            matrix[i] = currentRow.toCharArray();
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
