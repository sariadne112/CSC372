public class BankAccount {

    protected String firstName;
    protected String lastName;
    protected int accountID;
    protected double balance;

    // Default constructor
    public BankAccount() {
        balance = 2500.0;
    }
    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    // Getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAccountID() {
        return accountID;
    }
    public double getBalance() {
        return balance;
    }

    // Deposit
    public String deposit(double amount) {

        if (amount <= 0) {
            return "Amount must be greater than zero.";
        }
        balance = balance + amount;
        return "Deposit successful.";
    }

     // Normal withdrawal
    public String withdrawal(double amount) {

        if (amount <= 0) {
            return "Amount must be greater than zero.";
        }
        if (amount > balance) {
            return "Insufficient funds.";
        }
        balance = balance - amount;
        return "Withdrawal successful.";
    }

    // Account summary
    public void accountSummary() {
        System.out.println("\n--- Account Summary ---");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.printf("Balance: $%.2f%n", balance);
    }
}