package bg.softUni.advanced.setsAndMapsAdvancedLab;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestOfCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(6);
        set.add(7);
        int number = 7;
        set.remove(number);
        System.out.println(set.contains(7));
        for (int element : set) {
            System.out.print(element + " ");
        }


    }
}
