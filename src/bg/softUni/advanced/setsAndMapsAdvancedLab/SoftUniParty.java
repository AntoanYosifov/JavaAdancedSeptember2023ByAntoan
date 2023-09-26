package bg.softUni.advanced.setsAndMapsAdvancedLab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String guest = scanner.nextLine();
        while (!"PARTY".equals(guest)){

            char startsWith = guest.charAt(0);
            if(Character.isDigit(startsWith)){
                vip.add(guest);
            } else {
                regular.add(guest);
            }

            guest = scanner.nextLine();
        }

        guest = scanner.nextLine();
        while (!"END".equals(guest)){
            vip.remove(guest);
            regular.remove(guest);


            guest = scanner.nextLine();
        }
        System.out.println(vip.size() + regular.size());
        printStringSet(vip);
        printStringSet(regular);

    }
    private static void printStringSet(Set<String> parkingLot) {
        for (String e: parkingLot) {
            System.out.println(e);
        }
    }
}
