/*
This is an abstract class. This class is the superclass for debt and asset accounts which are extended by
credit card, line of credit, chequing, savings accounts respectively.
*/
package ATM;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;

abstract public class Account implements Serializable {
    double currentBalance;
    double lastTransaction = 0;
    String lastTransactionMessage = "No transaction";
    DecimalFormat twoDec  = new DecimalFormat("#.##");
    private LocalDate creationDate;

    /**
     * Constructor for account class.
     * */
    public Account(double balance){
        this.currentBalance = balance;
        this.creationDate = BankMachine.date;
    }

    public double getCurrentBalance(){
        return Double.valueOf(twoDec.format(this.currentBalance));
    }

    /**
     *  keeps track of transactions and will undo the very latest transaction done
     * */
    public void undoLastTransaction(){
        lastTransactionMessage = "Undid last transaction";
        this.currentBalance -= this.lastTransaction;
        this.lastTransaction = -this.lastTransaction;
    }

    public String printLastTransaction(){
        return lastTransactionMessage + ": " + Double.valueOf(twoDec.format(this.lastTransaction));
    }

    public String getCreationDate(){
        return creationDate.toString();
    }

    abstract public void deposit(double n, String transactionMessage);

    abstract public boolean withdraw(double n, String transactionMessage);
}