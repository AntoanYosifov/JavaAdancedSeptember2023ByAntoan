package bg.softUni.advanced.definingClasses_Exercises.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Map<String, Car> cars = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        int countCars = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countCars; i++) {
            String data = scanner.nextLine();

            String model = data.split("\\s+")[0];
            double fuelAmount = Double.parseDouble(data.split("\\s+")[1]);
            double priceFuelPerKm = Double.parseDouble(data.split("\\s+")[2]);

            Car car = new Car(model, fuelAmount, priceFuelPerKm);
            cars.putIfAbsent(model, car);

        }


        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            String[] tokens = command.split("\\s+");

            // Drive AudiA4 85
            String currentModel = tokens[1];
            int distanceToDrive = Integer.parseInt(tokens[2]);
            Car currentCar = cars.get(currentModel);

            boolean isMoving = currentCar.canMove(distanceToDrive);

            if (!isMoving) {
                System.out.println("Insufficient fuel for the drive");
            }


            command = scanner.nextLine();
        }
        cars.entrySet().stream().forEach(entry -> System.out.printf("%s %.2f %d\n", entry.getKey(),
                entry.getValue().getFuelAmount(), entry.getValue().getDistanceTraveled()));

    }
}
