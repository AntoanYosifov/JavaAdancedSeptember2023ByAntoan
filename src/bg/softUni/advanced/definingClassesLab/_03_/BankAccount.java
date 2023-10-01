package bg.softUni.advanced.definingClassesLab._03_;

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private int id;
    private double balance;
    private static int accountsCount = 0;
    public BankAccount(){
        accountsCount++;
        this.id = accountsCount;
        this.balance = 0;
    }
    public double getInterest(int years){
        return this.balance * interestRate * years;
    }
    public  int getId() {
        return this.id;
    }
    public void deposit(double balance){
        this.balance += balance;
    }
    public static void setInterestRate(double interest){
        interestRate = interest;
    }


}
