package interfaces;

import types.Account;

public interface AuthenticationRestApiMethods {

    boolean postLogin(Account account) throws Exception;

    boolean postRegister(Account account) throws Exception;
}
