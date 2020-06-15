package ATM.FormsAndGui;

import ATM.BankMachine;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates screen for user deletion.
 */
public class DeleteUser extends JFrame{
    private JPanel deleteUserPanel;
    private JTextField usernameField;
    private JButton closeButton;
    private JButton deleteButton;
    private JLabel userExistsLabel;

    /**
     * Creates action listeners
     * */
    DeleteUser() {
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BankMachine.userDirectory.deleteUser(usernameField.getText());
                JOptionPane.showMessageDialog(DeleteUser.this, "User Deletion Successful");
                dispose();
            }
        });
        usernameField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                checkName();
            }
            public void removeUpdate(DocumentEvent e) {
                checkName();
            }
            public void changedUpdate(DocumentEvent e) {
                checkName();
            }
        });
    }

    /**
     * Creates the window.
     * */
    public void createScreen(){
        deleteButton.setEnabled(false);
        add(deleteUserPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Initializes UI components for IntelliJ form file.
     */
    private void createUIComponents() {
        userExistsLabel = new JLabel();
    }

    /**
     * Used to check/validate a given username.
     * */
    private void checkName(){
        deleteButton.setEnabled(false);
        if(usernameField.getText().equals("")){
            userExistsLabel.setText("");
        } else if(BankMachine.userDirectory.userExists(usernameField.getText())){
            userExistsLabel.setText("");
            deleteButton.setEnabled(true);
        } else{
            userExistsLabel.setText("username doesn't exist");
        }
    }
}
