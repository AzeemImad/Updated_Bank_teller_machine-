/*
This is the main class. In this class, the program operator can choose whether they are a Bank Manager or just a
regular User. If they are a user, they must log into their account using their login and password. This is done through
a dictionary in BankMachine that stores keys that consists of a tuple representing (login, password). This key will then
return a instance of User. This acts as the ATM. This class handles withdrawal, calling HandlingCash and User.
*/
package ATM;
import ATM.FormsAndGui.BankMachineMenu;
import ATM.FormsAndGui.BankManager;
import ATM.FormsAndGui.UserLogin;

import java.util.*;
import java.time.LocalDate;
import java.util.List;

public class BankMachine{
    public static LoginDirectory userDirectory;
    public static Alerts alerts;

    /**
     * Method saves all the information want to keep onto txt files before terminating the whole program
     * */
    public static void closingProgram(){
        FileHandler.writeObject("TextFiles/userInfo.txt", userDirectory);
        FileHandler.writeObject("TextFiles/date.txt", Date.nextDay(1));
        FileHandler.writeObject("TextFiles/alerts.txt", alerts.writeOutAlerts());
        FileHandler.writeCash("TextFiles/cash.txt", HandlingCash.getFifties(), HandlingCash.getTwenties(), HandlingCash.getTens(), HandlingCash.getFives());
        System.exit(100);
    }

    /**
     * Method sets up and reads in the necessary information upon program startup from files.
     * On the first of every month it applies interest to all savings accounts
     *
     * */
    private static void programStart(){
        userDirectory = (LoginDirectory) FileHandler.readObject("TextFiles/userInfo.txt");
        if (userDirectory == null) userDirectory = new LoginDirectory();
        alerts = new Alerts((List<String>) FileHandler.readObject("TextFiles/alerts.txt"));
        Date.setDate((LocalDate) FileHandler.readObject("TextFiles/date.txt"));
        int[] billLevels = FileHandler.readCash("TextFiles/cash.txt");
        HandlingCash.addFifties(billLevels[0]);
        HandlingCash.addTwenties(billLevels[1]);
        HandlingCash.addTenners(billLevels[2]);
        HandlingCash.addFivers(billLevels[3]);
        if (Date.isNewMonth()) {
            for (Map.Entry<String, User> entry : userDirectory.getDirectory().entrySet()) {
                User client = entry.getValue();
                client.accountManager.interestIncrease();
            }
        }
    }

    /**
     * Main method of the entire program. Responsible for setting up the ATM at the moment of compile
     * */
    public static void main(String[] args){
        programStart();

        BankMachineMenu startScreen = new BankMachineMenu(new BankManager(), new UserLogin());
        startScreen.build();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                startScreen.setVisible(true);
            }
        });
    }
}