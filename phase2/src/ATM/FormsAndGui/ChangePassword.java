package ATM.FormsAndGui;

import ATM.BankMachine;
import ATM.User;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates screen to change password.
 */
public class ChangePassword extends JFrame{
    private JPanel changePasswordPanel;
    private JTextField passwordField;
    private JButton submitButton;
    private JButton closeButton;

    /**
     * Creates action listeners for buttons
     *
     * @param user User for which to change password
     * */
    ChangePassword(User user){
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BankMachine.userDirectory.changePassword(user.getUsername(),passwordField.getText());
                JOptionPane.showMessageDialog(ChangePassword.this,"Password Changed");
                dispose();
            }
        });
        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                validatePassword();
            }
            public void removeUpdate(DocumentEvent e) {
                validatePassword();
            }
            public void changedUpdate(DocumentEvent e) {
                validatePassword();
            }
        });
    }

    /**
     * Method to validate Password given
     * */
    private void validatePassword(){
        if (passwordField.getText().equals("")){
            submitButton.setEnabled(false);
        } else {
            submitButton.setEnabled(true);
        }
    }

    /**
     * Creates the window.
     * */
    void createScreen(){
        add(changePasswordPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Password Settings");
        setVisible(true);
    }
}
