/*Class that contains Gui elements that are used to display the SetDate Screen*/
package ATM.FormsAndGui;

import ATM.Date;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;

public class setDateScreen extends JFrame{
    /**
     * All the panels and Buttons of the GUI
     * */
    private JSpinner yearSpinner;
    private JSpinner daySpinner;
    private JComboBox<Month> monthComboBox;
    private JButton setDateButton;
    private JButton closeButton;
    private JPanel dateSettingsPanel;

    /**
     * Main Method that houses all the different methods for the buttons and panels
     * */
    public setDateScreen() {
        setDateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Date.setDate(LocalDate.of((int) yearSpinner.getValue(), (Month) monthComboBox.getSelectedItem(), (int) daySpinner.getValue()));
                    JOptionPane.showMessageDialog(setDateScreen.this,"Date Changed");
                    dispose();
                } catch (Exception r){
                    JOptionPane.showMessageDialog(setDateScreen.this, "Invalid Date");
                }
            }
        });
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    /**
     * Used to check/ validate a given username
     * */
    public void createScreen(){
        yearSpinner.setValue(Date.getYear());
        monthComboBox.setSelectedItem(Date.getMonth());
        daySpinner.setValue(Date.getDay());
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Settings");
        add(dateSettingsPanel);
        setVisible(true);
    }


    private void createUIComponents() {
        yearSpinner = new JSpinner();
        yearSpinner.setEditor(new JSpinner.NumberEditor(yearSpinner,"#"));
        yearSpinner.setValue(Date.getYear());
        daySpinner = new JSpinner(new SpinnerNumberModel(Date.getDay(),1,31,1));
        monthComboBox = new JComboBox<Month>(Date.monthList());
        monthComboBox.setSelectedItem(Date.getMonth());
    }
}
