package bg.softUni.advanced.functunialProgramingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        // Function<Argument, Return> -> apply
        // Consumer<Argument> -> void -> accept
        // Supplier<Return> -> get
        // Predicate<Argument> -> return true / false -> test
        // BiFunction <Argument1, Argument2, Return> -> apply
        Scanner scanner = new Scanner(System.in);
        Function<int[], Integer> minNumber = array -> {
            int minN = Integer.MAX_VALUE;
            for (Integer num : array) {
                if (num < minN) {
                    minN = num;
                }
            }
            return minN;
        };

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int minNum = minNumber.apply(numbers);
        System.out.println(minNum);
    }
}
