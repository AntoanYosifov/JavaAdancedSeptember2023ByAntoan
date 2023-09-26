package bg.softUni.advanced.multidimensionalArraysExercises;

import java.util.Scanner;

public class MatrixOfPalindrome_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String[] rowsAndCols = scanner.nextLine().split("\\s+");
       int rows = Integer.parseInt(rowsAndCols[0]);
       int cols = Integer.parseInt(rowsAndCols[1]);
       String[][] palindromeMatrix = new String[rows][cols];
       generatePalindromeMatrix(palindromeMatrix);
       printStringMatrix(palindromeMatrix);
      // ascii small letters range = 97 - 122



    }

    private static void generatePalindromeMatrix(String[][] palindromeMatrix) {
        for (int row = 0; row < palindromeMatrix.length; row++) {
            for (int col = 0; col < palindromeMatrix[row].length; col++) {
             int firstChar = 97;
             int secondChar = 97;
             int thirdChar = 97;
             firstChar += row;
             secondChar =  secondChar + row + col;
             thirdChar += row;
             char one = (char) firstChar;
             char two = (char) secondChar;
             char three = (char) thirdChar;
             StringBuilder sb = new StringBuilder();
             sb.append(one);
             sb.append(two);
             sb.append(three);
             String letters = sb.toString();
             palindromeMatrix[row][col] = letters;

            }
        }
    }
    private static void printStringMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
