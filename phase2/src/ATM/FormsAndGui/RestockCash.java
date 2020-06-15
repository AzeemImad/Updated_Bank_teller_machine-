/*Class that contains Gui elements that are used to display the RestockCash GUI*/
package ATM.FormsAndGui;

import ATM.HandlingCash;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestockCash extends JFrame{
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel restockPanel;
    private JButton backButton;
    private JButton restockButton;
    private JSpinner fiveSpinner;
    private JSpinner tenSpinner;
    private JSpinner twentySpinner;
    private JSpinner fiftySpinner;
    private JLabel currentFiveBills;
    private JLabel currentTenBills;
    private JLabel currentTwentyBills;
    private JLabel currentFiftyBills;
    private JButton resetButton;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     * */
    public RestockCash() {
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetSpinners();
            }
        });
        restockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    HandlingCash.addFivers((Integer)fiveSpinner.getValue());
                    HandlingCash.addTenners((Integer)tenSpinner.getValue());
                    HandlingCash.addTwenties((Integer)twentySpinner.getValue());
                    HandlingCash.addFifties((Integer)fiftySpinner.getValue());
                    refreshBillAmount();
                    resetSpinners();
            }
        });
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    /**
     * Creates the Actual Frame and screen for the GUI
     * */
    public void createScreen(){
        refreshBillAmount();
        add(restockPanel);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setTitle("Restock");
        setVisible(true);
    }

    private void createUIComponents() {
        fiveSpinner = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        tenSpinner = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        twentySpinner = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        fiftySpinner = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        currentFiveBills = new JLabel();
        currentTenBills = new JLabel();
        currentTwentyBills = new JLabel();
        currentFiftyBills = new JLabel();
    }

    /**
     * Updates the value of the bills displayed on the console
     * */
    private void refreshBillAmount(){
        currentFiveBills.setText(String.valueOf(HandlingCash.getFives()));
        currentTenBills.setText(String.valueOf(HandlingCash.getTens()));
        currentTwentyBills.setText(String.valueOf(HandlingCash.getTwenties()));
        currentFiftyBills.setText(String.valueOf(HandlingCash.getFifties()));
    }

    /**
     * Resets the value of the bills displayed on the console
     * */
    private void resetSpinners(){
        fiveSpinner.setValue(0);
        tenSpinner.setValue(0);
        twentySpinner.setValue(0);
        fiftySpinner.setValue(0);
    }
}
