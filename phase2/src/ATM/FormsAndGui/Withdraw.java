/*Class that contains Gui elements that are used to display the Withdraw GUI */
package ATM.FormsAndGui;

import ATM.Account;
import ATM.HandlingCash;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withdraw extends JFrame{
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel cashWithdrawPanel;
    private JButton submitButton;
    private JButton closeButton;
    private JSpinner spinner1;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     *
     * @param account Instance of Account Class. Used to determine which account is to be used in the GUI
     * */
    public Withdraw(Account account) {
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = (int) spinner1.getValue();
                if (account.withdraw(amount,"Cash Withdrawal")){
                    if (HandlingCash.transaction(amount)) {
                        exit("Withdrawal Successful");
                    } else {
                        account.undoLastTransaction();
                        exit("Invalid Amount/Insufficient Cash in Machine");
                    }
                } else {
                    exit("Unable to withdraw from account");
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
     * Creates the Actual Frame and screen for the GUI
     * */
    void createScreen(){
        submitButton.setEnabled(true);
        add(cashWithdrawPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Cash");
        setVisible(true);
    }

   /**
    * Used to Exit Program and completely close GUI
    * */
    private void exit(String message){
        JOptionPane.showMessageDialog(this, message);
        dispose();
    }

    private void createUIComponents() {
        spinner1 = new JSpinner(new SpinnerNumberModel(0,0,200,5));
    }
}
