/*Class that contains Gui elements that are used to display the WithdrawDeposit GUI*/
package ATM.FormsAndGui;

import ATM.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawDeposit {
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel withdrawDepositPanel;
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton payBillButton;
    private JButton backToUserMenuButton;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     * @param userScreen Used to call UserScreen components\
     * @param user Used to determine which user is being used in GUI
     * */
    WithdrawDeposit(UserMenu userScreen, User user){
        backToUserMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userScreen.startScreen();
            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SelectAccounts(user, "Withdraw").createScreen();
            }
        });
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DepositScreen(user).createScreen();
            }
        });
        payBillButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SelectAccounts(user,"Pay").createScreen();
            }
        });
    }

    JPanel getPanel(){
        return withdrawDepositPanel;
    }
}
