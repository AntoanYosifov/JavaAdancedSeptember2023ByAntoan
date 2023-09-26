package bg.softUni.advanced.setsAndMapsAdvanced_Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
         int n = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            elements.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }
        printStringSet(elements);

    }
    private static void printStringSet(Set<String> set) {
        for (String e: set) {
            System.out.print(e + " ");
        }
    }
}
