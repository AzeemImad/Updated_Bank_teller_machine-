/*
This is a Credit Card Account
*/
package ATM;

public class CreditCardAccount extends Account{
    private int creditLimit = 1000;
    /**
     * Constructor for CreditCardAccount
     */
    public CreditCardAccount(double balance){
        super(balance);
    }


    /**
     * Deposits money from specified account. Also records the last transaction done
     *
     * @param depositAmount which the value the user wants to deposit
     * @param transactionMessage which is the string that records the transaction done
     * */
    @Override
    public void deposit(double depositAmount, String transactionMessage){
        this.currentBalance -= depositAmount;
        this.lastTransaction = -depositAmount;
        this.lastTransactionMessage = transactionMessage;
        this.transactions.add(-depositAmount);

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
    public boolean withdraw(double withdrawAmount, String transactionMessage){
        if (currentBalance + withdrawAmount <= creditLimit){
            this.currentBalance += withdrawAmount;
            this.lastTransaction = withdrawAmount;
            this.lastTransactionMessage = transactionMessage;
            this.transactions.add(withdrawAmount);
            return true;
        } else{
            System.out.println("Exceeds credit limit. Transaction did not go through");
            return true;
        }
    }

    public void setCreditLimit(int amount){
        creditLimit = amount;
    }
}