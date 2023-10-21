package bg.softUni.advanced.practiceExams.exam17June23;

import java.util.*;
import java.util.stream.Collectors;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> toolsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(tool -> toolsQueue.offer(tool));

        ArrayDeque<Integer> stackSubstances = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(substance -> stackSubstances.push(substance));

        List<Integer> challenges = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        while (!stackSubstances.isEmpty() && !challenges.isEmpty()) {

            int tool = toolsQueue.peek();
            int substance = stackSubstances.peek();
            int result = tool * substance;

            if (challenges.contains(result)) {
                challenges.remove(Integer.valueOf(result));
                toolsQueue.poll();
                stackSubstances.pop();

            } else {
                toolsQueue.offer(toolsQueue.poll() + 1);

                stackSubstances.push(stackSubstances.pop() - 1);

                if (stackSubstances.peek() == 0) {
                    stackSubstances.pop();
                }

            }

        }

        if (challenges.isEmpty()) {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
            printRemainingToolsAndSubs(toolsQueue, stackSubstances);
        } else {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
            printRemainingToolsAndSubs(toolsQueue, stackSubstances);

            String challengesString = challenges.stream()
                    .map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Challenges: %s\n", challengesString);

        }

    }

    private static void printRemainingToolsAndSubs(ArrayDeque<Integer> toolsQueue, ArrayDeque<Integer> stackSubstances) {
        if (!toolsQueue.isEmpty()) {
            String toolsString = toolsQueue.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.printf("Tools: %s\n", toolsString);
        }

        if (!stackSubstances.isEmpty()) {
            String substanceString = stackSubstances.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.printf("Substances: %s\n", substanceString);
        }
    }


}
