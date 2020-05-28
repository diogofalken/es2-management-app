package mocks;

import interfaces.AuthenticationRestApiMethods;
import types.Account;

import java.util.HashMap;

public class AuthenticationMock implements AuthenticationRestApiMethods {

    // fields
    private HashMap<Integer, Account> registeredAccount = new HashMap<Integer, Account>();
    private HashMap<Integer, Account> authenticatedAccount = new HashMap<Integer, Account>();

    public AuthenticationMock() {
        this.defaultRegisteredUsers();
        this.defaultAuthenticateUsers();
    }

    private void defaultRegisteredUsers() {
        final Account registeredUser = new Account("diogo@hotmail.com", "A123");
        this.registeredAccount.put(1, registeredUser);
    }

    private void defaultAuthenticateUsers() {
        final Account registeredUser = new Account("diogo@hotmail.com", "A123");
        this.authenticatedAccount.put(this.authenticatedAccount.size() + 1, registeredUser);
    }

    @Override
    public boolean postLogin(Account account) throws Exception {
        if (account.getEmail().isEmpty() == true)
            throw new Exception("Missing Email");

        if (account.getPassword().isEmpty() == true)
            throw new Exception("Missing Password");

        this.authenticatedAccount.put(authenticatedAccount.size() + 1,account);

        return true;
     }

    @Override
    public boolean postRegister(Account account) throws Exception {
        if (account.getEmail().isEmpty() == true)
            throw new Exception("Missing Email");

        if (account.getPassword().isEmpty() == true)
            throw new Exception("Missing Password");

        this.registeredAccount.put(registeredAccount.size() + 1,account);

        return true;
    }
}
