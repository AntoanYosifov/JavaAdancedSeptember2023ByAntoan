package bg.softUni.advanced.functunialProgramingExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates_09_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        List<Integer> divisors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        List<Predicate<Integer>> predicates = new ArrayList<>();
        for (int divisor : divisors) {
            predicates.add(number -> number % divisor == 0);
        }

        List<Integer> result = new ArrayList<>();
        for (int number = 1; number <= n; number++) {
            boolean isDivisible = true;
            for (Predicate<Integer> predicate : predicates) {
                if (!predicate.test(number)) {
                    isDivisible = false;
                    break;
                }
            }
            if (isDivisible) {
                result.add(number);
            }
        }


        for (int num : result) {
            System.out.print(num + " ");
        }


    }
}
