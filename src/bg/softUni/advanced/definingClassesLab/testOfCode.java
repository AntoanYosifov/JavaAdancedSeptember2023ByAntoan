package bg.softUni.advanced.definingClassesLab;

import java.util.ArrayList;
import java.util.List;

public class testOfCode {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        add5(numbers);
        System.out.println(numbers.size());
        int a = 0;
        int i = changeTo5(a);
        System.out.println(i);
        System.out.println(a);

    }

    private static int changeTo5(int a) {
       return a += 5;
    }

    private static void add5(List<Integer> list) {
         list.add(5);
    }
}
