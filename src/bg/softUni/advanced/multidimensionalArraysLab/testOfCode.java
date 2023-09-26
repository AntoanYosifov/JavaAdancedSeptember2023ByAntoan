package bg.softUni.advanced.multidimensionalArraysLab;

import java.util.Scanner;

public class testOfCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] table = new int[3][2];
        System.out.println(table.length);
        System.out.println(table[0].length);

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = i + j;
            }
        }

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
