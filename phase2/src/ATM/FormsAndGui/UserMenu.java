/*Class that contains Gui elements that are used to display theUserMenu GUI */
package ATM.FormsAndGui;

import ATM.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu extends JFrame{
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel userPanel;
    private JLabel userLabel;
    private JButton accountButton;
    private JButton transferButton;
    private JButton changePasswordButton;
    private JButton withdrawDepositButton;
    private JButton mainMenuButton;

    private CardLayout c1;
    private JPanel panelContainer = new JPanel();

    /**
     * Main Method that houses all the different methods for the buttons and panels
     *
     * @param user Instance of the User Class. used to determine which instance of user's menu should be displayed
     * */
    UserMenu(User user){
        userLabel.setText(user.getUsername());

        c1 = new CardLayout();
        panelContainer.setLayout(c1);
        panelContainer.add(userPanel, "UserMenu");
        panelContainer.add(new ManageAccountScreen(this, user).getPanel(),"ManageAccounts");
        panelContainer.add(new TransferMoneyScreen(this, user).getPanel(), "TransferMoney");
        panelContainer.add(new WithdrawDeposit(this, user).getPanel(), "WithdrawDeposit");

        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        accountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c1.show(panelContainer, "ManageAccounts");
            }
        });
        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c1.show(panelContainer,"TransferMoney");
            }
        });
        changePasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChangePassword(user).createScreen();
            }
        });
        withdrawDepositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c1.show(panelContainer,"WithdrawDeposit");
            }
        });
    }

    /**
     * Creates the Actual Frame and screen for the GUI
     * */
    void createScreen(){
        startScreen();
        add(panelContainer);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("User Menu");
        setVisible(true);
    }

    void startScreen(){
        c1.show(panelContainer, "UserMenu");
    }

    private void createUIComponents() {
        userLabel = new JLabel();
    }
}
