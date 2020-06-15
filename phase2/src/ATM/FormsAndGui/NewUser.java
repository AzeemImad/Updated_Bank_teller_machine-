/*Class that contains Gui elements that are used to display the NewUser Screen */
package ATM.FormsAndGui;

import ATM.BankMachine;
import ATM.User;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class NewUser extends JFrame{
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel newUserPanel;
    private JTextField userNameField;
    private JTextField passwordField;
    private JTextField questionField;
    private JTextField answerField;
    private JButton submitButton;
    private JButton closeButton;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private JLabel validNameLabel;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     * */
    public NewUser() {
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isEmployee = yesRadioButton.isSelected();
                User newUser = BankMachine.userDirectory.addUser(userNameField.getText(),passwordField.getText(), isEmployee);
                newUser.setSecurity(questionField.getText(), answerField.getText());
                JOptionPane.showMessageDialog(NewUser.this, "User Creation Successful");
                dispose();
            }
        });
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        noRadioButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkValid();
            }
        });
        userNameField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                checkValid();
            }
            public void removeUpdate(DocumentEvent e) {
                checkValid();
            }
            public void changedUpdate(DocumentEvent e) {
                checkValid();
            }
        });
        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                checkValid();
            }
            public void removeUpdate(DocumentEvent e) {
                checkValid();
            }
            public void changedUpdate(DocumentEvent e) {
                checkValid();
            }
        });
        questionField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                checkValid();
            }
            public void removeUpdate(DocumentEvent e) {
                checkValid();
            }
            public void changedUpdate(DocumentEvent e) {
                checkValid();
            }
        });
        answerField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                checkValid();
            }
            public void removeUpdate(DocumentEvent e) {
                checkValid();
            }
            public void changedUpdate(DocumentEvent e) {
                checkValid();
            }
        });
    }

    /**
     * Creates the Actual Frame and screen for the GUI
     * */
    public void createScreen(){
        submitButton.setEnabled(false);
        noRadioButton.setSelected(true);
        add(newUserPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Creation");
        setVisible(true);
    }

    /**
     * Validates Password entered by user
     * */
    private void checkValid(){
        if (checkName() && !passwordField.getText().equals("") && !questionField.getText().equals("") && !answerField.getText().equals("")){
            submitButton.setEnabled(true);
        } else {
            submitButton.setEnabled(false);
        }
    }

    /**
     * Checks/Validates the username set by the user
     * */
    private boolean checkName(){
        if (userNameField.getText().equals("")){
            validNameLabel.setText("");
        } else if(!BankMachine.userDirectory.userExists(userNameField.getText())) {
            validNameLabel.setText("");
            return true;
        } else {
            validNameLabel.setText("username already exists");
        }
        return false;
    }

    private void createUIComponents() {
        validNameLabel = new JLabel();
    }
}
