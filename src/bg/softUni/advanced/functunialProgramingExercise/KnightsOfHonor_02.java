package bg.softUni.advanced.functunialProgramingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor_02 {
    // Function<Argument, Return> -> apply
    // Consumer<Argument> -> void -> accept
    // Supplier<Return> -> get
    // Predicate<Argument> -> return true / false -> test
    // BiFunction <Argument1, Argument2, Return> -> apply
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> printSirNames = name -> System.out.println("Sir " + name);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(name-> printSirNames.accept(name));
    }

}
