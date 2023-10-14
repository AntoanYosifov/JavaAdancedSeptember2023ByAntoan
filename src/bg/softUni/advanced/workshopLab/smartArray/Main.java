package bg.softUni.advanced.workshopLab.smartArray;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();
        ArrayList<Integer> list = new ArrayList<>();

        smartArray.add(13);
        smartArray.add(42);
        smartArray.add(69);
        smartArray.add(73);
        smartArray.add(1, 56);
        smartArray.get(2);

        list.add(69);
        list.add(13);
        list.add(42);
        list.get(1);


        smartArray.forEach(System.out::println);

    }
}
