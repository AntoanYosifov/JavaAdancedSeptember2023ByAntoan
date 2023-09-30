package bg.softUni.advanced.functunialProgramingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement_07 {
    public static void main(String[] args) {
        // Function<Argument, Return> -> apply
        // Consumer<Argument> -> void -> accept
        // Supplier<Return> -> get
        // Predicate<Argument> -> return true / false -> test
        // BiFunction <Argument1, Argument2, Return> -> apply
        Scanner scanner = new Scanner(System.in);
        Function<List<Integer>, Integer> findSmallestElmIndex = array -> {
            int smallestElm = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) <= smallestElm) {
                    smallestElm = array.get(i);
                    index = i;
                }
            }
            return index;
        };

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).
                collect(Collectors.toList());

        System.out.println(findSmallestElmIndex.apply(numbers));
    }
}
