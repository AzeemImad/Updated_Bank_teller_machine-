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
    public ChequingAccount primaryAccount;

    /** this is a dictionary containing all the accounts of the user*/
    private Map<String, Account[]> allAccounts = new HashMap<>(5);

    /** Credit account(s) list*/
    public CreditCardAccount[] credits = new CreditCardAccount[100];

    /** counter for credit card Account*/
    private int creditCounter = 0;

    /**chequing account(s) list*/
    private ChequingAccount[] chequing = new ChequingAccount[100];

    /**chequing account counter variable*/
    private int chequingCounter= 0;

    /**lineOfCredits account(s) list*/
    public LineOfCreditAccount[] lineOfCredits = new LineOfCreditAccount[100];

    /**Line of credit counter variable*/
    private int lineOfCreditCounter= 0;

    /** Saving account(s) list*/
    private SavingsAccount[] saving = new SavingsAccount[100];

    /**Saving account counter*/
    private int savingCounter = 0;

    /** High Interest Savings account(s) list*/
    private HighInterestSavingsAccount[] HIS = new HighInterestSavingsAccount[100];

    /**High Interest Savings counter*/
    private int HISCounter = 0;

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
        allAccounts.put("HighInterestSavings",HIS);
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
            case "5":
                HIS[HISCounter] = new HighInterestSavingsAccount(balance);
                allAccounts.replace("HIS",HIS);
                HISCounter++;
                break;
            default:
                System.out.println("ERROR IN CREATE ACCOUNT");
                break;
        }
    }

    /**
     * adds an account to User's corresponding Account list
     * Helper method for joinAccount() in User
     * @param a Account Object passed in from User
     */
    public void addAccount(Account a){
        // check type of object and execute commands regarding type
         if (a instanceof CreditCardAccount){
             credits[creditCounter] = (CreditCardAccount)a;
             creditCounter++;
         } else if (a instanceof LineOfCreditAccount){
             lineOfCredits[lineOfCreditCounter] = (LineOfCreditAccount)a;
             lineOfCreditCounter++;
         } else if (a instanceof ChequingAccount){
             chequing[chequingCounter] = (ChequingAccount)a;
             chequingCounter++;
         } else if (a instanceof SavingsAccount) {
             saving[savingCounter] = (SavingsAccount)a;
             savingCounter++;
         } else if (a instanceof HighInterestSavingsAccount) {
             HIS[HISCounter] = (HighInterestSavingsAccount)a;
             HISCounter++;
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
    void interestIncrease(){
        for (SavingsAccount account : saving){
            if (account == null){
                break;
            }
            account.addInterest();
        }

        for (HighInterestSavingsAccount account : HIS){
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
        System.out.println("Accessing account...");
        Account specifiedAccount;
        switch (type){
            case "CreditCard":
                specifiedAccount = credits[accountNumber-1];
                break;
            case "LineOfCredit":
                specifiedAccount = lineOfCredits[accountNumber-1];
                break;
            case "Chequing":
                specifiedAccount = chequing[accountNumber-1];
                break;
            case "Saving":
                specifiedAccount = saving[accountNumber-1];
                break;
            case "HighInterestSavings":
                specifiedAccount = HIS[accountNumber-1];
                break;
            default:
                specifiedAccount = null;
                break;
        }
        return specifiedAccount;
    }

    public List<String> getAccounts(int mode){
        List<String> temp = new ArrayList<>();
        for (Map.Entry<String, Account[]> list : allAccounts.entrySet()){
            if (mode == 1 && list.getKey().equals("CreditCard")){
                continue;
            }
            if (mode == 2 && !list.getKey().equals("CreditCard") && !list.getKey().equals("LineOfCredit")){
                continue;
            }
            Account[] accountList = list.getValue();
            for (int i = 0; i < accountList.length; i++){
                if (accountList[i] == null){
                    break;
                }
                temp.add(list.getKey() + " " + (i+1) + " : $" + accountList[i].getCurrentBalance());
            }
        }
        return temp;
    }
}