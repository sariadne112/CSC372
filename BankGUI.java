import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class BankGUI extends BankAccount implements ActionListener{
    private static BankAccount account;
    // Sign in components
    private static JTextField accountField;
    private static JLabel accountLabel;
    private static JLabel validationLabel;
    private static JButton signInButton;

    // Main menu buttons
    private static JButton depositButton;
    private static JButton withdrawButton;
    private static JButton balanceButton;
    private static JButton exitButton;

    // Transaction components
    private static JLabel transactionLabel;
    private static JFormattedTextField amountField;
    private static JButton enterDepositButton;
    private static JButton enterWithdrawButton;
    private static JButton returnButton;

    // Balance display
    private static JLabel balanceLabel;
  public static void main(String[] args) {
        account = new BankAccount();
        JFrame topFrame = new JFrame("Bank Account");

        // JPanel required by assignment
        JPanel bankPanel = new JPanel(new GridBagLayout());

        GridBagConstraints layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 10);

        BankGUI listener = new BankGUI();
        // Sign in
        accountLabel = new JLabel("Account:");

        accountField = new JTextField(20);
        accountField.setEditable(true);

        signInButton = new JButton("Sign In");
        signInButton.addActionListener(listener);

        validationLabel = new JLabel("");

        // Account label
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        bankPanel.add(accountLabel, layoutConst);

        // Account text field
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        bankPanel.add(accountField, layoutConst);

        // Validation message
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.gridwidth = 2;
        bankPanel.add(validationLabel, layoutConst);

        layoutConst.gridwidth = 1;

        // Sign in button
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        bankPanel.add(signInButton, layoutConst);

        // MAIN MENU BUTTONS
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        balanceButton = new JButton("Balance");
        exitButton = new JButton("Exit");

        depositButton.addActionListener(listener);
        withdrawButton.addActionListener(listener);
        balanceButton.addActionListener(listener);
        exitButton.addActionListener(listener);

        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        bankPanel.add(depositButton, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 3;
        bankPanel.add(withdrawButton, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        bankPanel.add(balanceButton, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 4;
        bankPanel.add(exitButton, layoutConst);

        // Hide menu until account is signed in
        depositButton.setVisible(false);
        withdrawButton.setVisible(false);
        balanceButton.setVisible(false);
        exitButton.setVisible(false);

        // Transaction
        transactionLabel = new JLabel("");
        amountField =
            new JFormattedTextField(NumberFormat.getCurrencyInstance());

        amountField.setColumns(10);
        amountField.setEditable(true);

        enterDepositButton = new JButton("Deposit");
        enterDepositButton.addActionListener(listener);

        enterWithdrawButton = new JButton("Withdraw");
        enterWithdrawButton.addActionListener(listener);

        returnButton = new JButton("Return");
        returnButton.addActionListener(listener);

        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        bankPanel.add(transactionLabel, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        bankPanel.add(amountField, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 6;
        bankPanel.add(enterDepositButton, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 6;
        bankPanel.add(enterWithdrawButton, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 6;
        bankPanel.add(returnButton, layoutConst);

        // Hide transaction components
        transactionLabel.setVisible(false);
        amountField.setVisible(false);
        enterDepositButton.setVisible(false);
        enterWithdrawButton.setVisible(false);
        returnButton.setVisible(false);
        // Balance Label
        
        balanceLabel = new JLabel("");

        layoutConst.gridx = 0;
        layoutConst.gridy = 7;
        layoutConst.gridwidth = 2;
        bankPanel.add(balanceLabel, layoutConst);

        balanceLabel.setVisible(false);
        // Button appearance
        Dimension buttonSize = new Dimension(110, 35);
        depositButton.setPreferredSize(buttonSize);
        withdrawButton.setPreferredSize(buttonSize);
        enterWithdrawButton.setPreferredSize(buttonSize);

        Dimension smallButtonSize = new Dimension(85, 25);
        balanceButton.setPreferredSize(smallButtonSize);
        exitButton.setPreferredSize(smallButtonSize);
        signInButton.setPreferredSize(smallButtonSize);
        returnButton.setPreferredSize(smallButtonSize);
        enterDepositButton.setPreferredSize(smallButtonSize);

        Color customBlue = new Color(203, 238, 243);
        Color bankPink = new Color(244, 156, 187);

        signInButton.setBackground(customBlue);
        exitButton.setBackground(customBlue);
        balanceButton.setBackground(customBlue);
        returnButton.setBackground(customBlue);
        enterDepositButton.setBackground(customBlue);
        enterWithdrawButton.setBackground(customBlue);

        depositButton.setBackground(bankPink);
        withdrawButton.setBackground(bankPink);
        // FRAME SETTINGS
        
        topFrame.add(bankPanel);

        topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        topFrame.setSize(500, 500);
        topFrame.setLocationRelativeTo(null);
        topFrame.setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent event) {
        // SIGN IN
        if (event.getSource() == signInButton) {

            try {

                int accountID =
                    Integer.parseInt(accountField.getText());

                if (accountID == 42671) {

                    account.setAccountID(accountID);

                    // Hide sign-in screen
                    accountField.setVisible(false);
                    accountLabel.setVisible(false);
                    signInButton.setVisible(false);

                    validationLabel.setText(
                        "Account " + accountID + " Signed In.");
                    // Show menu
                    showMainMenu();

                }
                else {
                    validationLabel.setText( "Invalid account number.");
                }

            }
            catch (NumberFormatException exception) {

                validationLabel.setText( "Please enter a valid account number." );
            }
        }
        // OPEN Deposit screen
        else if (event.getSource() == depositButton) {

            hideMainMenu();

            transactionLabel.setText("Deposit amount:");

            transactionLabel.setVisible(true);
            amountField.setVisible(true);
            enterDepositButton.setVisible(true);
            returnButton.setVisible(true);

            balanceLabel.setText(
                String.format( "Current Balance: $%.2f",account.getBalance() ));

            balanceLabel.setVisible(true);
        }

        // PROCESS Deposit

        else if (event.getSource() == enterDepositButton) {

            Number value = (Number) amountField.getValue();

            if (value != null) {

                double amount = value.doubleValue();

                System.out.println(
                    account.deposit(amount)
                );

                balanceLabel.setText(
                    String.format("Current Balance: $%.2f",account.getBalance()));

                amountField.setValue(null);
            }
            else {

                balanceLabel.setText(
                    "Please enter a deposit amount."
                );
            }
        }
        // OPEN WITHDRAW screen
        else if (event.getSource() == withdrawButton) {

            hideMainMenu();

            transactionLabel.setText("Withdrawal amount:");

            transactionLabel.setVisible(true);
            amountField.setVisible(true);
            enterWithdrawButton.setVisible(true);
            returnButton.setVisible(true);

            balanceLabel.setText(
                String.format(
                    "Current Balance: $%.2f",
                    account.getBalance()
                )
            );

            balanceLabel.setVisible(true);
        }
        // PROCESS WITHDRAWAL

        else if (event.getSource() == enterWithdrawButton) {

            Number value = (Number) amountField.getValue();

            if (value != null) {

                double amount = value.doubleValue();

                System.out.println(
                    account.withdrawal(amount)
                );

                balanceLabel.setText(
                    String.format("Current Balance: $%.2f",account.getBalance()));

                amountField.setValue(null);
            }
            else {
                balanceLabel.setText( "Please enter a withdrawal amount.");
            }
        }

        // VIEW BALANCE
        else if (event.getSource() == balanceButton) {

            hideMainMenu();

            balanceLabel.setText(
                String.format( "Current Balance: $%.2f",account.getBalance()));

            balanceLabel.setVisible(true);
            returnButton.setVisible(true);
        }
        // RETURN TO MENU
        else if (event.getSource() == returnButton) {

            transactionLabel.setVisible(false);
            amountField.setVisible(false);

            enterDepositButton.setVisible(false);
            enterWithdrawButton.setVisible(false);

            balanceLabel.setVisible(false);
            returnButton.setVisible(false);

            amountField.setValue(null);

            showMainMenu();
        }
        // EXIT
       
        else if (event.getSource() == exitButton) {
            System.out.printf("Remaining account balance: $%.2f%n", account.getBalance());
            System.exit(0);
        }
    }

    // Hide the four main menu buttons
    private static void hideMainMenu() {

        depositButton.setVisible(false);
        withdrawButton.setVisible(false);
        balanceButton.setVisible(false);
        exitButton.setVisible(false);
    }
    // Display the four main menu buttons
    private static void showMainMenu() {

        depositButton.setVisible(true);
        withdrawButton.setVisible(true);
        balanceButton.setVisible(true);
        exitButton.setVisible(true);
    }
}