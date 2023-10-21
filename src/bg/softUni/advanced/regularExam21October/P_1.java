package bg.softUni.advanced.regularExam21October;


import java.util.*;
import java.util.stream.Collectors;

public class P_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> initialFuelStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(fuel -> initialFuelStack.push(fuel));

        ArrayDeque<Integer> addConsumptionIndexQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(index -> addConsumptionIndexQueue.offer(index));

        List<Integer> neededFuelList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        int altitudes = 0;
        List<Integer> reachedAltitudes = new ArrayList<>();

        boolean haveEnoughFuel = true;
        while (haveEnoughFuel && !neededFuelList.isEmpty()) {

            int fuel = initialFuelStack.peek();
            int consIndex = addConsumptionIndexQueue.peek();

            int result = fuel - consIndex;
            int neededFuel = neededFuelList.get(0);
            altitudes++;

            if (result >= neededFuel) {
                reachedAltitudes.add(altitudes);
                neededFuelList.remove(0);
                initialFuelStack.pop();
                addConsumptionIndexQueue.poll();
                System.out.printf("John has reached: Altitude %d\n", altitudes);
            } else {
                System.out.printf("John did not reach: Altitude %d\n", altitudes);
                haveEnoughFuel = false;

            }

        }

        if (neededFuelList.isEmpty()) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        } else {
            System.out.println("John failed to reach the top.");

            if (!reachedAltitudes.isEmpty()) {
                System.out.print("Reached altitudes: ");
                for (int i = 0; i < reachedAltitudes.size(); i++) {
                    if (i == reachedAltitudes.size() - 1) {
                        System.out.printf("Altitude %d", reachedAltitudes.get(i));
                    } else {
                        System.out.printf("Altitude %d, ", reachedAltitudes.get(i));
                    }
                }
            } else {
                System.out.println("John didn't reach any altitude.");
            }

        }

    }
}
