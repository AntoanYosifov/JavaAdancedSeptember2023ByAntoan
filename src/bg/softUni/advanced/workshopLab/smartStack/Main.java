package bg.softUni.advanced.workshopLab.smartStack;

public class Main {
    public static void main(String[] args) {
        SmartStack stack = new SmartStack();


        stack.push(13);
        stack.push(42);
        stack.push(54);
        stack.push(8);
        stack.push(17);

        System.out.println(stack.pop());
    }
}
