package ATM.FormsAndGui;

import ATM.BankMachine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Displays alerts from the current day and day before.
 */
public class AlertsScreen extends JFrame {
    private JPanel alertsPanel;
    private JScrollPane todayAlerts;
    private JScrollPane yesterdayAlerts;
    private JButton backButton;

    /**
     * Adds action listeners for buttons.
     * */
    AlertsScreen() {
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    /**
     * Creates window and displays the appropriate alerts.
     * */
    public void createScreen() {
        todayAlerts.setViewportView(BankMachine.alerts.getTodayAlerts());
        yesterdayAlerts.setViewportView(BankMachine.alerts.getYesterdayAlerts());
        add(alertsPanel);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Initialize UI components for IntelliJ form file.
     */
    private void createUIComponents() {
        todayAlerts = new JScrollPane();
        yesterdayAlerts = new JScrollPane();
    }

}
