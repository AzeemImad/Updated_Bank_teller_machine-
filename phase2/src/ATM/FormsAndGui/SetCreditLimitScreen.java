/*Class that contains Gui elements that are used to display the SetCreditLimit GUI */
package ATM.FormsAndGui;

import ATM.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetCreditLimitScreen extends JFrame{
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel creditLimitPanel;
    private JButton setButton;
    private JSpinner spinner1;
    private JButton cancelButton;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     *
     * @param account Instance of Account Class. Used to determine which account is to be used in the GUI
     * */
    SetCreditLimitScreen(Account account){
        setButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer amount = (Integer) spinner1.getValue();
                account.setCreditLimit(amount);
                JOptionPane.showMessageDialog(SetCreditLimitScreen.this, "Credit Limit Set: " + amount);
                dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    /**
     * Creates the Actual Frame and screen for the GUI
     * */
    void createScreen(){
        add(creditLimitPanel);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setTitle("Credit Limit Settings");
        setVisible(true);
    }

    private void createUIComponents() {
        spinner1 = new JSpinner(new SpinnerNumberModel(0,0,1000000,1));
    }
}
