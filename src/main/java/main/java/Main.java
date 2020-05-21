package main.java;
import middlewares.AuthenticationMiddleware;
import types.Account;

public class Main {
    public static void main(String[] args) throws Exception {
        AuthenticationMiddleware authenticationMiddleware = new AuthenticationMiddleware();
        Account registeredUser = new Account("eve.holt@reqres.in", "pistol");
        System.out.println(authenticationMiddleware.postRegister(registeredUser));
    }
}
