/*Class that contains Gui elements that are used to display the SelectUserScreen*/
package ATM.FormsAndGui;

import ATM.BankMachine;
import ATM.User;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectUserScreen extends JFrame{
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel selectUserPanel;
    private JTextField textField1;
    private JButton goButton;
    private JButton backButton;
    private JLabel userExistsLabel;

    private CardLayout c1;
    private JPanel panelContainer = new JPanel();

    /**
     * Main Method that houses all the different methods for the buttons and panels and other items
     * */
    public SelectUserScreen(){
        c1 = new CardLayout();
        panelContainer.setLayout(c1);
        panelContainer.add(selectUserPanel, "Select User");

        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }});
        goButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User user = BankMachine.userDirectory.getUser(textField1.getText());
                panelContainer.add(new ManageUsersScreen(user, SelectUserScreen.this).getPanel(), user.getUsername());
                c1.show(panelContainer, user.getUsername());
            }
        });
        textField1.getDocument().addDocumentListener(new DocumentListener() {
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
     * Creates the Actual Frame and screen for the GUI
     * */
    public void createScreen() {
        goButton.setEnabled(false);
        setSize(600,450);
        setTitle("User Management");
        setLocationRelativeTo(null);
        add(panelContainer);
        setVisible(true);
    }

    /**
     * Gets the user mentioned on the JTextField
     * */
    void selectUser(){
        textField1.setText("");
        c1.show(panelContainer, "Select User");
    }

    /**
     * Validate the username
     * */
    private void checkName(){
        goButton.setEnabled(false);
        if(textField1.getText().equals("")){
            userExistsLabel.setText("");
        } else if(BankMachine.userDirectory.userExists(textField1.getText())){
            userExistsLabel.setText("");
            goButton.setEnabled(true);
        } else{
            userExistsLabel.setText("username doesn't exist");
        }
    }

    private void createUIComponents() {
        userExistsLabel = new JLabel();
    }
}
