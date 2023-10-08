package bg.softUni.advanced.definingClasses_Exercises.rawData_04;


import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {

            // "{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType} {Tire1Pressure}
            // {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}

            // ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4

            String input = scanner.nextLine();
            String[] carData = input.split("\\s+");

            String model = carData[0];
            int engineSpeed = Integer.parseInt(carData[1]);
            int enginePower = Integer.parseInt(carData[2]);
            int cargoWeight = Integer.parseInt(carData[3]);
            String cargoType = carData[4];


            List<Tire> tires = getTiresData(carData);

            Car currentCar = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tires);
            cars.put(model, currentCar);

        }
        String command = scanner.nextLine();

        Predicate<Car> fragileCars = car -> car.cargoType() && car.tirePressureUnder1();
        Predicate<Car> flamableCars = car -> !car.cargoType() && car.enginePowerOver250();

        switch (command) {
            case "fragile":
                cars.entrySet().stream().filter(entry -> fragileCars.test(entry.getValue()))
                        .forEach(entry -> System.out.println(entry.getValue()));
                break;
            case "flamable":
                cars.entrySet().stream().filter(entry -> flamableCars.test(entry.getValue()))
                        .forEach(entry -> System.out.println(entry.getValue()));
                break;
        }
    }

    private static List<Tire> getTiresData(String[] carData) {
        List<Tire> tires = new ArrayList<>();
        int tireAge = -1;
        double tirePressure = -0.1;
        for (int j = 5; j < carData.length; j++) {

            if (j % 2 != 0) {
                tirePressure = Double.parseDouble(carData[j]);
                continue;
            }
            tireAge = Integer.parseInt(carData[j]);
            Tire tire = new Tire(tirePressure, tireAge);
            tires.add(tire);
        }
        return tires;
    }
}
