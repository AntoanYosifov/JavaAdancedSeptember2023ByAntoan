package bg.softUni.advanced.functionalProgramingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AddVat_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Double> parse = str-> Double.parseDouble(str);
        UnaryOperator<Double> addVat = d-> d * 1.2;
        Consumer<Double> print = num-> System.out.printf("%.02f\n", num);

        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(", "))
                .map(d-> parse.apply(d))
                .map(price-> addVat.apply(price))
                .forEach(priceWithVat-> print.accept(priceWithVat));
    }
}
