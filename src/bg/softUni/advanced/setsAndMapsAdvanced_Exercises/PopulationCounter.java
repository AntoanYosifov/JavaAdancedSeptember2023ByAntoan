package bg.softUni.advanced.setsAndMapsAdvanced_Exercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Long>> countriesAndPopulationByCity = new LinkedHashMap<>();
        Map<String, Long> countriesTotalPop = new LinkedHashMap<>();

        while(!"report".equals(input)){
           String[] tokens = input.split("\\|");

             String city = tokens[0];
             String country = tokens[1];
             long population = Long.parseLong(tokens[2]);

             countriesAndPopulationByCity.putIfAbsent(country, new LinkedHashMap<>());
             countriesTotalPop.putIfAbsent(country, 0l);
             countriesAndPopulationByCity.get(country).put(city, population);
             long popToAdd = countriesTotalPop.get(country) + population;

             countriesTotalPop.put(country, popToAdd);
              input = scanner.nextLine();
        }
        countriesTotalPop.entrySet().stream().
                sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())).
                forEach(entry -> {
                    System.out.printf("%s (total population: %d)\n", entry.getKey(), entry.getValue());

                    Map<String, Long> cities = countriesAndPopulationByCity.get(entry.getKey());

                    cities.entrySet().stream()
                            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                            .forEach(innerMapEntry -> {
                                System.out.printf("=>%s: %d\n", innerMapEntry.getKey(), innerMapEntry.getValue());
                            });
                });

    }
}
