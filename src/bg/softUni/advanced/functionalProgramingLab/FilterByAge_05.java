package bg.softUni.advanced.functionalProgramingLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> peopleByAge = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] peopleInfo = scanner.nextLine().split(", ");
            peopleByAge.put(peopleInfo[0], Integer.parseInt(peopleInfo[1]));
        }


        System.out.println();

        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> filter = getPredicate(condition, ageLimit);
        Consumer<Map.Entry<String, Integer>> print = getPrintConsumer(format);

        peopleByAge.entrySet()
                .stream()
                .filter(entry -> filter.test(entry.getValue()))
                .forEach(entry -> print.accept(entry));
    }

    private static Consumer<Map.Entry<String, Integer>> getPrintConsumer(String format) {
        switch (format) {
            case "name":
                return e -> System.out.println(e.getKey());

            case "age":
                return e -> System.out.println(e.getValue());

            case "name age":
                return e -> System.out.printf("%s - %d\n", e.getKey(), e.getValue());

        }


        throw new RuntimeException("Invalid format!");
    }

    private static Predicate<Integer> getPredicate(String condition, int ageLimit) {
        if ("older".equals(condition)) {
            return x -> x >= ageLimit;
        } else if ("younger".equals(condition)) {
            return x -> x <= ageLimit;
        }

        throw new RuntimeException("Bad condition! Use \"younger\" or \"older\"!");
    }
}
