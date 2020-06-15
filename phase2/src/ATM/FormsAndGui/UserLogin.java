/*Class that contains Gui elements that are used to display the */
package ATM.FormsAndGui;

import ATM.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogin {
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel userLoginPanel;
    private JButton loginButton;
    private JButton forgotPasswordButton;
    private JButton mainMenuButton;
    private JPasswordField passwordField1;
    private JTextField textField1;

    public JPanel getPanel() {
        return userLoginPanel;
    }

    /**
     * Main Method that houses all the different methods for the buttons and panels
     *
     * @param startScreen Instance of the BankMachineMenu Class. Used to call methods of the BankMachineMenu class.
     * */
    public void build(BankMachineMenu startScreen) {
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (BankMachine.userDirectory.checkPassword(textField1.getText(), String.valueOf(passwordField1.getPassword()))) {
                    User user = BankMachine.userDirectory.getUser(textField1.getText());
                    if (user instanceof BankTeller){
                        new BankTellerMenu(user).createScreen();
                    } else {
                        new UserMenu(user).createScreen();
                    }
                    startScreen.backToStart();
                } else {
                    JOptionPane.showMessageDialog(startScreen, "Incorrect login information");
                }
            }
        });
        forgotPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ForgotPasswordScreen().createScreen();
            }
        });
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startScreen.backToStart();
            }
        });
    }

}
