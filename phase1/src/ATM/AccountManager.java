/*
This is the Account Manager Class, this class instantiates instances of Accounts and holds a dictionary of all a user's
Accounts. The dictionary holding each class will have a format of (Account type[As a string{Credit, LineOfCredit,
Chequing, Saving}]: List of Accounts with their corresponding accounts).
*/
package ATM;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.*;

public class AccountManager implements Serializable {

    /** This is the primary account*/
    ChequingAccount primaryAccount;

    /** this is a dictionary containing all the accounts of the user*/
    private Map<String, Account[]> allAccounts = new HashMap<>(4);

    /** Credit account(s) list*/
    private CreditCardAccount[] credits = new CreditCardAccount[100];

    /** counter for credit card Account*/
    private int creditCounter = 0;

    /**chequing account(s) list*/
    private ChequingAccount[] chequing = new ChequingAccount[100];

    /**chequing account counter variable*/
    private int chequingCounter= 0;

    /**lineOfCredits account(s) list*/
    private LineOfCreditAccount[] lineOfCredits = new LineOfCreditAccount[100];

    /**Line of credit counter variable*/
    private int lineOfCreditCounter= 0;

    /** Saving account(s) list*/
    private SavingsAccount[] saving = new SavingsAccount[100];

    /**Saving account counter*/
    private int savingCounter = 0;

    /** Used for printing out balances to only two decimal places */
    private DecimalFormat twoDec  = new DecimalFormat("#.##");


    /**
     * This is the constructor for AccountManager class
     *
     */
    public AccountManager(){
        allAccounts.put("CreditCard",credits);
        allAccounts.put("LineOfCredit",lineOfCredits);
        allAccounts.put("Chequing",chequing);
        allAccounts.put("Saving",saving);
        createAccount("3", 0);
        primaryAccount = chequing[0];
    }

    /**
     * This method creates an account of the specified type with the specified balance inside it.
     *
     * @param accountType is a string which is used to determine what type of account it is;
     * @param balance is a double that is the original balance inside the account
     */
    public void createAccount(String accountType, double balance){
        // check what is the type of the account being created
        /* update the list each time an account is being created and then put it into the hashtable. Then increase the
        counter do this for each of the following accounts each time an account is created*/
        switch (accountType){
            case "1":
                credits[creditCounter]= new CreditCardAccount(balance);
                allAccounts.replace("CreditCard",credits);
                creditCounter++;
                break;
            case "2":
                lineOfCredits[lineOfCreditCounter] = new LineOfCreditAccount(balance);
                allAccounts.replace("LineOfCredit",lineOfCredits);
                lineOfCreditCounter++;
                break;
            case "3":
                chequing[chequingCounter] = new ChequingAccount(balance);
                allAccounts.replace("Chequing",chequing);
                chequingCounter++;
                break;
            case "4":
                saving[savingCounter] = new SavingsAccount(balance);
                allAccounts.replace("Saving",saving);
                savingCounter++;
                break;
            default:
                System.out.println("ERROR IN CREATE ACCOUNT");
                break;
        }
    }

    /**
     * Method for the transaction menu. Used to select the type of account to make the transfer into.
     *
     * @param transferOut boolean variable to determine if the money is being transferred out.
     * @return getSpecifiedAmount which returns a value of type Account.
     *
     * */
    public Account transactionMenu(boolean transferOut){
        String typeOfAccount = null;
        int accountNum = 0;
        int numAccounts = -1;

        boolean selectionNotMade = true;
        while (selectionNotMade) {
            System.out.println("Select account type:");
            if (!transferOut) {
                System.out.println(" 1. Credit Card");
            }
            System.out.println(" 2. Line Of Credit");
            System.out.println(" 3. Chequing");
            System.out.println(" 4. Savings");
            typeOfAccount = BankMachine.getInput();
            switch (typeOfAccount){
                case "1":
                    if (!transferOut) {
                        numAccounts = creditCounter;
                        break;
                    }
                case "2":
                    numAccounts = lineOfCreditCounter;
                    break;
                case "3":
                    numAccounts = chequingCounter;
                    break;
                case "4":
                    numAccounts = savingCounter;
                    break;
                default:
                    System.out.println("INVALID ENTRY");
                    numAccounts = -1;
                    break;
            }
            if (numAccounts == 0){
                System.out.println("You have no accounts of this type\n");
            } else if (numAccounts != -1){
                selectionNotMade = false;
            }
        }
        boolean accountLoop = true;
        System.out.println("Currently there are " + numAccounts + " of these accounts.");
        while (accountLoop){
            System.out.println("Enter the number of the account you wish to access:");
            String withdrawAccount = BankMachine.getInput();
            if (withdrawAccount.matches("-?\\d+")){
                accountNum = Integer.parseInt(withdrawAccount);
                if (accountNum > 0 && accountNum <= numAccounts){
                    accountLoop = false;
                }else{
                    System.out.println("INVALID ENTRY");
                }
            }
            else{
                System.out.println("INVALID ENTRY");
            }
        }
        return getSpecifiedAccount(typeOfAccount, accountNum);
    }

    /**
     * Prints the summary of balance present in all accounts
     * */
    public void printSummary(){
        for (Map.Entry<String, Account[]> list : allAccounts.entrySet()){
            Account[] accountList = list.getValue();
            for (int i = 0; i < accountList.length; i++){
                if (accountList[i] == null){
                    break;
                }
                System.out.println(list.getKey() + " " + (i+1) + ": " + accountList[i].getCurrentBalance());
            }
        }
    }

    /**
     * Calculates the net balance in all the accounts combined
     *
     * @return total which is a double value
     * */
    public double calculateNet(){
        double total = 0;
        for (Map.Entry<String, Account[]> list : allAccounts.entrySet()){
            Account[] accountList = list.getValue();
            String accountName = list.getKey();
            for (Account account : accountList){
                if (account == null){
                    break;
                }
                if (accountName.equals("CreditCard") || accountName.equals("LineOfCredit")){
                    total -= account.getCurrentBalance();
                } else{
                    total += account.getCurrentBalance();
                }
            }
        }
        return Double.valueOf(twoDec.format(total));
    }

    /**
     * Increases the balance of all savings accounts by the interest rate
     */
    public void interestIncrease(){
        for (SavingsAccount account : saving){
            if (account == null){
                break;
            }
            account.addInterest();
        }
    }

    /**
     * Get the specific Amount object that the bank manager is looking for
     *
     * @param type is the type of account we are looking for
     * @param accountNumber is the actual account that user wants to access
     *
     * @return  specifiedAccount which is a value of type Account
     * */
    public Account getSpecifiedAccount(String type, int accountNumber) {
        /*
         * Here is the table :
         *   - 1 : Credit
         *   - 2 : LineOfCredit
         *   - 3 : Chequing
         *   - 4 : Saving
         * */
        System.out.println("Accessing account...");
        Account specifiedAccount;
        switch (type){
            case "1":
                specifiedAccount = credits[accountNumber-1];
                break;
            case "2":
                specifiedAccount = lineOfCredits[accountNumber-1];
                break;
            case "3":
                specifiedAccount = chequing[accountNumber-1];
                break;
            case "4":
                specifiedAccount = saving[accountNumber-1];
                break;
            default:
                specifiedAccount = null;
                break;
        }
        return specifiedAccount;
    }
}