package bg.softUni.advanced.functunialProgramingExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics_04 {
    public static void main(String[] args) {
        // Function<Argument, Return> -> apply
        // Consumer<Argument> -> void -> accept
        // Supplier<Return> -> get
        // Predicate<Argument> -> return true / false -> test
        // BiFunction <Argument1, Argument2, Return> -> apply
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String operation = scanner.nextLine();
        Function<List<Integer>, List<Integer>> add =
                list -> list.stream().map(num -> num + 1).collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> multiply =
                list -> list.stream().map(num -> num * 2).collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> subtract =
                list -> list.stream().map(num -> num - 1).collect(Collectors.toList());

        Consumer<List<Integer>> print = list -> list.stream().forEach(num -> System.out.print(num + " "));

        while (!"end".equals(operation)) {
            switch (operation) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }


            operation = scanner.nextLine();

        }


    }


}
