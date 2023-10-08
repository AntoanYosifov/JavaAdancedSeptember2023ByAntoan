package bg.softUni.advanced.definingClasses_Exercises.google_07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new HashMap<>();
// •	"{Name} company {companyName} {department} {salary}"
//•	"{Name} pokemon {pokemonName} {pokemonType}"
//•	"{Name} parents {parentName} {parentBirthday}"
//•	"{Name} children {childName} {childBirthday}"
//•	"{Name} car {carModel} {carSpeed}"
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] personsData = input.split("\\s+");
            String personName = personsData[0];
            String infoType = personsData[1];
            String name = null;
            String birthDay = null;
            Person currentPerson = people.get(personName);
            if (currentPerson == null) {
                people.put(personName, new Person(personName));
                currentPerson = people.get(personName);
            }

            switch (infoType) {
                case "company":
                    String companyName = personsData[2];
                    String department = personsData[3];
                    double salary = Double.parseDouble(personsData[4]);
                    Person.Company company = new Person.Company(companyName, department, salary);
                    currentPerson.setCompany(company);

                    break;
                case "pokemon":
                    String pokemonName = personsData[2];
                    String pokemonType = personsData[3];
                    Person.Pokemon pokemon = new Person.Pokemon(pokemonName, pokemonType);
                    currentPerson.addPokemon(pokemon);
                    break;
                case "parents":
                    name = personsData[2];
                    birthDay = personsData[3];
                    Person.Parent parent = new Person.Parent(name, birthDay);
                    currentPerson.addParent(parent);
                    break;
                case "children":
                    name = personsData[2];
                    birthDay = personsData[3];
                    Person.Child child = new Person.Child(name, birthDay);
                    currentPerson.addChild(child);
                    break;
                case "car":
                    String carModel = personsData[2];
                    int carSpeed = Integer.parseInt(personsData[3]);
                    Person.Car car = new Person.Car(carModel, carSpeed);
                    currentPerson.setCar(car);
                    break;
            }

            input = scanner.nextLine();
        }

        String name = scanner.nextLine();
        Person reqiredPerson = people.get(name);
        System.out.println(reqiredPerson);
    }
}
