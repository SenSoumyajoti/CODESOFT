package p1;
import java.util.Scanner;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("Please choose an option (1-4): ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    handleWithdraw(scanner);
                    break;
                case "2":
                    handleDeposit(scanner);
                    break;
                case "3":
                    handleCheckBalance();
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void handleWithdraw(Scanner scanner) {
        try {
            System.out.print("Enter the amount to withdraw: ");
            double amount = Double.parseDouble(scanner.nextLine());
            if (account.withdraw(amount)) {
                System.out.printf("Successfully withdrew $%.2f.%n", amount);
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
        }
    }

    private void handleDeposit(Scanner scanner) {
        try {
            System.out.print("Enter the amount to deposit: ");
            double amount = Double.parseDouble(scanner.nextLine());
            if (account.deposit(amount)) {
                System.out.printf("Successfully deposited $%.2f.%n", amount);
            } else {
                System.out.println("Invalid amount.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
        }
    }

    private void handleCheckBalance() {
        double balance = account.getBalance();
        System.out.printf("Your current balance is $%.2f.%n", balance);
    }
}
