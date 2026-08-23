import java.util.Scanner;

public class MainBank {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        CheckingAccount account = new CheckingAccount();
        boolean overdrafted = false;
        // Preset account information
        account.setFirstName("Samantha");
        account.setLastName("Fuentes");
        account.setAccountID(42671);
        account.setInterestRate(2.5);

        boolean running = true; //boolean for while loop

        while (running) {
//Main Menu
            System.out.println("\n===== WELCOME TO BANKING =====");
            System.out.println("Please choose one option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawal");
            System.out.println("3. View Balance");
            System.out.println("4. Display Account");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scnr.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Deposit Money ---");
                    System.out.print("How much would you like to deposit?: ");

                    double depositAmount = scnr.nextDouble();//Deposit Amount to Account
                    System.out.println(account.deposit(depositAmount));
                    break;
                case 2:
                    System.out.println("\n--- Withdrawal Money ---");
                    System.out.print("How much would you like to withdraw?: ");

                    double withdrawalAmount = scnr.nextDouble();//Withdrawal on account

                    if (withdrawalAmount <= 0) { //Withdrawal has to be higher than account balance
                        System.out.println("Amount must be greater than zero.");

                    } else if (withdrawalAmount <= account.getBalance()) {  
                        System.out.println(account.withdrawal(withdrawalAmount));

                    } else {
                        System.out.println("You do not have enough funds for this withdrawal."
                        );
                        //Option to overdraft
                        System.out.println("Continuing will result in a $30 overdraft fee.");
                        System.out.print("Would you like to continue? (Y/N): ");
                        char overdraftChoice = scnr.next().charAt(0);

                        if (overdraftChoice == 'Y' || overdraftChoice == 'y') {
                            System.out.println(account.processWithdrawal(withdrawalAmount));
                            overdrafted = true;
                            System.out.printf("New balance: $%.2f%n", account.getBalance());
                        } else {
                            System.out.println("Withdrawal cancelled.");
                            }
                    }
                    break;
                case 3:
                    System.out.println("\n--- Account Balance ---");
                    System.out.printf("Current Balance: $%.2f%n",account.getBalance());
                    break;

                case 4:
                    System.out.println("\n--- Account Summary ---");

    if (overdrafted) {
        account.displayAccount();
    } else {
        account.accountSummary();
    }

    break;

                case 5:
                    System.out.println("Exiting Bank. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println(
                        "Invalid option. Please enter a number between 1 and 5."
                    );
            }
        }
        scnr.close();
    }
}