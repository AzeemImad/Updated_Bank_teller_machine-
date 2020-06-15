/*
This is a Line Of Credit Account
*/
package ATM;

public class LineOfCreditAccount extends Account{
    private int creditLimit = 1000;
    /**
     * Constructor for LineOfCreditAccount
     */
    public LineOfCreditAccount(double balance){
        super(balance);
    }

    /**
     * Withdraws money from specified account. Also records the last transaction done
     *
     * @param withdrawAmount which the value the user wants to withdraw
     * @param transactionMessage which is the string that records the transaction done
     *
     * @return boolean to say if withdraw was successful or not
     * */
    @Override
    public boolean withdraw(double withdrawAmount, String transactionMessage) {
        if (this.currentBalance + withdrawAmount <= creditLimit) {
            this.currentBalance += withdrawAmount;
            this.lastTransaction = withdrawAmount;
            this.lastTransactionMessage = transactionMessage;
            this.transactions.add(withdrawAmount);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Deposits money from specified account. Also records the last transaction done
     *
     * @param depositAmount which the value the user wants to deposit
     * @param transactionMessage which is the string that records the transaction done
     * */
    @Override
    public void deposit(double depositAmount, String transactionMessage) {
        this.currentBalance -= depositAmount;
        this.lastTransaction = -depositAmount;
        this.lastTransactionMessage = transactionMessage;
        this.transactions.add(-depositAmount);
    }

    public void setCreditLimit(int amount){
        creditLimit = amount;
    }
}