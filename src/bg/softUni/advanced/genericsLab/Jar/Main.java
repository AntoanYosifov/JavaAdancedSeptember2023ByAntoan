package bg.softUni.advanced.genericsLab.Jar;


public class Main {
    public static void main(String[] args) {
        Jar<Integer> numbers = new Jar<>();
        numbers.add(13);
        numbers.add(15);
        int number = numbers.remove();
        System.out.println(number);

    }
}
