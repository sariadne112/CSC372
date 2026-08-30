import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.EdDSAParameterSpec;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Color;

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
      JFrame topFrame = null;                // Application window
      GridBagConstraints layoutConst = null; // GUI component layout
      account = new BankAccount();  
      
      // Create frame and add components using GridBagLayout
      topFrame = new JFrame("Bank Account");
      
      // Use a GridBagLayout
      topFrame.setLayout(new GridBagLayout());

      //Set Balance Field
      accountLabel = new JLabel("Account:");
      accountLabel.setVisible(true);
      accountField = new JTextField(20);
      accountField.setEditable(true);
      balanceLabel = new JLabel("");
      balanceLabel.setVisible(false);

      
      //create Enter Button
      signInButton = new JButton("Sign In");

      //Create Option Buttons
      depositButton = new JButton("Deposit");
      withdrawButton = new JButton("Withdraw");
      balanceButton = new JButton("View Balance");
      exitButton = new JButton("Exit");
      // Create GridBagConstraints
      layoutConst = new GridBagConstraints();
    
      // 10 pixels of padding around component
      layoutConst.insets = new Insets(10, 10, 10, 10);
       // Account label
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      topFrame.add(accountLabel, layoutConst);
       // Account text field
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      topFrame.add(accountField, layoutConst);
    // Validation message
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.gridwidth = 2;
        topFrame.add(validationLabel, layoutConst);
        layoutConst.gridwidth = 1;
      layoutConst.gridx = 0;
      layoutConst.gridy = 2;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      topFrame.add(signInButton, layoutConst);

      //buttons lay out
      layoutConst.gridx = 0;
      layoutConst.gridy = 3;
      topFrame.add(depositButton, layoutConst);

      layoutConst.gridx = 1;
      layoutConst.gridy = 3;
      topFrame.add(withdrawButton, layoutConst);

      layoutConst.gridx = 0;
      layoutConst.gridy = 4;
      topFrame.add(balanceButton, layoutConst);

      layoutConst.gridx = 0;
      layoutConst.gridy = 6;
      topFrame.add(exitButton, layoutConst);

      layoutConst.gridx = 0;
      layoutConst.gridy = 7;
      layoutConst.gridwidth = 2;
      topFrame.add(balanceLabel, layoutConst);
      layoutConst.gridwidth = 1;
      balanceLabel.setVisible(false);
      //returnButton
      returnButton = new JButton("Return");
      returnButton = new JButton("Return");
      returnButton.setVisible(false);

      layoutConst.gridx = 1;
      layoutConst.gridy = 6;
      topFrame.add(returnButton, layoutConst);

      depositButton.setVisible(false);
      withdrawButton.setVisible(false);
      balanceButton.setVisible(false);
      exitButton.setVisible(false);

      //action listener buttons
      BankGUI listener = new BankGUI();

      signInButton.addActionListener(listener);
      depositButton.addActionListener(listener);
      withdrawButton.addActionListener(listener);
      balanceButton.addActionListener(listener);
      exitButton.addActionListener(listener);
      returnButton.addActionListener(listener);
      enterDepositButton.addActionListener(listener);
      
      //button size
      Dimension buttonSize = new Dimension(110, 35);
        depositButton.setPreferredSize(buttonSize);
        withdrawButton.setPreferredSize(buttonSize);
        balanceButton.setPreferredSize(buttonSize);
        enterDepositButton.setPreferredSize(buttonSize);
      Dimension smallButtonSize = new Dimension(85, 25);
        exitButton.setPreferredSize(smallButtonSize);
        signInButton.setPreferredSize(smallButtonSize);
        returnButton.setPreferredSize(smallButtonSize);

        //buttons colors
        Color customBlue = new Color(203, 238, 243);
        signInButton.setBackground(customBlue);
        exitButton.setBackground(customBlue);
        balanceButton.setBackground(customBlue);
        returnButton.setBackground(customBlue);
        enterDepositButton.setBackground(customBlue);
        Color bankPink = new Color(244, 156, 187);
        depositButton.setBackground(bankPink);
        withdrawButton.setBackground(bankPink);
        balanceButton.setBackground(bankPink);
        
      //validation label
      validationLabel = new JLabel("");

      depositLabel = new JLabel("Deposit amount: $");

      amountField = new JFormattedTextField(NumberFormat.getCurrencyInstance());
        amountField.setColumns(10);
        amountField.setEditable(true);

        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        topFrame.add(depositLabel, layoutConst);

        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        topFrame.add(amountField, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 6;
        topFrame.add(enterDepositButton, layoutConst);

        depositLabel.setVisible(false);
        amountField.setVisible(false);
        enterDepositButton.setVisible(false);
      
      //account value
      accountField.setText(String.valueOf(account.getAccountID()));
       
       // Terminate program when window closes
      topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Resize window to fit components
      topFrame.pack();
      topFrame.setSize(500, 500);
      // Display window
      topFrame.setVisible(true);
   }

    public void actionPerformed(ActionEvent event) {
    if (event.getSource() == signInButton) {
        int accountID = Integer.parseInt(accountField.getText());

        if (accountID == 42671) {
            // Hide sign-in section
            accountField.setVisible(false);
            accountLabel.setVisible(false);
            signInButton.setVisible(false);

            account.setAccountID(accountID);
            validationLabel.setText("Account Signed In.");

            depositButton.setVisible(true);
            withdrawButton.setVisible(true);
            balanceButton.setVisible(true);
            exitButton.setVisible(true);
            returnButton.setVisible(true);

        }
        else {
            validationLabel.setText("Invalid account number.");
        }
    }

    else if (event.getSource() == depositButton) {
        // Show only deposit screen
        depositButton.setVisible(false);
        withdrawButton.setVisible(false);
        balanceButton.setVisible(false);
        exitButton.setVisible(false);

        depositLabel.setVisible(true);
        amountField.setVisible(true);
        enterDepositButton.setVisible(true);
        returnButton.setVisible(true);
        balanceLabel.setVisible(true);
    }

    else if (event.getSource() == enterDepositButton) {
    Number value = (Number) amountField.getValue();

    if (value != null) {
        double amount = value.doubleValue();

        account.deposit(amount);

        balanceLabel.setText(
            String.format("Current Balance: $%.2f",account.getBalance()));
        balanceLabel.setVisible(true);
    }
}

    else if (event.getSource() == withdrawButton) {

        // Show only withdrawal screen

    }

    else if (event.getSource() == balanceButton) {

        // Show only balance screen

    }

    else if (event.getSource() == exitButton) {

        // Exit/log out

    }
}
}
