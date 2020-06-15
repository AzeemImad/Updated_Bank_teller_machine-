package ATM.FormsAndGui;

import ATM.BankMachine;
import ATM.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates screen to select account types in order to create accounts or alert bank manager to request creation.
 */
public class AccountTypeScreen extends JFrame{
    private JPanel genericAccountPanel;
    private JButton creditButton;
    private JButton lineOfCreditButton;
    private JButton savingsButton;
    private JButton chequingButton;
    private JButton highInterestSavingButton;
    private JButton closeButton;
    private User user;

    /**
     * Creates a action listeners for buttons .
     *
     * @param user1 The user to create an account/request an account for.
     * @param purpose "request" for a request to be made and any other string for account creation.
     *
     * */
    AccountTypeScreen(User user1, String purpose) {
        this.user = user1;
        creditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (purpose.equals("request")){
                    requestAccount(" is requesting a credit card account");
                } else {
                    createAccount("1");
                }
            }
        });
        lineOfCreditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (purpose.equals("request")){
                    requestAccount(" is requesting a line of credit account");
                } else {
                    createAccount("2");
                }
            }
        });
        chequingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (purpose.equals("request")){
                    requestAccount(" is requesting a chequing account");
                } else {
                    createAccount("3");
                }
            }
        });
        savingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (purpose.equals("request")){
                    requestAccount(" is requesting a savings account");
                } else {
                    createAccount("4");
                }
            }
        });
        highInterestSavingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (purpose.equals("request")){
                    requestAccount(" is requesting a high interest account");
                } else {
                    createAccount("5");
                }
            }
        });
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    /**
     * Creates the window for the class.
     * */
    public void createScreen(){
        add(genericAccountPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Manage Users");
        setVisible(true);
    }

    /**
     * Send alerts to the bank manager regarding account creation.
     * */
    private void requestAccount(String message){
        BankMachine.alerts.addAlert(user.getUsername() + message);
        JOptionPane.showMessageDialog(this, "Request sent to bank");
        dispose();
    }

    /**
     * Pop up window to display successful account creation that will also close the window.
     * */
    private void createAccount(String type){
        user.accountManager.createAccount(type, 0);
        JOptionPane.showMessageDialog(this, "Account Creation Successful");
        dispose();
    }
}
