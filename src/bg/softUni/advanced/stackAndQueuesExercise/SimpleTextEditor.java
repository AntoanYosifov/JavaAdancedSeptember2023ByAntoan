package bg.softUni.advanced.stackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();

        ArrayDeque<String> commands = new ArrayDeque<>();
        ArrayDeque<String> removedElements = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String rawCommand = scanner.nextLine();
            ;
            String[] commandArgs = rawCommand.split("\\s+");
            switch (commandArgs[0]) {
                case "1":
                    commands.push(rawCommand);
                    add(text, commandArgs[1]);
                    break;
                case "2":
                    commands.push(rawCommand);
                    int countElements = Integer.parseInt(commandArgs[1]);
                    saveDeletedElements(text, countElements, removedElements);
                    delete(text, countElements);
                    break;
                case "3":
                    int index = Integer.parseInt(commandArgs[1]);
                    System.out.printf("%s\n", text.charAt(index - 1));
                    break;
                case "4":
                    String lastCommand = commands.pop();
                    String[] lastCommandArgs = lastCommand.split("\\s+");
                    String lastCommandType = lastCommandArgs[0];
                    if (lastCommandType.equals("1")) {
                        int numberOfElementsToDelete = lastCommandArgs[1].length();
                        delete(text, numberOfElementsToDelete);
                    } else {
                        add(text, removedElements.pop());
                    }
                    break;
            }
        }


    }

    private static void saveDeletedElements(StringBuilder text, int countElements, ArrayDeque<String> removedElements) {
        StringBuilder sb = new StringBuilder();
        for (int i = text.length() - countElements; i < text.length(); i++) {
            sb.append(text.charAt(i));
        }
        removedElements.push(sb.toString());
    }

    private static void delete(StringBuilder text, int count) {
        int textLength = text.length() ;
        for (int i = 1; i <= count; i++) {

            text.deleteCharAt(textLength - i);
        }
    }


    private static void add(StringBuilder text, String commandArg) {
        text.append(commandArg);
    }
}
/*
8
1 abc
3 3
2 3
1 xy
3 2
4 4
3 1


 */