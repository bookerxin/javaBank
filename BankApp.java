import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();
        account.showMenu();

    }

    static class BankAccount {

        // Class variables and scanner

        int amount = 0;
        int balance = 0;
        int previousTransaction;
        String customerName;
        String customerId;
        char option;

        // Cosmetic border
        void printBorder() {
            String border = "==============================";
            System.out.println(border);
        }

        // Methods to change balance and prev transaction

        void deposit(int amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Your balance is now: " + balance);
                previousTransaction = amount;
            }
        }

        void withdraw(int amount) {
            if (amount < 0) {
                balance -= amount;
                System.out.println("Your balance has been reduced to: " + balance);
                previousTransaction = amount;
            }
        }

        // Main menu interface

        void showOptions() {
            System.out.println("A: Show balance.");
            System.out.println("B: Deposit.");
            System.out.println("C: Withdraw.");
            System.out.println("D: Previous Transaction.");
            System.out.println("E: Exit.");
        }

        void showMenu() {

            do {

                showOptions();

                System.out.println("Please choose an option: ");
                Scanner scanner = new Scanner(System.in);
                option = scanner.nextLine().charAt(0);

                switch (option) {

                    case 'A':
                        printBorder();
                        System.out.println("Your balance is: " + balance);
                        printBorder();
                        break;

                    case 'B':
                        printBorder();
                        System.out.println("Enter your deposit: ");
                        printBorder();
                        amount = scanner.nextInt();
                        deposit(amount); // Try to deposit, breaks before the method finishes running, then tries to access index of option[0] but doesn't wait for input?
                        break;

                    case 'C':
                        printBorder();
                        System.out.println("Enter your withdrawal: ");
                        printBorder();
                        amount = -scanner.nextInt();
                        withdraw(amount);
                        break;

                    case 'D':
                        printBorder();
                        System.out.println("Previous transaction: " + previousTransaction);
                        printBorder();
                        break;

                    case 'E':
                        printBorder();
                        System.out.println("Thank you for using our service");
                        printBorder();
                        break;

                    default:
                        System.out.println("Please choose a valid option!");
                        break;
                }

            } while (option != 'E');
        }

    }

}