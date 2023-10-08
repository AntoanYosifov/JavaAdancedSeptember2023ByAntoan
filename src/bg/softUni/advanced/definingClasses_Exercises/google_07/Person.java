package bg.softUni.advanced.definingClasses_Exercises.google_07;



import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemonList;
    private List<Parent> parentList;
    private List<Child> childList;
    private Car car;

    public Person(String name) {
        this.pokemonList = new ArrayList<>();
        this.parentList = new ArrayList<>();
        this.childList = new ArrayList<>();
        this.name = name;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public void addParent(Parent parent) {
        this.parentList.add(parent);
    }

    public void addChild(Child child) {
        this.childList.add(child);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public static class Company {
        private String name;
        private String department;
        private double salary;

        public Company(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }
    }

    public static class Pokemon {
        private String name;
        private String type;

        public Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class Parent {
        private String name;
        private String birthDay;

        public Parent(String name, String birthDay) {
            this.name = name;
            this.birthDay = birthDay;
        }

        public String getName() {
            return name;
        }

        public String getBirthDay() {
            return birthDay;
        }
    }

    public static class Child {
        private String name;
        private String birthDay;

        public Child(String name, String birthDay) {
            this.name = name;
            this.birthDay = birthDay;
        }

        public String getName() {
            return name;
        }

        public String getBirthDay() {
            return birthDay;
        }
    }

    public static class Car {
        private String model;
        private int speed;

        public Car(String model, int speed) {
            this.model = model;
            this.speed = speed;

        }

        public String getModel() {
            return model;
        }

        public int getSpeed() {
            return speed;
        }
    }
// JohnJohnson
//Company:
//Car:
//Trabant 30
//Pokemon:
//Electrode Electricity
//Parents:
//Children:

    // GeorgeJohnson
    //Company:
    //JeleInc Jelior 777.77
    //Car:
    //AudiA4 180
    //Pokemon:
    //Onyx Rock
    //Charizard Fire
    //Parents:
    //SaraJohnson 13/03/1933
    //Children:
    //SamJohnson 01/01/2001
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(System.lineSeparator());
        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(String.format("%s %s %.02f", this.company.getName(), this.company.getDepartment(),
                    this.company.getSalary())).append(System.lineSeparator());
        }
        sb.append("Car: ").append(System.lineSeparator());
        if (this.car != null) {
            sb.append(this.car.getModel()).append(" ").append(this.car.getSpeed()).append(System.lineSeparator());
        }
        sb.append("Pokemon: ").append(System.lineSeparator());
        if (!this.pokemonList.isEmpty()) {
            for (Pokemon pokemon : this.pokemonList) {
                sb.append(pokemon.getName()).append(" ").append(pokemon.getType()).append(System.lineSeparator());
            }
        }
        sb.append("Parents: ").append(System.lineSeparator());
        if (!this.parentList.isEmpty()) {
            for (Parent parent : this.parentList) {
                sb.append(parent.getName()).append(" ").append(parent.getBirthDay()).append(System.lineSeparator());
            }
        }
        sb.append("Children: ").append(System.lineSeparator());
        if (!this.childList.isEmpty()) {
            for (Child child : this.childList) {
                sb.append(child.getName()).append(" ").append(child.getBirthDay()).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
