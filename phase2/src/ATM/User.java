/*
This class represents a user and is used by the User to call their AccountManager, change their password, get their
info, balances, etc
*/
package ATM;

import java.io.*;

public class User implements Serializable {
    /** variables for the username and AccountManager object*/
    private String userName;

    /** Security Question*/
    private String SecurityQ;

    /** Security Answer*/
    private String SecurityA;

    /** Object of type AccountManager*/
    public AccountManager accountManager = new AccountManager();

    public User(String userName){
        this.userName = userName;
    }

    public void setSecurity(String question, String answer){
        SecurityQ = question;
        SecurityA = answer;
    }

    public String getSecurityQ(){
        return SecurityQ;
    }

    public boolean validateSecurityA(String answer){
        return answer.equals(SecurityA);
    }

    public String getUsername(){
        return this.userName;
    }
}