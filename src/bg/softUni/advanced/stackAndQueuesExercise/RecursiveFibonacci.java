package bg.softUni.advanced.stackAndQueuesExercise;

import java.util.Scanner;

public class RecursiveFibonacci {
    private static long[] memmory;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        memmory = new long[n + 1];
        long result = fibonacci(n);
        System.out.println(result);
    }

    private static long fibonacci(int n) {
        if(n < 2){
            return 1;
        }
        if(memmory[n] != 0){
            return memmory[n];
        }
        memmory[n] = fibonacci(n -1) + fibonacci(n - 2);
        return memmory[n];
    }
}
