/*
* A class to keep all the user accounts and store their usernames and passwords. Also contains a method to lookup user.
*
* */
package ATM;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class LoginDirectory implements Serializable {
    /**Stores user names and passwords*/
    private Map<String, String> loginInfo;

    /**Stores respective User objects for users*/
    private Map<String, User> userLookup;

    /**
     * Constructor of the user Directory class
     */
    LoginDirectory(){
        loginInfo = new HashMap<>();
        userLookup = new HashMap<>();
    }

    /**
     * Method adds a user into the map, provided the user doesn't already exist.
     *
     * @param username is a string username of user
     * @param password is the string password of user
     *
     * @return boolean depending on weather the user was added into the directory or not
     * */
    public User addUser(String username, String password, boolean employee){
        loginInfo.putIfAbsent(username,password);
            if (employee){
                BankTeller newBankTeller = new BankTeller(username);
                userLookup.put(username, newBankTeller);
                return newBankTeller;
            }else {
                User newUser = new User(username);
                userLookup.put(username, newUser);
                return newUser;
            }
    }

   /**
    * Checks the password of user. Returns a boolean depending on if the password is correct or not
    *
    * @param username is a string username of user
    * @param password is the string password of user
    *
    * @return boolean depending on weather the password was correct or not
    * */
    public boolean checkPassword(String username, String password){
        if (loginInfo.get(username) != null){
            return loginInfo.get(username).equals(password);
        } else {
            return false;
        }
    }

    public User getUser(String username){
        return userLookup.get(username);
    }

    public boolean userExists(String username){
        return loginInfo.containsKey(username);
    }

    /**
     * Changes a users password
     *
     * @param username is a string username of user
     * @param password is the string password of user
     * */
    public void changePassword(String username, String password){
        loginInfo.replace(username, password);
    }

    public String getPassword(String username){
        return loginInfo.get(username);
    }

    public void deleteUser(String username){
        loginInfo.remove(username);
        userLookup.remove(username);
    }

    Map<String, User> getDirectory(){
        return userLookup;
    }
}
