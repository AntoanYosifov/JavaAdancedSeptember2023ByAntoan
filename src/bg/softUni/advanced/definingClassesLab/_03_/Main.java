package bg.softUni.advanced.definingClassesLab._03_;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String END_COMMAND = "End";
    private static final String CREATE = "Create";
    private static final String DEPOSIT = "Deposit";
    private static final String SET_INTEREST = "SetInterest";
    private static final String GET_INTEREST = "GetInterest";


    private static Map<Integer, BankAccount> accounts;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        accounts = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals(END_COMMAND)) {
            String[] inputParts = input.split(" ");
            String command = inputParts[0];
            String result = "";

            switch (command) {
                case CREATE:
                    result = createAccount();
                    break;
                case DEPOSIT:
                    result = depositInAccount(inputParts);
                    break;
                case SET_INTEREST:
                    result = setInterest(inputParts);
                    break;
                case GET_INTEREST:
                    result = getInterest(inputParts);
            }

            if (!result.isEmpty()) {
                System.out.println(result);
            }

            input = scanner.nextLine();
        }
    }

    public static String createAccount() {
        BankAccount bankAccount = new BankAccount();
        int id = bankAccount.getId();
        accounts.put(id, bankAccount);
        return String.format("Account ID%d created", id);
    }

    public static String depositInAccount(String[] args) {
        int accountId = Integer.parseInt(args[1]);
        double amount = Double.parseDouble(args[2]);
        BankAccount bankAccount = accounts.get(accountId);

        if (bankAccount == null) {
            return "Account does not exist";
        }
        bankAccount.deposit(amount);

        return String.format("Deposited %d to ID%d", (int) amount, accountId);
    }

    private static String setInterest(String[] args) {

        double interest = Double.parseDouble(args[1]);
        BankAccount.setInterestRate(interest);
        return "";
    }

    private static String getInterest(String[] args) {
        int id = Integer.parseInt(args[1]);
        int years = Integer.parseInt(args[2]);

        BankAccount bankAccount = accounts.get(id);

        if (bankAccount == null) {
            return "Account does not exist";
        }

        double interest = bankAccount.getInterest(years);

        return String.format("%.2f", interest);
    }


}
