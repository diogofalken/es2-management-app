package cache;

import interfaces.AccountsInterface;
import types.Account;


public class Accounts {
    private final AccountsInterface accountsInterface;

    public Accounts(AccountsInterface accountsInterface) {
        this.accountsInterface = accountsInterface;
    }

    public boolean authenticateAccount(Account account) throws Exception {
        if ((account.getEmail().isEmpty()) == true) {
            throw new Exception("Email must not be empty!");
        }

        if ((account.getEmail().length()) < 11) {
            throw new Exception("Email length must be higher than 11!");
        }

        if ((account.getEmail().length() > 25) == true) {
            throw new Exception("Email length must be lower than 25!");
        }

        if ((account.getEmail() instanceof String) == false) {
            throw new Exception("Email must be a String!");
        }

        if ((account.getEmail().matches("(.*)[$&+,:;=?#|](.*)")) == true) {
            throw new Exception("Email must only contain numbers, letters and @gmail.com!");
        }

        if ((account.getEmail().contains("@gmail.com")) == false) {
            throw new Exception("Email must contain @gmail.com!");
        }

        if ((account.getPassword().isEmpty()) == true) {
            throw new Exception("Password must not be empty!");
        }

        if ((account.getPassword().length() < 8) == true) {
            throw new Exception("Password length must be higher than 8!");
        }

        if ((account.getPassword().length() > 15) == true) {
            throw new Exception("Email length must be lower than 15!");
        }

        if ((account.getPassword() instanceof String) == true) {
            throw new Exception("Password must be a String!");
        }

        if ((account.getPassword().matches("(.*)[$&+,:;=?@#|.](.*)")) == true) {
            throw new Exception("Password must only contain numbers and letters!");
        }

        return this.accountsInterface.authenticateAccount(account);
    }

    public boolean registerAccount(Account account) throws Exception {
        if ((account.getEmail().isEmpty()) == true) {
            throw new Exception("Email must not be empty!");
        }

        if ((account.getEmail().length()) < 11) {
            throw new Exception("Email length must be higher than 11!");
        }

        if ((account.getEmail().length() > 25) == true) {
            throw new Exception("Email length must be lower than 25!");
        }

        if ((account.getEmail() instanceof String) == false) {
            throw new Exception("Email must be a String!");
        }

        if ((account.getEmail().matches("(.*)[$&+,:;=?#|](.*)")) == true) {
            throw new Exception("Email must only contain numbers, letters and @gmail.com!");
        }

        if ((account.getEmail().contains("@gmail.com")) == false) {
            throw new Exception("Email must contain @gmail.com!");
        }

        if ((account.getPassword().isEmpty()) == true) {
            throw new Exception("Password must not be empty!");
        }

        if ((account.getPassword().length() < 8) == true) {
            throw new Exception("Password length must be higher than 8!");
        }

        if ((account.getPassword().length() > 15) == true) {
            throw new Exception("Email length must be lower than 15!");
        }

        if ((account.getPassword() instanceof String) == true) {
            throw new Exception("Password must be a String!");
        }

        if ((account.getPassword().matches("(.*)[$&+,:;=?@#|.](.*)")) == true) {
            throw new Exception("Password must only contain numbers and letters!");
        }

        return this.accountsInterface.registerAccount(account);
    }
}
