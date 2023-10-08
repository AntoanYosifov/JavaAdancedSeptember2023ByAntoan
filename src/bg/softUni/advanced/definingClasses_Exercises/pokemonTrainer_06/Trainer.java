package bg.softUni.advanced.definingClasses_Exercises.pokemonTrainer_06;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemonList;

    public Trainer() {
        this.numberOfBadges = 0;
        this.pokemonList = new ArrayList<>();
    }

    public Trainer(String name) {
        this();
        this.name = name;

    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }
    public boolean isWithElement(String element){
        boolean isWithElement = false;
        for (Pokemon pokemon : this.pokemonList) {
            if(pokemon.getElement().equals(element)){
                isWithElement = true;
                break;
            }
        }
        return isWithElement;

    }
    public void addBadge(){
        this.numberOfBadges++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    @Override
    public String toString() {
        return this.name + " " + this.numberOfBadges + " " + this.pokemonList.size();
    }
}
