/*Class that contains Gui elements that are used to display the SelectAccounts GUI */
package ATM.FormsAndGui;

import ATM.Account;
import ATM.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectAccounts extends JFrame{
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel selectAccountPanel;
    private JScrollPane selectScrollPane;
    private JButton closeButton;
    private JButton selectButton;
    private JLabel netTotal;
    private JLabel netTotalOfAccountsLabel;
    private User user;
    private String selection;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     *
     * @param user1  Instance of User Class. Used to determine which user is to be used in the GUI
     * @param selection is the string representation of the account chosen by user
     * */
    SelectAccounts(User user1, String selection){
        this.selection = selection;
        this.user = user1;
        JList<String> accountList;
        if (selection.equals("Transfer Out")){
            accountList = new JList<>(user.accountManager.getAccounts(1).toArray(new String[0]));
        } else if (selection.equals("Set Limit")) {
            accountList = new JList<>(user.accountManager.getAccounts(2).toArray(new String[0]));
        } else {
            accountList = new JList<>(user.accountManager.getAccounts(0).toArray(new String[0]));
        }

        accountList.setSelectionMode(0);
        accountList.setLayoutOrientation(0);
        selectScrollPane.setViewportView(accountList);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] getAccount = accountList.getSelectedValue().split(" ");
                Account account = user.accountManager.getSpecifiedAccount(getAccount[0], Integer.valueOf(getAccount[1]));
                nextScreen(account);
            }
        });
    }


    /**
     * Method switched to next screen
     * */
    private void nextScreen(Account account){
        switch (selection){
            case "View": new AccountSummaryScreen(account).createScreen(); break;
            case "Withdraw": new Withdraw(account).createScreen(); dispose(); break;
            case "Pay": new PayBillScreen(account).createScreen(); dispose(); break;
            case "Set Limit": new SetCreditLimitScreen(account).createScreen(); dispose(); break;
            case "Transfer Out": new TransferAnotherUser(account).createScreen(); dispose(); break;
            case "Join": new JointAccountScreen(account).createScreen(); dispose(); break;
            case "Undo": new UndoTransaction(account).createScreen(); dispose(); break;
            default: dispose(); break;
        }
    }

    /**
     * Creates the Actual Frame and screen for the GUI
     * */
    void createScreen(){
        selectButton.setText(selection);
        if (selection.equals("View")){
            netTotalOfAccountsLabel.setText("Net Total of Accounts:");
            netTotal.setText(String.valueOf(user.accountManager.calculateNet()));
        } else {
            netTotalOfAccountsLabel.setText("");
            netTotal.setText("");
        }
        add(selectAccountPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Account Selection");
        setVisible(true);
    }
    private void createUIComponents() {
        selectScrollPane = new JScrollPane();
        netTotalOfAccountsLabel = new JLabel();
        netTotal = new JLabel();
    }
}
