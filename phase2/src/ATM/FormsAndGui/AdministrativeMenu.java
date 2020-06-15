package ATM.FormsAndGui;

import ATM.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates the administrative menu for Bank Tellers.
 */
public class AdministrativeMenu extends JFrame{
    private JPanel AdminPanel;
    private JButton deleteUserButton;
    private JButton createUserButton;
    private JButton mainMenuButton;
    private JButton manageUsersButton;

    /**
     * Creates action listeners for buttons.
     * */
    AdministrativeMenu(){
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { dispose(); }
        });
        createUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { new NewUser().createScreen(); }
        });
        deleteUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { new DeleteUser().createScreen(); }
        });
        manageUsersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { new SelectUserScreen().createScreen(); }
        });
    }

    /**
     * Creates the Actual Frame and screen for the GUI
     * */
    void createScreen(){
        add(AdminPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Admin Menu");
        setVisible(true);
    }
}
