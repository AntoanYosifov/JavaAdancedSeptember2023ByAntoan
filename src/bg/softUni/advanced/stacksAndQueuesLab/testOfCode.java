package bg.softUni.advanced.stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class testOfCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(13);
        stack.push(42);
        stack.push(69);
        stack.push(73);
        int element = stack.getFirst();
        System.out.println(element);

    }
}
