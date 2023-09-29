package bg.softUni.advanced.functionalProgramingLab;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputRange = scanner.nextLine().split(" ");
        int lowerRange = Integer.parseInt(inputRange[0]);
        int upperRange = Integer.parseInt(inputRange[1]);

        String oddOrEven = scanner.nextLine();

        Predicate<Integer> filterCondition =
                oddOrEven.equals("odd") ? x-> x % 2 != 0 : x-> x % 2 == 0;

        IntStream.range(lowerRange, upperRange + 1)
                .filter(num-> filterCondition.test(num))
                .forEach(num-> System.out.print(num + " "));

    }
}
