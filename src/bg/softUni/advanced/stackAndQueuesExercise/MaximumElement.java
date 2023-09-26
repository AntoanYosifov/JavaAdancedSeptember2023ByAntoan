package bg.softUni.advanced.stackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "1" :
                    stack.push(Integer.parseInt(command[1]));
                    break;
                case "2" :
                    stack.poll();
                    break;
                case "3" :
                    System.out.println(Collections.max(stack));
                    break;
            }

        }
/*
7
1 81
2
1 14
2
1 14
1 47
3


 */

    }
}
