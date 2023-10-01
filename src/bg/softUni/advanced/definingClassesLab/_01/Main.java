package bg.softUni.advanced.definingClassesLab._01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] carParts = scanner.nextLine().split(" ");
            Car car = new Car();
            car.setBrand(carParts[0]);
            car.setModel(carParts[1]);
            car.setHorsePower(Integer.parseInt(carParts[2]));

            System.out.println(car.carInfo());
        }


    }

    public static void test() {
        Car firstCar = new Car();
        firstCar.setBrand("Kia");
        firstCar.setModel("Sportage");
        firstCar.setHorsePower(131);

//        Car secondCar = new Car();
//        secondCar.setBrand("Mercedes");
//        secondCar.setModel("S class");
//        secondCar.setHorsePower(495);

//        System.out.println(firstCar);
//        System.out.println(secondCar);
        System.out.println(firstCar.carInfo());
    }
}
