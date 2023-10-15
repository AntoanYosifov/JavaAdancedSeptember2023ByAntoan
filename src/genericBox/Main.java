package genericBox;

import bg.softUni.advanced.genericsLab.GenericScale.Scale;

public class Main {
    public static void main(String[] args) {

        Scale<String> scale = new Scale<>("a", "c");

        Scale<Integer> scale2 = new Scale<>(13, 13);

        System.out.println(scale.getHeavier());
        System.out.println(scale2.getHeavier());

    }
}
