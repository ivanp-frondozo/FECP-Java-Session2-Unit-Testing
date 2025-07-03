import java.util.*;

public class BankSystem {
    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public void systemMenu(){
        int menuNumber;

        while (true) {
            System.out.println("=== Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-5): ");

            if (scanner.hasNextInt()) {
                menuNumber = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (menuNumber) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAllAccounts();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    deposit();
                    break;
                case 5:
                    withdraw();
                    break;
                case 6:
                    System.out.println("Thank you for using the Bank System!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        }
    }

    private void createAccount() {
        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Initial deposit? (yes/no): ");
        String answer = scanner.nextLine();

        double initialDeposit = 0;
        if (answer.equalsIgnoreCase("yes")) {
            System.out.print("Enter deposit amount: ");
            initialDeposit = scanner.nextDouble();
            scanner.nextLine();
            if (initialDeposit < 0) {
                System.out.println("Deposit must be non-negative.");
                return;
            }
        }

        BankAccount account = new BankAccount(accNum, name, initialDeposit);
        accounts.add(account);
        System.out.println("Account successfully created!");
    }

    private void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (BankAccount acc : accounts) {
            acc.displayInfo();
        }
    }

    private void checkBalance() {
        System.out.print("Enter account number: ");
        int searchNum = scanner.nextInt();
        scanner.nextLine();

        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == searchNum) {
                System.out.println("Current Balance: ₱" + acc.getBalance());
                return;
            }
        }

        System.out.println("Account not found.");
    }

    private void deposit() {
        System.out.print("Enter account number: ");
        int searchNum = scanner.nextInt();
        scanner.nextLine();

        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == searchNum) {
                System.out.print("Enter deposit amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                acc.deposit(amount);
                return;
            }
        }

        System.out.println("Account not found.");
    }

    private void withdraw() {
        System.out.print("Enter account number: ");
        int searchNum = scanner.nextInt();
        scanner.nextLine();

        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == searchNum) {
                System.out.print("Enter withdrawal amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                acc.withdraw(amount);
                return;
            }
        }

        System.out.println("Account not found.");
    }

    public static void main(String[] args){
        BankSystem system = new BankSystem();
        system.systemMenu();
    }

}