package ATM.FormsAndGui;

import ATM.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UndoTransaction extends JFrame{
    /**
     * All the panels and Buttons of the GUI
     * */
    private JPanel undoPanel;
    private JButton undoButton;
    private JButton closeButton;
    private JButton undoLastTransactionButton;
    private JSpinner spinner1;

    UndoTransaction(Account account){
        spinner1 = new JSpinner(new SpinnerNumberModel(1,1,account.transactions.size(),1));

        undoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer number = (Integer) spinner1.getValue();
                account.undoSpecifiedTransaction(number);
                exit("Last transaction #" + number + " undone");
            }
        });
        undoLastTransactionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                account.undoLastTransaction();
                exit("Last transaction undone");
            }
        });
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    void createScreen(){
        add(undoPanel);
        setSize(600,450);
        setLocationRelativeTo(null);
        setTitle("Undo");
        setVisible(true);
    }

    private void exit(String message){
        JOptionPane.showMessageDialog(this, message);
        dispose();
    }

    private void createUIComponents() {
        spinner1 = new JSpinner();
    }
}
