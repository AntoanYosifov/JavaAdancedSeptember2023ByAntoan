package bg.softUni.advanced.workshopLab.smartArray;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SmartArray<Integer> smartArray = new SmartArray<>();
        ArrayList<Integer> list = new ArrayList<>();

        smartArray.add(456);


        list.add(69);
        list.add(13);
        list.add(42);
        list.get(1);


        smartArray.forEach(System.out::println);

    }
}
