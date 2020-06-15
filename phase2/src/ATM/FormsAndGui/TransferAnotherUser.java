/*Class that contains Gui elements that are used to display the Transfer to another user GUI */
package ATM.FormsAndGui;

import ATM.Account;
import ATM.BankMachine;
import ATM.User;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferAnotherUser extends JFrame{
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel transferOutPanel;
    private JTextField textField1;
    private JSpinner spinner1;
    private JButton submitButton;
    private JButton closeButton;
    private JLabel userExistsLabel;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     * */
    TransferAnotherUser(Account account){
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = (double)spinner1.getValue();
                if (account.withdraw(amount,"Transfer to " + textField1.getText())){
                    User receiver = BankMachine.userDirectory.getUser(textField1.getText());
                    receiver.accountManager.primaryAccount.deposit(amount, "Transfer from other");
                    JOptionPane.showMessageDialog(TransferAnotherUser.this, "Transfer to " + textField1.getText() + " successful");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(TransferAnotherUser.this, "Unable to withdraw this amount from account");
                }
            }
        });
        textField1.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                checkUserName();
            }
            public void removeUpdate(DocumentEvent e) {
                checkUserName();
            }
            public void changedUpdate(DocumentEvent e) {
                checkUserName();
            }
        });
    }

    /**
     * Creates the Actual Frame and screen for the GUI
     * */
    void createScreen(){
        submitButton.setEnabled(false);
        userExistsLabel.setText("");
        add(transferOutPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Transfer Out");
        setVisible(true);
    }

    /**
     * Used to check/ validate a given username
     * */
    private void checkUserName(){
        submitButton.setEnabled(false);
        if (textField1.getText().equals("")){
            userExistsLabel.setText("");
        } else if (BankMachine.userDirectory.userExists(textField1.getText())){
            userExistsLabel.setText("");
            submitButton.setEnabled(true);
        } else {
            userExistsLabel.setText("user doesn't exist");
        }
    }

    private void createUIComponents() {
        spinner1 = new JSpinner(new SpinnerNumberModel(0,0,1000000,0.1));
        userExistsLabel = new JLabel();
    }
}
