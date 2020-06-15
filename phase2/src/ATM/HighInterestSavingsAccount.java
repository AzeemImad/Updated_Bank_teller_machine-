/*
* Account is made so that anyone with an interest of over $2500 will automatically have their interest rate spiked by
* 25%.
* */

package ATM;

/**
 * A High Interest Savings Account is an account that pays higher than normal Interest Rates
 */
public class HighInterestSavingsAccount extends Account{
    /**
     * Constructor for HighInterestSavingsAccount
     */
    public HighInterestSavingsAccount(double balance){
        super(balance);
    }

    /**
     * Withdraws money from specified account. Also records the last transaction done. High Interest Savings Account
     * also includes a transaction fee of $5 per transaction
     *
     * @param withdrawAmount which the value the user wants to withdraw
     * @param transactionMessage which is the string that records the transaction done
     *
     * @return boolean to say if withdraw was successful or not
     * */
    public boolean withdraw(double withdrawAmount, String transactionMessage) {
        int transaction_fee = 5;

        if (this.currentBalance >= (withdrawAmount + transaction_fee)) {
            this.currentBalance -= (withdrawAmount + transaction_fee);
            this.lastTransaction = -(withdrawAmount + transaction_fee);
            this.lastTransactionMessage = transactionMessage;
            this.transactions.add(-withdrawAmount + transaction_fee);
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
     *  Method Adds interest. If interest is $2500, client will have reached high interest rates.
     *  . Otherwise, gives regular interest rate.
     */
    void addInterest(){
        if (this.currentBalance > 2500) {
            this.currentBalance = Double.valueOf(twoDec.format(this.currentBalance * 1.0025));
        }else{
            this.currentBalance = Double.valueOf(twoDec.format(this.currentBalance * 1.001));
        }
    }

    @Override
    public void setCreditLimit(int amount) {
    }
}
