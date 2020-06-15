Startup:
The Bank Machine will start off as a blank slate. Thus, will have no preset Users, Date, nor cash inside the Machine.
Upon starting the program, the user will be greeted with a JFrame (GUI) supporting 2 buttons :
    - Bank Manager
    - Customer
The user will have the option of either logging in as a Customer or as a BankManager. However,To begin, the user
should log in as the Bank Manager (Main Menu Option 1) in the first menu when first running the program.
 Once inside the Bank Manager menu, one should:
 1. Setup a date for the Bank Machine (Menu Button "SET DATE").
 2. Restock the Machine with bills (Menu Button "RESTOCK CASH").
    - To Restock, Bank Manager needs to set exact number of Bills inside the machine.
 3. Create a user(customer) (Menu Button "CREATE USER").
-----------------------------------------------------------------------------------------------------------------------
User and Account Creation:
Users are created by the Bank Manager (Menu Button "CREATE USER") as they are ONE of the only person that is able to
setup an initial login and password for the user, The other being the Bank Teller. Additionally, the User will
automatically be given a default chequing account.Hence why it may appear as the user may have 2 chequing accounts
upon creation of another chequing Account. Any other new account must be requested by the
User (User Menu --> Account Button "CREATE ACCOUNT") which will alert the Bank Manager.
The Bank Manager and Bank teller are the only one allowed to create new accounts.
 -----------------------------------------------------------------------------------------------------------------------
 Depositing Money by Cash or Cheque:
 When depositing a cheque, deposits.txt should be setup so that there is a single monetary value on line one without
 any spaces.
 When depositing cash, line one of the text file should have an int for the number of 50 dollar bills to
 cash in. Furthermore lines two, three, and four should have each have an int for 20 dollar, 10 dollar, and 5 dollar
 bills respectively.
 If deposits.txt are not correctly set up then the program will print out an error message.

 - Cheque Example:
 101.21

 - Cash Example:
 1
 2
 3
 4
-----------------------------------------------------------------------------------------------------------------------
Day Advancement:
- The day will advance when the machine is shut down in the main menu (Main Menu Option 3).
- Savings accounts for all users will have their interest increased by a factor of 0.1% on the first of each month.
- High Interest Savings account will add a 0.25% interest rate if the user exceeds his limit of $2500.
-----------------------------------------------------------------------------------------------------------------------
Alerts:
The Bank Manager is able to view alerts for the current and previous day through menu option 3 on the bank manager
menu. However, it is recommended that the alerts still be checked everyday.
-----------------------------------------------------------------------------------------------------------------------
outgoing.txt:
When a User pays a bill the recipient and the dollar amount will be written to outgoing.txt
-----------------------------------------------------------------------------------------------------------------------
New Implementation :
- GUI
    We have implemented a new user interface for users. All users have to do is push the button which they want to
    interact with.
- Accounts
    High Interest Account
        High Interest Savings account will add a 0.25% interest rate if the user exceeds his limit of $2500.
    Joint Account
        This is an account based on connection of 2 users. Any changes made in one account can be seen in the other
        users account.
- Bank Teller
    This new class implements an employee at the bank, who has has both functionality of Bank Manager and User. However
    This employee can create accounts and check balances, it cannot have full access to functions a manager has. For
    Instance,  a bank employee cannot Restock Atm, Or check Alerts sent by other users. Only a Bank Manager has complete
    access.

-----------------------------------------------------------------------------------------------------------------------
Final Messages:
From here, you're ready to go! All accounts begin with $0 in their account and have their own specifications. For
example, a User's Credit Card Account will be able to withdraw money, however, will be unable to transfer money to
other users or between their Accounts. The balance of the Credit Card account will thus represent the money the User
owes.