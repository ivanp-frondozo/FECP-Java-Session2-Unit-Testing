public class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double deposit(double amount){
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: ₱" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
        return this.balance;
    }

    public double withdraw(double amount){
        if (amount <= 0){
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance){
            System.out.println("Balance not enough.");
        } else{
            balance -= amount;
            System.out.println("Withdrew amount:" + amount + "New Balance: " + balance);
        }
        return balance;
    }

    public void displayInfo(){
        System.out.println("-----------------------");
        System.out.println("Account Number:" + this.accountNumber);
        System.out.println("Account Holder:" + this.accountHolder);
        System.out.println("Current Balance:" + this.balance);
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }
}
