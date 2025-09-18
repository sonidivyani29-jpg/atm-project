import java.util.Scanner;

class ATM {
    private double balance;
    private int pin;

    public ATM(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    public boolean login(int enteredPin) {
        return enteredPin == pin;
    }

    public void checkBalance() {
        System.out.println("Your balance: ₹" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ATM atm = new ATM(5000, 1234); // initial balance & PIN
        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (atm.login(enteredPin)) {
            int choice;
            do {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double deposit = sc.nextDouble();
                        atm.deposit(deposit);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdraw = sc.nextDouble();
                        atm.withdraw(withdraw);
                        break;
                    case 4:
                        System.out.println("Thank you for using ATM!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Invalid PIN! Access denied.");
        }

        sc.close();
    }
}

