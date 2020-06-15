/*Class that contains Gui elements that are used to display the ForGotPassword Screen*/
package ATM.FormsAndGui;

import ATM.BankMachine;
import ATM.User;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordScreen extends JFrame{
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel securityPanel;
    private JTextField answerField;
    private JButton submitButton;
    private JButton closeButton;
    private JTextField userField;
    private JLabel questionLabel;
    private User user;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     * */
    ForgotPasswordScreen() {
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (user.validateSecurityA(answerField.getText())){
                    new ChangePassword(BankMachine.userDirectory.getUser(userField.getText())).createScreen();
                    dispose();
                }
            }
        });
        userField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateSecurityQuestion();
            }
            public void removeUpdate(DocumentEvent e) {
                updateSecurityQuestion();
            }
            public void changedUpdate(DocumentEvent e) {
                updateSecurityQuestion();
            }
        });
    }

    /**
     * Method is used to save security question inserted by the user.
     * */
    private void updateSecurityQuestion(){
        if (BankMachine.userDirectory.userExists(userField.getText())){
            user = BankMachine.userDirectory.getUser(userField.getText());
            questionLabel.setText(user.getSecurityQ());
            submitButton.setEnabled(true);
        } else {
            questionLabel.setText("");
            submitButton.setEnabled(false);
        }
    }

    /**
     * Creates the Actual Frame and screen for the GUI
     * */
    void createScreen(){
        submitButton.setEnabled(false);
        questionLabel.setText("");
        add(securityPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Password Recovery");
        setVisible(true);
    }

    private void createUIComponents() {
        questionLabel = new JLabel();
    }
}
