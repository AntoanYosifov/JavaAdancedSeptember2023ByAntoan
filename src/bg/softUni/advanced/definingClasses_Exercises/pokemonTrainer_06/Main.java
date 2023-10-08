package bg.softUni.advanced.definingClasses_Exercises.pokemonTrainer_06;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"Tournament".equals(input)) {
            // "{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);


            Trainer currenTrainer = trainerMap.get(trainerName);
            if (currenTrainer == null) {
                trainerMap.put(trainerName, new Trainer(trainerName));
                currenTrainer = trainerMap.get(trainerName);
            }

            currenTrainer.addPokemon(pokemon);

            input = scanner.nextLine();
        }
        System.out.println();
        input = scanner.nextLine();
        while (!"End".equals(input)) {
            String token = input;
            String element = "";
            switch (token) {
                // "Fire", "Water", and "Electricity
                case "Fire":
                    element = "Fire";
                    break;
                case "Water":
                    element = "Water";
                    break;
                case "Electricity":
                    element = "Electricity";
                    break;
            }

            for (Map.Entry<String, Trainer> trainer : trainerMap.entrySet()) {
                if (trainer.getValue().isWithElement(element)) {
                    trainer.getValue().addBadge();
                } else {

                    List<Pokemon> trainersPokemon = trainer.getValue().getPokemonList();

                    for (int i = 0; i < trainersPokemon.size(); i++) {
                        Pokemon currentPokemon = trainersPokemon.get(i);
                        currentPokemon.remove10Health();
                        if (currentPokemon.getHealth() <= 0) {
                            trainersPokemon.remove(i);
                            i--;
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }

        trainerMap.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue().getNumberOfBadges(), a.getValue().getNumberOfBadges()))
                .forEach(entry -> System.out.println(entry.getValue()));

    }
}
