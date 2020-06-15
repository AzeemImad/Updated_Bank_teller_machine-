/*Class that contains Gui elements that are used to display the ManageAccountScreen*/
package ATM.FormsAndGui;

import ATM.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageAccountScreen {
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel manageAccountsPanel;
    private JButton createAccountButton;
    private JButton balanceViewButton;
    private JButton joinAccountButton;
    private JButton userMenuButton;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     *
     * @param user Instance of class User. Used to determine the correct User
     * @param userScreen instance of UserMenu class. Used to call components from UserMenu.
     * */
    ManageAccountScreen(UserMenu userScreen, User user){
        userMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userScreen.startScreen();
            }
        });
        joinAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SelectAccounts(user, "Join").createScreen();
            }
        });
        balanceViewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SelectAccounts(user, "View").createScreen();
            }
        });
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AccountTypeScreen(user, "request").createScreen();
            }
        });
    }

    JPanel getPanel(){
        return manageAccountsPanel;
    }
}
