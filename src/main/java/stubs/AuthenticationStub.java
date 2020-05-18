package stubs;

import interfaces.AuthenticationRestApiMethods;
import types.Account;

import java.util.HashMap;

public class AuthenticationStub implements AuthenticationRestApiMethods {

    // fields
    private HashMap<Integer, Account> registeredAccount = new HashMap<Integer, Account>();
    private HashMap<Integer, Account> authenticatedAccount = new HashMap<Integer, Account>();

    public AuthenticationStub() {
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

        // Already Registered
        for (Account registeredAccount : this.registeredAccount.values())
            if (registeredAccount.getEmail().equals(account.getEmail()))
                throw new Exception("Already Connected");


        return true;
     }

    @Override
    public boolean postRegister(Account account) throws Exception {
        if (account.getEmail().isEmpty() == true)
            throw new Exception("Missing Email");

        if (account.getPassword().isEmpty() == true)
            throw new Exception("Missing Password");

        // Already Connected
        for (Account authenticatedAccount : this.authenticatedAccount.values())
            if (authenticatedAccount.getEmail().equals(account.getEmail()))
                throw new Exception("Already Registered");


        return true;
    }
}
