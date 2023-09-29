package bg.softUni.advanced.functunialProgramingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint_01 {
    public static void main(String[] args) {
        // Function<Argument, Return> -> apply
        // Consumer<Argument> -> void -> accept
        // Supplier<Return> -> get
        // Predicate<Argument> -> return true / false -> test
        // BiFunction <Argument1, Argument2, Return> -> apply
        Scanner scanner = new Scanner(System.in);
        Consumer<String> printNames = name-> System.out.println(name);

        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(name-> printNames.accept(name));



    }
}
