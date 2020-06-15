/*Class that contains Gui elements that are used to display the Deposit Screen*/
package ATM.FormsAndGui;

import ATM.FileHandler;
import ATM.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositScreen extends JFrame{
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel depositPanel;
    private JRadioButton cashRadioButton;
    private JRadioButton chequeRadioButton;
    private JButton submitButton;
    private JLabel amountLabel;
    private JButton closeButton;
    private double currentTotal;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     * */
    DepositScreen(User user){
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cashRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getCash();
            }
        });
        chequeRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cheque = FileHandler.readText("TextFiles/deposits.txt");
                if (cheque.matches("^\\d+\\.?\\d?\\d?$")) {
                    currentTotal = Double.parseDouble(cheque);
                    amountLabel.setText(cheque);
                    submitButton.setEnabled(true);
                } else {
                    amountLabel.setText("No Cheque Entered");
                    submitButton.setEnabled(false);
                }

            }
        });
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                user.accountManager.primaryAccount.deposit(currentTotal, "Deposit");
                JOptionPane.showMessageDialog(DepositScreen.this, "Deposit Successful");
                dispose();
            }
        });
    }

    /**
     * Creates the Actual Frame and screen for the GUI
     * */
    void createScreen(){
        getCash();
        cashRadioButton.setSelected(true);
        add(depositPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Desposit");
        setVisible(true);
    }

    /**
     * Method is used to get the cash inside the Atm
     * */
    private void getCash(){
        int[] billAmounts = FileHandler.readCash("TextFiles/deposits.txt");
        int fiftyBills = billAmounts[0];
        int twentyBills = billAmounts[1];
        int tenBills = billAmounts[2];
        int fiveBills = billAmounts[3];
        currentTotal = fiftyBills*50 + twentyBills*20 + tenBills*10 + fiveBills*5;
        if (currentTotal == 0){
            amountLabel.setText("No Cash Entered");
            submitButton.setEnabled(false);
        } else {
            amountLabel.setText(String.valueOf(currentTotal));
            submitButton.setEnabled(true);
        }
    }

    private void createUIComponents() {
        amountLabel = new JLabel();
    }
}
