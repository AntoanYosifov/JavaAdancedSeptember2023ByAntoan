package bg.softUni.advanced.setsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> parkingLot = new LinkedHashSet<>();

        while (!"END".equals(input)) {
            String[] tokens = input.split(", ");

            String direction = tokens[0];
            String carRegNum = tokens[1];
            if("IN".equals(direction)){
                parkingLot.add(carRegNum);
            }else{
             parkingLot.remove(carRegNum);
            }


            input = scanner.nextLine();
        }
        if(parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            printStringSet(parkingLot);
        }


    }

    private static void printStringSet(Set<String> parkingLot) {
        for (String e: parkingLot) {
            System.out.println(e);
        }
    }
}
