package bg.softUni.advanced.definingClasses_Exercises.opinionPoll_01;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         int n = Integer.parseInt(scanner.nextLine());
        Map<String, Person> people = new TreeMap<>();
        for (int i = 0; i < n; i++) {
           String[] personData = scanner.nextLine().split("\\s+");

           String name = personData[0];
           int age = Integer.parseInt(personData[1]);

           Person currentPerson = new Person(name, age);
           people.put(name, currentPerson);

        }

        people.entrySet().stream().filter(entry-> entry.getValue().getAge() > 30)
                .forEach(entry-> System.out.println(entry.getKey() + " - " + entry.getValue().getAge()));

    }
}
