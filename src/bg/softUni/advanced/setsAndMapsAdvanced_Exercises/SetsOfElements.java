package bg.softUni.advanced.setsAndMapsAdvanced_Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        Set<String> setN = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {

            setN.add(scanner.nextLine());
        }
        Set<String> setM = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {

            setM.add(scanner.nextLine());
        }

        setN.retainAll(setM);
        printStringSet(setN);

    }
    private static void printStringSet(Set<String> set) {
        for (String e: set) {
            System.out.print(e + " ");
        }
    }
}
