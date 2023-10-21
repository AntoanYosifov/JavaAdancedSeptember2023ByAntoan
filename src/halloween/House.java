package halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid){
        if(this.data.size() < capacity){
            this.data.add(kid);
        }
    }
    public boolean removeKid(String name){
        for (Kid child : this.data) {
            if(child.getName().equals(name)){
                this.data.remove(child);
                return true;
            }
        }
        return false;
    }
    public Kid getKid(String street){
        Kid kid = null;
        for (Kid child : this.data) {
            if(child.getStreet().equals(street)){
                kid = child;
                break;
            }
        }
        return kid;
    }
    public int getAllKids(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("Children who visited a house for candy:").append(System.lineSeparator());
        // Lily from Pirina street
        for (Kid child : this.data) {
            sb.append(String.format("%s from %s street", child.getName(), child.getStreet())).append(System.lineSeparator());
        }


        return sb.toString().trim();
    }
}
