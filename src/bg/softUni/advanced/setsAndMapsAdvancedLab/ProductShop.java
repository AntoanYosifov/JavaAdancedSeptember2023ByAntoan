package bg.softUni.advanced.setsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String, Double>> data = new TreeMap<>();

         while(!"Revision".equals(line)){
             String[] tokens = line.split(", ");
             String shop = tokens[0];
             String product = tokens[1];
             double price = Double.parseDouble(tokens[2]);

             data.putIfAbsent(shop, new LinkedHashMap<>());
             LinkedHashMap<String, Double> innerMap = data.get(shop);
              innerMap.putIfAbsent(product, price);


             line = scanner.nextLine();
         }

        data.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + "->");
            e.getValue().entrySet().stream()
                    .forEach(a ->{
                        System.out.printf("Product: %s, Price: %.01f\n", a.getKey(), a.getValue());
                    });
        });



    }
}
