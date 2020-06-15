package ATM.FormsAndGui;

import ATM.BankMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates and displays start screen, bank manager menu, and user login screen.
 */
public class BankMachineMenu extends JFrame {
    private BankManager bankManager;
    private UserLogin loginScreen;
    private JPanel bankMachinePanel;
    private JButton bankManagerButton;
    private JButton customerButton;
    private JButton exitButton;

    //Layout and JPanel to display multiple panels in a single frame.
    private CardLayout c1;
    private JPanel panelContainer = new JPanel();

    /**
     * Creates panels for bank manager menu and user login.
     *
     * @param manager Any instance of bank manager
     * @param login Any instance of user login
     * */
    public BankMachineMenu(BankManager manager, UserLogin login) {
        bankManager = manager;
        bankManager.build(this);
        loginScreen = login;
        loginScreen.build(this);
    }

   /**
    * Creates action listeners for buttons and displays start screen.
    * */
    public void build() {
        setTitle("ATM");
        setSize(700, 550);
        setLocationRelativeTo(null);

        c1 = new CardLayout();
        panelContainer.setLayout(c1);
        panelContainer.add(bankMachinePanel, "Start");
        panelContainer.add(bankManager.getPanel(), "Bank Manager");
        panelContainer.add(loginScreen.getPanel(), "Login Screen");
        backToStart();

        add(panelContainer);

        bankManagerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c1.show(panelContainer, "Bank Manager");
            }
        });
        customerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                c1.show(panelContainer, "Login Screen");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BankMachine.closingProgram();
            }
        });
    }

    /**
     * Displays start screen.
     */
    void backToStart() {
        c1.show(panelContainer, "Start");
    }

}
