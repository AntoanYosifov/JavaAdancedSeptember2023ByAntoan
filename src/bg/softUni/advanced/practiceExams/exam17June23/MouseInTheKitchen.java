package bg.softUni.advanced.practiceExams.exam17June23;

import java.util.Scanner;

public class MouseInTheKitchen {
    public static int mouseRow;
    public static int mouseCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(",");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        char[][] cupboardMatrix = new char[rows][cols];
        fillCharMatrix(cupboardMatrix, rows, scanner);

        findMousePosition(cupboardMatrix);


        boolean mouseIsMoving = true;

        String input = scanner.nextLine();
        while (mouseIsMoving) {
            String direction = input;
            if("danger".equals(direction)){
                System.out.println("Mouse will come back later!");
                break;
            }

            mouseIsMoving = walksAroundTheKitchen(cupboardMatrix, direction);

            input = scanner.nextLine();

        }
        printMatrix(cupboardMatrix);

    }


    private static boolean walksAroundTheKitchen(char[][] matrix, String direction) {
        int rowToGo = mouseRow;
        int colToGo = mouseCol;

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
        if (isInBounds(matrix, rowToGo, colToGo)) {

            if (matrix[rowToGo][colToGo] == '*') {
                matrix[mouseRow][mouseCol] = '*';
                matrix[rowToGo][colToGo] = 'M';
                mouseRow = rowToGo;
                mouseCol = colToGo;
                return true;
            } else if (matrix[rowToGo][colToGo] == '@') {
                return true;
            } else if (matrix[rowToGo][colToGo] == 'T') {
                matrix[mouseRow][mouseCol] = '*';
                mouseRow = rowToGo;
                mouseCol = colToGo;
                matrix[mouseRow][mouseCol] = 'M';
                System.out.println("Mouse is trapped!");
                return false;
            } else if (matrix[rowToGo][colToGo] == 'C') {
                matrix[mouseRow][mouseCol] = '*';
                matrix[rowToGo][colToGo] = '*';
                if (noMoreCheese(matrix)) {
                    mouseRow = rowToGo;
                    mouseCol = colToGo;
                    matrix[mouseRow][mouseCol] = 'M';
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    return false;
                } else {
                    matrix[mouseRow][mouseCol] = '*';
                    mouseRow = rowToGo;
                    mouseCol = colToGo;
                    matrix[mouseRow][mouseCol] = 'M';
                    return true;

                }
            }

        }

        System.out.println("No more cheese for tonight!");
        return false;
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }


    private static void findMousePosition(char[][] cupboardMatrix) {
        for (int row = 0; row < cupboardMatrix.length; row++) {
            for (int col = 0; col < cupboardMatrix[row].length; col++) {
                if (cupboardMatrix[row][col] == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                    break;
                }
            }
        }
    }


    private static void fillCharMatrix(char[][] matrix, int rows, Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            String currentRow = scanner.nextLine();
            matrix[i] = currentRow.toCharArray();
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean noMoreCheese(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'C') {
                    return false;
                }
            }
        }
        return true;
    }
}

