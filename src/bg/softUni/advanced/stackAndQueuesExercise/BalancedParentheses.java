package bg.softUni.advanced.stackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        String result = isBalanced(input) ? "YES" : "NO";
        System.out.println(result);


    }

    private static boolean isBalanced(List<String> input) {
        ArrayDeque<String> openParentheses = new ArrayDeque<>();
        for (String brace : input) {
            switch (brace){
                case "}":
                    if(openParentheses.isEmpty()){
                        return false;
                    }
                    String openBrace = openParentheses.pop();
                    if(!openBrace.equals("{")){
                        return false;
                    }
                    break;
                case "]":
                    if(openParentheses.isEmpty()){
                        return false;
                    }
                     openBrace = openParentheses.pop();
                    if(!openBrace.equals("[")){
                        return false;
                    }
                    break;
                case ")":
                    if(openParentheses.isEmpty()){
                        return false;
                    }
                     openBrace = openParentheses.pop();
                    if(!openBrace.equals("(")){
                        return false;
                    }
                    break;
                default:
                    openParentheses.push(brace);
            }
        }



        return true;
    }
}
