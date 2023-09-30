package bg.softUni.advanced.functunialProgramingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Function<Argument, Return> -> apply
        // Consumer<Argument> -> void -> accept
        // Supplier<Return> -> get
        // Predicate<Argument> -> return true / false -> test
        // BiFunction <Argument1, Argument2, Return> -> apply
        int n = Integer.parseInt(scanner.nextLine());
        Predicate<String> checkLength = str-> str.length() <= n;
        Arrays.stream(scanner.nextLine().split("\\s+")).filter(str-> checkLength.test(str))
                .forEach(str-> System.out.println(str));



    }
}
