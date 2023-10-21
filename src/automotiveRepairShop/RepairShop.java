package automotiveRepairShop;

import java.util.ArrayList;
import java.util.List;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        vehicles = new ArrayList<>();
    }
    public void addVehicle(Vehicle vehicle){
        if(this.vehicles.size() < capacity){
            this.vehicles.add(vehicle);
        }
    }
    public boolean removeVehicle(String vin){
        for (Vehicle vehicle : this.vehicles) {
            if(vehicle.getVIN().equals(vin)){
                this.vehicles.remove(vehicle);
                return true;
            }
        }

        return false;
    }
    public int getCount(){
        return this.vehicles.size();
    }
    public Vehicle getLowestMileage(){
        Vehicle lowestMilVehicle = null;
        int lowestMileage = Integer.MAX_VALUE;

        for (Vehicle vehicle : this.vehicles) {
            if(vehicle.getMileage() < lowestMileage){
                lowestMileage = vehicle.getMileage();

            }
        }
        for (Vehicle vehicle : this.vehicles) {
            if(vehicle.getMileage() == lowestMileage){
                lowestMilVehicle = vehicle;
                break;
            }
        }

        return lowestMilVehicle;
    }
    public String report(){

        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:").append(System.lineSeparator());
        for (Vehicle vehicle : this.vehicles) {
            sb.append(vehicle);
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
