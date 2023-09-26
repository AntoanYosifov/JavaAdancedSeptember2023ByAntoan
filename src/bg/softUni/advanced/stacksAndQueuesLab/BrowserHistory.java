package bg.softUni.advanced.stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browser = new ArrayDeque<>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();
        String line = scanner.nextLine();
        String current = "";
        /*
forward
https//softuni.bg/
https//softuni.bg/trainings/courses
back
forward
https//softuni.bg/trainings/2056
back
forward
forward
https//softuni.bg/trainings/courses
Home


         */
        while (!"Home".equals(line)) {
            if ("back".equals(line)) {
                if (!browser.isEmpty()) {
                    forwardPages.addFirst(current);
                    current = browser.pop();


                } else {
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                }
            } else if (line.equals("forward")) {
                if (forwardPages.isEmpty()) {
                    System.out.println("no next URLs");
                    line = scanner.nextLine();
                    continue;
                } else {
                    browser.push(current);
                    current = forwardPages.poll();

                }


            } else {
                if (!current.equals("")) {
                    browser.push(current);
                    forwardPages.clear();
                }
                current = line;

            }
            System.out.println(current);

            line = scanner.nextLine();
        }

    }
}
