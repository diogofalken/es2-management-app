package cache;

import interfaces.AuthenticationRestApiMethods;
import types.Account;

import java.io.IOException;
import java.util.HashMap;

public class Authentication {

    // fields
    private AuthenticationRestApiMethods authenticationRestApiMethods;

    public Authentication(AuthenticationRestApiMethods authenticationRestApiMethods) {
        this.authenticationRestApiMethods = authenticationRestApiMethods;
    }

    // add user to registered
    public void registerAccount(String email, String password) throws Exception {
        Account account = new Account(email, password);

        this.authenticationRestApiMethods.postRegister(account);
    }

    // login a user
    public void authenticateAccount(String email, String password) throws Exception {
        Account account = new Account(email, password);
        this.authenticationRestApiMethods.postLogin(account);
    }
}
