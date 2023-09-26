package bg.softUni.advanced.stackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfixForJudge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<String> outputQue = new ArrayDeque<>();
        ArrayDeque<String> operatorsStack = new ArrayDeque<>();




        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            char c = s.charAt(0);
            if (Character.isDigit(c) || Character.isAlphabetic(c)) {
                outputQue.offer(s);
                continue;
            }
            if (operatorsStack.isEmpty()) {
                operatorsStack.push(s);
                continue;
            }
            String topOperator = operatorsStack.peek();
            String currentOperator = s;
            if (currentOperator.equals("(") || topOperator.equals("(")) {
                operatorsStack.push(currentOperator);
                continue;
            } else if (currentOperator.equals(")")) {
                while (!operatorsStack.isEmpty()) {
                    if (operatorsStack.peek().equals("(")) {
                        operatorsStack.pop();
                        break;
                    }
                    outputQue.offer(operatorsStack.pop());
                }
            }
            switch (topOperator) {
                case "*":
                    while (!operatorsStack.isEmpty()) {
                        if (operatorsStack.peek().equals("(")) {
                            operatorsStack.pop();
                            continue;
                        }
                        outputQue.offer(operatorsStack.pop());
                    }

                    operatorsStack.push(currentOperator);
                    break;
                case "/":
                    while (!operatorsStack.isEmpty()) {
                        if (operatorsStack.peek().equals("(")) {
                            operatorsStack.pop();
                            continue;
                        }
                        outputQue.offer(operatorsStack.pop());
                    }

                    operatorsStack.push(currentOperator);
                    break;
                case "+", "-":
                    switch (currentOperator) {
                        case "-":
                            while (!operatorsStack.isEmpty()) {
                                if (operatorsStack.peek().equals("(")) {
                                    operatorsStack.pop();
                                    continue;
                                }
                                outputQue.offer(operatorsStack.pop());
                            }
                            operatorsStack.push(currentOperator);
                            break;
                        case "+":
                            while (!operatorsStack.isEmpty()) {
                                if (operatorsStack.peek().equals("(")) {
                                    operatorsStack.pop();
                                    continue;
                                }
                                outputQue.offer(operatorsStack.pop());
                            }
                            operatorsStack.push(currentOperator);
                            break;
                        case "*":
                            operatorsStack.push(currentOperator);
                            break;
                        case "/":
                            operatorsStack.push(currentOperator);
                            break;
                    }
                    break;


            }

        }
        while (!operatorsStack.isEmpty()) {
            outputQue.offer(operatorsStack.pop());
        }
        while (!outputQue.isEmpty()) {
            System.out.print(outputQue.poll() + " ");
        }
        int x = 1;
    }


}
