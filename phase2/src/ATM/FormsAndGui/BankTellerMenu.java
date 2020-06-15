package ATM.FormsAndGui;

import ATM.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Displays menu for bank tellers after they log in.
 */
public class BankTellerMenu extends JFrame{

    private JPanel bankTellerPanel;
    private JButton closeButton;
    private JButton userButton;
    private JButton adminButton;

    /**
     * Creates action listeners for buttons.
     * @param user The instance of bank teller.
     */
    BankTellerMenu(User user){
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        userButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new UserMenu(user).createScreen();
                dispose();
            }
        });

        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdministrativeMenu().createScreen();
                dispose();
            }
        });
    }

    /**
     * Creates the window.
     * */
    void createScreen(){
        add(bankTellerPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Teller");
        setVisible(true);
    }
}
