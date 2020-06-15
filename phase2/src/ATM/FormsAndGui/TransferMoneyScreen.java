/*Class that contains Gui elements that are used to display the TransferMoneyScreen GUI Screen*/
package ATM.FormsAndGui;

import ATM.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferMoneyScreen {
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel transferPanel;
    private JButton betweenAccountsButton;
    private JButton betweenUsersButton;
    private JButton userMenuButton;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     *
     * @param userScreen instance of UserMenu class, Used to call components of the UserMenu Class.
     * @param user Instance of the User Class. Used to Determine which User to use the screen on.
     * */
    TransferMoneyScreen(UserMenu userScreen, User user) {
        userMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userScreen.startScreen();
            }
        });
        betweenAccountsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TransferWithin(user).createScreen();
            }
        });
        betweenUsersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SelectAccounts(user, "Transfer Out").createScreen();
            }
        });
    }

    JPanel getPanel(){
        return transferPanel;
    }
}
