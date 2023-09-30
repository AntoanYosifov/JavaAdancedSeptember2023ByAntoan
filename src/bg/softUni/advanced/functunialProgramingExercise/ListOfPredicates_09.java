package bg.softUni.advanced.functunialProgramingExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> divisors = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Predicate<Integer>> predicates = divisors.stream()
                .map(divisor -> (Predicate<Integer>) (number -> number % divisor == 0))
                .collect(Collectors.toList());

        IntStream.rangeClosed(1, n)
                .filter(num -> predicates.stream().allMatch(predicate -> predicate.test(num)))
                .forEach(num -> System.out.print(num + " "));




    }
}
