/*Class that contains Gui elements that are used to display the Joint Accounts Screen */
package ATM.FormsAndGui;

import ATM.Account;
import ATM.BankMachine;
import ATM.User;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JointAccountScreen extends JFrame{
    /**
     * All the panels and Buttons of the GUI. and stuff
     * */
    private JPanel joinPanel;
    private JTextField textField1;
    private JButton joinButton;
    private JButton closeButton;
    private JLabel userExistsLabel;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     *
     * @param account Instance of Account to determine which Account is being used
     * */
    JointAccountScreen(Account account) {
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        textField1.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                checkUserName();
            }
            public void removeUpdate(DocumentEvent e) {
                checkUserName();
            }
            public void changedUpdate(DocumentEvent e) {
                checkUserName();
            }
        });
        joinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User joinUser = BankMachine.userDirectory.getUser(textField1.getText());
                joinUser.accountManager.addAccount(account);
                JOptionPane.showMessageDialog(JointAccountScreen.this, "Join Account Successful");
                dispose();
            }
        });
    }

    /**
     * Creates the Actual Frame and screen for the GUI
     * */
    void createScreen(){
        joinButton.setEnabled(false);
        userExistsLabel.setText("");
        add(joinPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Join Accounts");
        setVisible(true);
    }

    /**
     * Validates username of said user
     * */
    private void checkUserName(){
        joinButton.setEnabled(false);
        if (textField1.getText().equals("")){
            userExistsLabel.setText("");
        } else if (BankMachine.userDirectory.userExists(textField1.getText())){
            userExistsLabel.setText("");
            joinButton.setEnabled(true);
        } else{
            userExistsLabel.setText("user doesn't exist");
        }
    }

    private void createUIComponents() {
        userExistsLabel = new JLabel();
    }
}
