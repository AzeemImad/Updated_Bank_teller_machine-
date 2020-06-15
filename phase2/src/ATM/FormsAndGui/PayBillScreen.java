/*Class that contains Gui elements that are used to display the Pay a Bill GUI*/
package ATM.FormsAndGui;

import ATM.Account;
import ATM.FileHandler;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayBillScreen extends JFrame{
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel payBillPanel;
    private JSpinner spinner1;
    private JTextField recipientField;
    private JButton submitButton;
    private JButton closeButton;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     *
     * @param account Instance of Account Class. Used to determine which account is to be used in the GUI
     * */
    PayBillScreen(Account account){
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = (double) spinner1.getValue();
                if (amount == 0){
                    JOptionPane.showMessageDialog(PayBillScreen.this, "Invalid Amount");
                } else {
                    if (account.withdraw(amount, "Paid Bill")){
                        FileHandler.writeText("TextFiles/outgoing.txt",recipientField.getText() + " - $" + amount);
                        exit("Bill Paid");
                    } else{
                        exit("Unable to withdraw from this account");
                    }
                }
            }
        });
        recipientField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                checkRecipient();
            }
            public void removeUpdate(DocumentEvent e) {
                checkRecipient();
            }
            public void changedUpdate(DocumentEvent e) {
                checkRecipient();
            }
        });
    }

    /**
     * Creates the Actual Frame and screen for the GUI
     * */
    void createScreen(){
        submitButton.setEnabled(false);
        add(payBillPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Pay");
        setVisible(true);
    }

    /**
     * Turns the recipient button on or off depending on weather input was inputted into the JTextField
     * */
    private void checkRecipient(){
        if (recipientField.getText().equals("")){
            submitButton.setEnabled(false);
        } else {
            submitButton.setEnabled(true);
        }
    }

    private void exit(String message){
        JOptionPane.showMessageDialog(this, message);
        dispose();
    }

    private void createUIComponents() {
        spinner1 = new JSpinner(new SpinnerNumberModel(0,0,100,0.1));
    }
}
