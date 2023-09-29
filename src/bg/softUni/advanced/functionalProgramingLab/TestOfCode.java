package bg.softUni.advanced.functionalProgramingLab;

import com.sun.tools.javac.Main;

import java.util.function.Function;

public class TestOfCode {
    public static void main(String[] args) {
        Function<Integer, Integer> test = x -> x * x;
        increment(5);
        test.apply(5);


    }

    private static int increment(int num) {
        return num + 1;
    }

}
