package interfaces;

import types.Account;

public interface AccountsInterface {
    boolean authenticateAccount(Account account) throws Exception;

    boolean registerAccount(Account account) throws Exception;

}
