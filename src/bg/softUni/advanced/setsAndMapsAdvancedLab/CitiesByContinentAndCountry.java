package bg.softUni.advanced.setsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>>
                countriesDataByContinent = new LinkedHashMap<>();

       while(n-- > 0){


           String[] tokens = scanner.nextLine().split("\\s+");

           String continent = tokens[0];
           String country = tokens[1];
           String city = tokens[2];

          countriesDataByContinent.putIfAbsent(continent, new LinkedHashMap<>());
           LinkedHashMap<String, List<String>> citiesByCountries = countriesDataByContinent.get(continent);
           citiesByCountries.putIfAbsent(country, new ArrayList<>());
           List<String> cities = citiesByCountries.get(country);
           cities.add(city);

//           Europe:
//             Bulgaria -> Sofia, Plovdiv
//             Poland -> Warsaw, Poznan
//             Germany -> Berlin
       }
        countriesDataByContinent.forEach((key1, value1) -> {
            System.out.println(key1 + ":");
            value1.forEach((key, value) -> {
                String cities = String.join(", ", value);

                System.out.println("  " + key + " -> " + cities);
            });
        });

    }
}
