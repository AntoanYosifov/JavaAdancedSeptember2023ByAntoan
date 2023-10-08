package bg.softUni.advanced.definingClasses_Exercises.SpeedRacing_03;

public class Car {
private String model;
private double fuelAmount;
private double priceFuelPerKm;
private int distanceTraveled;
public Car(){

}
public Car(String model, double fuelAmount, double priceFuelPerKm ){
    this.model = model;
    this.fuelAmount = fuelAmount;
    this.priceFuelPerKm = priceFuelPerKm;
    this.distanceTraveled = 0;
}

public boolean canMove (int distanceToDrive){
   double fuelRequired =  distanceToDrive * this.priceFuelPerKm;

   if(this.fuelAmount >= fuelRequired ){
       this.fuelAmount -= fuelRequired;
       this.distanceTraveled += distanceToDrive;
       return true;
   }
   return false;
}



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getPriceFuelPerKm() {
        return priceFuelPerKm;
    }

    public void setPriceFuelPerKm(double priceFuelPerKm) {
        this.priceFuelPerKm = priceFuelPerKm;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }
}
