package bg.softUni.advanced.stackAndQueuesExercise;


import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> outPutQue = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();
        String[] input = scanner.nextLine().split(" ");



        for (int i = 0; i < input.length; i++) {
            String tokenAsString = input[i];
            char tokenAsChar = tokenAsString.charAt(0);


            if(Character.isDigit(tokenAsChar) || Character.isAlphabetic(tokenAsChar)){
                outPutQue.offer(tokenAsString);
            }else if(tokenAsChar == '+' || tokenAsChar == '-' || tokenAsChar == '*' || tokenAsChar == '/'){
                while(!operatorStack.isEmpty() && !operatorStack.peek().equals("(") &&
                        precedence(operatorStack.peek()) >= precedence(tokenAsString)){
                    outPutQue.offer(operatorStack.pop());
                }
                operatorStack.push(tokenAsString);
            }else if(tokenAsString.equals("(")){
                operatorStack.push(tokenAsString);
            }else if( tokenAsString.equals(")")){
                while (!operatorStack.peek().equals("(")){
                    outPutQue.offer(operatorStack.pop());
                }
                operatorStack.pop();
            }
        }
        while (!operatorStack.isEmpty()){
            outPutQue.offer(operatorStack.pop());
        }
        while(!outPutQue.isEmpty()){
            System.out.print(outPutQue.poll() + " ");
        }


        // 5 / ( 3 + 2 )
    }

    public static int precedence(String operator) {
        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            return 2;
        } else {
            return 0;
        }
    }

}
