import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactions;

    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println(" Invalid deposit amount.");
            return;
        }
        balance += amount;
        transactions.add("Deposited " + amount + ", New Balance: " + balance);
        System.out.println( + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Invalid withdrawal amount.");
            return;
        }
        if (amount > balance) {
            System.out.println(" Insufficient balance.");
            return;
        }
        balance -= amount;
        transactions.add("Withdrew ₹" + amount + ", New Balance: " + balance);
        System.out.println( + amount + " withdrawn successfully.");
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactions() {
        System.out.println(" Transaction History:");
        for (String t : transactions) {
            System.out.println("- " + t);
        }
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print(" Enter initial deposit amount: ");
        double initial = scanner.nextDouble();

        Account acc = new Account(name, initial);
        int choice;

        do {
            System.out.println("\n Bank Menu");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Show Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount to deposit: ");
                    double dep = scanner.nextDouble();
                    acc.deposit(dep);
                }
                case 2 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double wit = scanner.nextDouble();
                    acc.withdraw(wit);
                }
                case 3 -> System.out.println(" Current Balance:" + acc.getBalance());
                case 4 -> acc.showTransactions();
                case 5 -> System.out.println(" Exiting Bank App. Thank you!");
                default -> System.out.println(" Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
