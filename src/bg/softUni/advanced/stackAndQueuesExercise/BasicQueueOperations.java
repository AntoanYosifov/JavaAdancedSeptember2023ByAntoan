package bg.softUni.advanced.stackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(tokens[0]);
        int s = Integer.parseInt(tokens[1]);
        int x = Integer.parseInt(tokens[2]);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt)
                .forEach(deque::offer);

        for (int i = 0; i < s; i++) {
            deque.poll();
        }
        if(deque.isEmpty()){
            System.out.println(0);
        }else if(deque.contains(x)){
            System.out.println(true);
        }else{
            System.out.println(Collections.min(deque));
        }



    }
}
