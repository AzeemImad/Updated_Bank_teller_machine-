/*
This class represents a Bank Manager. A Bank Manager creates new Users with their initial login and password for that
User. A bank manager can also access HandlingCash.java to set the amount of bills in the bank machine. They can also
undo the most recent transaction of a specific account except for paying bills.
*/
package ATM.FormsAndGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates bank manager screen
 */
public class BankManager {
    private JPanel BankManagerPanel;
    private JButton checkAlertsButton;
    private JButton manageUsersButton;
    private JButton setDateButton;
    private JButton mainMenuButton;
    private JButton restockCashButton;
    private JButton createUserButton;
    private JButton deleteUserButton;

    /**
     * Gets the JPanel for the screen.
     * @return The bank manager JPanel.
     */
    JPanel getPanel() {
        return BankManagerPanel;
    }

    /**
     * Creates the action listeners.
     * @param mainMenu The BankMachineMenu frame displaying the bank manager screen.
     */
    void build(BankMachineMenu mainMenu) {
        checkAlertsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AlertsScreen().createScreen();
            }
        });
        restockCashButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RestockCash().createScreen();
            }
        });
        setDateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new setDateScreen().createScreen();
            }
        });
        createUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new NewUser().createScreen();
            }
        });
        deleteUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DeleteUser().createScreen();
            }
        });
        manageUsersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SelectUserScreen().createScreen();
            }
        });
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu.backToStart();
            }
        });
    }
}