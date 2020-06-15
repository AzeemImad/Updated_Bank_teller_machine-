/*
This is a Savings Account
*/
package ATM;

public class SavingsAccount extends Account{
    /**
     * Constructor for SavingsAccount
     */
    public SavingsAccount(double balance){
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
        if (this.currentBalance >= withdrawAmount) {
            this.currentBalance -= withdrawAmount;
            this.lastTransaction = -withdrawAmount;
            this.lastTransactionMessage = transactionMessage;
            this.transactions.add(-withdrawAmount);
            return true;
        } else{
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
        this.currentBalance += depositAmount;
        this.lastTransaction = depositAmount;
        this.lastTransactionMessage = transactionMessage;
        this.transactions.add(depositAmount);
    }

    /**
     * Adds interest to the account by 0.1% by the end of every month.
     * */
    public void addInterest(){
        this.currentBalance = Double.valueOf(twoDec.format(this.currentBalance * 1.001));
    }

    @Override
    public void setCreditLimit(int amount) {
    }
}