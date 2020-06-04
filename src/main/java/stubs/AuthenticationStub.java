package stubs;

import interfaces.AuthenticationRestApiMethods;
import types.Account;

import java.util.HashMap;

public class AuthenticationStub implements AuthenticationRestApiMethods {

    public AuthenticationStub() {
    }

    @Override
    public boolean postLogin(Account account) throws Exception {
        if (account.getEmail().isEmpty() == true)
            throw new Exception("Missing Email");

        if (account.getPassword().isEmpty() == true)
            throw new Exception("Missing Password");

        HashMap<Integer, Account> authenticatedAccount = new HashMap<Integer, Account>();

        authenticatedAccount.put(authenticatedAccount.size() + 1,account);

        return true;
     }

    @Override
    public boolean postRegister(Account account) throws Exception {
        if (account.getEmail().isEmpty() == true)
            throw new Exception("Missing Email");

        if (account.getPassword().isEmpty() == true)
            throw new Exception("Missing Password");

        HashMap<Integer, Account> registeredAccount = new HashMap<Integer, Account>();

        registeredAccount.put(registeredAccount.size() + 1,account);

        return true;
    }
}
