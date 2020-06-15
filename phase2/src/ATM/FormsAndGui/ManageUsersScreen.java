/*Class that contains Gui elements that are used to display the ManageUsersScreen*/
package ATM.FormsAndGui;

import ATM.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageUsersScreen {
    private JPanel manageUsersPanel;
    private JButton createAccountButton;
    private JButton undoTransactionButton;
    private JButton setCreditLimitButton;
    private JButton backButton;
    private JLabel userLabel;
    private JButton selectUserButton;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     *
     * @param user Instance of class User. Used to determine the correct User
     * @param window instance of SelectUserScreen class. Used to call components from UserScreen.
     * */
    ManageUsersScreen(User user, SelectUserScreen window){
        userLabel.setText("Manage " + user.getUsername());

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        });
        selectUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.selectUser();
            }
        });
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AccountTypeScreen(user, "create").createScreen();
            }
        });
        setCreditLimitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SelectAccounts(user,"Set Limit").createScreen();
            }
        });
        undoTransactionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SelectAccounts(user, "Undo").createScreen();
            }
        });
    }

    JPanel getPanel(){
        return manageUsersPanel;
    }

    private void createUIComponents() {
        userLabel = new JLabel();
    }
}
