public class CheckingAccount extends BankAccount{
    private double interestRate;

    public CheckingAccount() {
        super();
        interestRate = 0.0;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String processWithdrawal(double amount) {

        if (amount <= 0) {
            return "Amount must be greater than zero.";
        }
        // Subtract withdrawal and overdraft fee
        balance = balance - amount - 30.00;
        return "Overdraft processed. A $30.00 fee has been assessed.";
    }

    public void displayAccount() {
        System.out.println("\n----- Checking Account -----");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.printf("Balance: $%.2f%n", balance);
        System.out.printf("Interest Rate: %.2f%%%n", interestRate);
    }
}
