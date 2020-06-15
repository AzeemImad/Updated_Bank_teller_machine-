package ATM.FormsAndGui;

import ATM.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Displays a summary of an account that includes current balance, last transaction
 * and date of creation.
 */
public class AccountSummaryScreen extends JFrame{
    private JPanel accountSummaryPanel;
    private JLabel balanceLabel; //displays balance
    private JLabel lastTransLabel; //displays last transaction
    private JLabel dateLabel; //displays date of creation
    private JButton closeButton;

    /**
     * Sets labels to appropriate values and creates button action listeners.
     *
     * @param account Account to summarize.
     */
    AccountSummaryScreen(Account account){
        balanceLabel.setText(String.valueOf(account.getCurrentBalance()));
        lastTransLabel.setText(account.getLastTransaction());
        dateLabel.setText(account.getCreationDate());
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    /**
     * Creates/displays the window.
     * */
    public void createScreen(){
        add(accountSummaryPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Summary");
        setVisible(true);
    }

    /**
     * Initialize UI components for IntelliJ .form file
     * */
    private void createUIComponents() {
        balanceLabel = new JLabel();
        lastTransLabel = new JLabel();
        dateLabel = new JLabel();
    }
}
