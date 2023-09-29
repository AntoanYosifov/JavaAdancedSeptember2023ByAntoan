package bg.softUni.advanced.functionalProgramingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class SumNumbersBiFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> numbersAsString = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        int sum = 0;
        BiFunction<Integer, String, Integer> parseAndAdd =
                (acc, curr)-> acc + Integer.parseInt(curr);

        for (String num : numbersAsString) {
             sum = parseAndAdd.apply(sum, num);
        }

        System.out.println("Count = " + numbersAsString.size());
        System.out.println("Sum = " + sum);
    }
}
