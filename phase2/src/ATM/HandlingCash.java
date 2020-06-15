/*
This class's purpose is to handle cash in the ATM
*/
package ATM;

public class HandlingCash{
    /** this is the number of $5 bills*/
    private static int fivers = 0;

    /** this is the nu,ber of $10 bills*/
    private static int tenners = 0;

    /** this is the number of $20 bills*/
    private static int twenties = 0;

    /**this is the number of $50 bills*/
    private static int fifties = 0;

    /**
     * This is the method that is called when a withdrawal is made
     *
     * @return boolean which tells us if the transactionw as a success or a failure
     */
    public static boolean transaction(int amount){
        if (amount%5 != 0){
            return false;
        }else{
            int fiveBill = 0;
            int tenBill = 0;
            int twentyBill = 0;
            int fiftyBill = 0;

            // Looping until amount is zero
            while(amount > 0) {
                if (((amount - 50) >= 0) && (HandlingCash.fifties > 0)){
                    amount -= 50;
                    fiftyBill++;
                    HandlingCash.fifties--;

                } else if (((amount - 20) >= 0) && (HandlingCash.twenties > 0)) {
                    amount -= 20;
                    twentyBill++;
                    HandlingCash.twenties--;

                } else if (((amount - 10) >= 0) && (HandlingCash.tenners > 0)){
                    amount -= 10;
                    tenBill++;
                    HandlingCash.tenners--;

                } else if (((amount - 5) >= 0) && (HandlingCash.fivers > 0)) {
                    amount -= 5;
                    fiveBill++;
                    HandlingCash.fivers--;

                } else{
                    HandlingCash.updateAlert();
                    return false;
                }
            }
            if (HandlingCash.fifties < 20 || HandlingCash.twenties < 20 || HandlingCash.tenners <
            20 || HandlingCash.fivers < 20){
                HandlingCash.updateAlert();
            }

            return true;
        }
    }

    /**
     * Adds an alert to alert list in BankMachine
     */
    private static void updateAlert(){
        BankMachine.alerts.addAlert("Please add more bills to machine.");
    }

    /** @return Number of 5 dollar bills in machine */
    public static int getFives(){
        return fivers;
    }

    /** @return Number of 10 dollar bills in machine */
    public static int getTens(){
        return tenners;
    }

    /** @return Number of 20 dollar bills in machine */
    public static int getTwenties(){
        return twenties;
    }

    /** @return Number of 50 dollar bills in machine */
    public static int getFifties(){
        return fifties;
    }

    /**Adds bills to $5 bills */
    public static void addFivers(int fivers) { HandlingCash.fivers += fivers; }

    /**Adds bills to $10 bills */
    public static void addTenners(int tenners) { HandlingCash.tenners += tenners; }

    /**Adds bills to $20 bills */
    public static void addTwenties(int twenties) { HandlingCash.twenties += twenties; }

    /**Adds bills to $50 bills */
    public static void addFifties(int fifties) { HandlingCash.fifties += fifties; }
}