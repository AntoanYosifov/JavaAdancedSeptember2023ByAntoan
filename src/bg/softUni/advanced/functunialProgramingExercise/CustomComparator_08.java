package bg.softUni.advanced.functunialProgramingExercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public  class CustomComparator_08 {
    private static class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer num1, Integer num2) {
            boolean isNum1Even = num1 % 2 == 0;
            boolean isNum2Even = num2 % 2 == 0;

            if (isNum1Even && !isNum2Even) {
                return -1;
            } else if (isNum2Even && !isNum1Even) {
                return 1;
            } else {
                return num1.compareTo(num2);
            }


        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Function<Argument, Return> -> apply
        // Consumer<Argument> -> void -> accept
        // Supplier<Return> -> get
        // Predicate<Argument> -> return true / false -> test
        // BiFunction <Argument1, Argument2, Return> -> apply
        CustomComparator comparator = new CustomComparator();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).sorted((a, b) -> comparator.compare(a, b))
                .forEach(e -> System.out.print(e + " "));


    }

}
