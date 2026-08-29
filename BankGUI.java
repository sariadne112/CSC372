import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.EdDSAParameterSpec;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BankGUI extends BankAccount{
  public static void main(String[] args) {
      
      JFrame topFrame = null;                // Application window
      JLabel accountLabel = null;               // Label for user account
      JTextField accountField = null;            // Displays hourly salary 
      GridBagConstraints layoutConst = null; // GUI component layout
      
      
      //Set Balance Field
      accountLabel = new JLabel("Account:");
  
      accountField = new JTextField(20);
      accountField.setEditable(true);

      // Create frame and add components using GridBagLayout
      topFrame = new JFrame("Bank Account");
      
      // Use a GridBagLayout
      topFrame.setLayout(new GridBagLayout());
      
      topFrame.setSize(500, 350);

      // Create GridBagConstraints
      layoutConst = new GridBagConstraints();
    
      
      // 10 pixels of padding around component
      layoutConst.insets = new Insets(10, 10, 10, 10);
      

      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      topFrame.add(accountLabel, layoutConst);

      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      topFrame.add(accountField, layoutConst);
      // Terminate program when window closes
      topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      // Resize window to fit components
      topFrame.pack();
      
      // Display window
      topFrame.setVisible(true);
   }
}
