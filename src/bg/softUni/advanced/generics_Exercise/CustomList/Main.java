package bg.softUni.advanced.generics_Exercise.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> customList = new CustomList<String>();

        String line = scanner.nextLine();
        while (!"END".equals(line)) {

            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {

                case "Add":
                    customList.add(tokens[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(tokens[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    for (String element : customList) {
                        System.out.println(element);
                    }
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
