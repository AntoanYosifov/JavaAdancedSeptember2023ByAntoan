package bg.softUni.advanced.setsAndMapsAdvanced_Exercises;

import java.util.*;

public class HandsOfCards {
    static Map<String, Integer> types = Map.of("S", 4,
            "H", 3,
            "D", 2,
            "C", 1);

    static Map<String, Integer> power = new HashMap<>(Map.of("2", 2,
            "3", 3,
            "4", 4,
            "5", 5,
            "6", 6,
            "7", 7,
            "8", 8,
            "9", 9,
            "10", 10,
            "J", 11));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Set<String>> players = new LinkedHashMap<>();

        power.put("Q", 12);
        power.put("K", 13);
        power.put("A", 14);

        while (!"JOKER".equals(input)) {
            String[] tokens = input.split(": ");
            String name = tokens[0];

            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());
            }

            String[] cards = tokens[1].split(", ");
            for (String card : cards) {
                players.get(name).add(card);
            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : players.entrySet()) {
            String playerName = entry.getKey();
            int points = calculatePoints(entry.getValue());
            System.out.printf("%s: %d\n", playerName, points);
        }
        System.out.println();

    }

    private static int calculatePoints(Set<String> cards) {
        int points = 0;

        for (String card : cards) {
            String cardPower = card.substring(0, card.length() - 1);
            String cardType = String.valueOf(card.charAt(card.length() - 1));
            points += power.get(cardPower) * types.get(cardType);
        }


        return points;
    }
}
