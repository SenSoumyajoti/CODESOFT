
package p1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial balance for the account: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // consume the newline

        BankAccount account = new BankAccount(initialBalance);
        ATM atm = new ATM(account);
        atm.run();
    }
}
