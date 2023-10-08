package bg.softUni.advanced.definingClasses_Exercises.rawData_04;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;


    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType,
               List<Tire> tires) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tires = new ArrayList<>(tires);
    }

    public boolean cargoType() {
        return cargo.getType().equals("fragile");
    }

    public boolean tirePressureUnder1() {
        boolean isLowerThen_1 = false;
        for (Tire tire : tires) {
            if(tire.getPressure() < 1.0){
                isLowerThen_1 = true;
                break;
            }
        }
        return isLowerThen_1;
    }
    public boolean enginePowerOver250(){
        return engine.getPower() > 250;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
