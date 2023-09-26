package bg.softUni.advanced.setsAndMapsAdvanced_Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, String> phonebook = new HashMap<>();

        while (!"search".equals(line)) {
            String[] data = line.split("-");
            String name = data[0];
            String phone = data[1];
            phonebook.put(name, phone);

            line = scanner.nextLine();
        }

        line = scanner.nextLine();
        while (!"stop".equals(line)) {
            String name = line;
            if (!phonebook.containsKey(name)) {
                System.out.printf("Contact %s does not exist.\n", name);
            } else {
                System.out.printf("%s -> %s\n", name, phonebook.get(name));
            }


            line = scanner.nextLine();
        }

    }
}
