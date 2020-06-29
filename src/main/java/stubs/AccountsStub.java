package stubs;

import interfaces.AccountsInterface;
import types.Account;

import java.util.ArrayList;

public class AccountsStub implements AccountsInterface {

    @Override
    public boolean authenticateAccount(Account account) {
        // Accounts ArrayList
        ArrayList<Account> accounts = new ArrayList<Account>();

        // Creating Users
        final Account user0 = new Account("FirstUser@gmail.com", "FirstUser");
        final Account user1 = new Account("SecondUser@gmail.com", "SecondUser");
        final Account user2 = new Account("ThirdUser@gmail.com", "ThirdUser");

        // Adding Users
        accounts.add(user0);
        accounts.add(user1);
        accounts.add(user2);

        for (Account accountTemp : accounts) {
            if ((accountTemp.getEmail().equals(account.getEmail())) == true) {
                if ((accountTemp.getPassword().equals(account.getPassword())) == true) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean registerAccount(Account account) {
        ArrayList<Account> accounts = new ArrayList<Account>();

        return accounts.add(account) == true ? true : false;
    }
}
