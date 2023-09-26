package bg.softUni.advanced.setsAndMapsAdvanced_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, String> emails = new LinkedHashMap<>();


        while (!"stop".equals(line)) {
            String name = line;
            String email = scanner.nextLine();

            if (!email.contains(".us") && !email.contains(".uk") && !email.contains(".com")) {
                emails.put(name, email);
            }

            line = scanner.nextLine();
        }
        emails.forEach((k, v) -> System.out.printf("%s -> %s\n", k, v));

    }
}
