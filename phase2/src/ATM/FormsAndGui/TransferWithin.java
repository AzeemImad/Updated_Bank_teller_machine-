/*Class that contains Gui elements that are used to display the TransferWithin Class*/
package ATM.FormsAndGui;

import ATM.User;
import ATM.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferWithin extends JFrame{
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel transferWithinPanel;
    private JScrollPane scrollPane2;
    private JScrollPane scrollPane1;
    private JSpinner spinner1;
    private JButton transferButton;
    private JButton cancelButton;
    private JList<String> accountList1;
    private JList<String> accountList2;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     * */
    TransferWithin(User user){
        accountList1 = new JList<>(user.accountManager.getAccounts(1).toArray(new String[0]));
        accountList2 = new JList<>(user.accountManager.getAccounts(0).toArray(new String[0]));
        accountList1.setSelectionMode(0);
        accountList1.setLayoutOrientation(0);
        scrollPane1.setViewportView(accountList1);
        accountList2.setSelectionMode(0);
        accountList2.setLayoutOrientation(0);
        scrollPane2.setViewportView(accountList2);

        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((double)spinner1.getValue() != 0){
                    Account account1 = getAccount(accountList1, user);
                    Account account2 = getAccount(accountList2, user);
                    doTransfer(account1, account2);
                } else {
                    JOptionPane.showMessageDialog(TransferWithin.this, "Amount not selected");
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    /**
     * Creates the Actual Frame and screen for the GUI
     * */
    void createScreen(){
        add(transferWithinPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Transfer Within");
        setVisible(true);
    }

    /**
     * gets the account the cpmmand is looking for
     *
     * @param user instance of user Class used to determine which user the account is to be taken from
     * @param accountList JList in string which contains all accounts of particular type owned by user
     *
     * @return Account class object
     * */
    private Account getAccount(JList<String> accountList, User user){
        String[] accountName = accountList.getSelectedValue().split(" ");
        return user.accountManager.getSpecifiedAccount(accountName[0], Integer.valueOf(accountName[1]));
    }

    /**
     * Method handles the actual transaction of money behind accounts
     *
     * @param account1 instance of Account class. Money is taken FROM this account
     * @param account2  instance of Account class. Money is GIVEN to this account
     * */
    private void doTransfer(Account account1, Account account2) {
        double amount = (double) spinner1.getValue();
        if (account1.withdraw(amount, "Internal Transfer")) {
            account2.deposit(amount, "Internal Transfer");
            JOptionPane.showMessageDialog(this, "Transfer Successful");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Unable to withdraw from this account");
        }
    }

    private void createUIComponents() {
        spinner1 = new JSpinner(new SpinnerNumberModel(0,0,1000000,0.1));
        scrollPane1 = new JScrollPane();
        scrollPane2 = new JScrollPane();
    }
}
