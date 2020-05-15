package middleware;

import types.User;

import java.net.URL;

public class UserMiddleware {

    public UserMiddleware() {

    }

    /**
     * It will post an User to the Rest API
     * @param user
     * @return boolean, depending on the Post Request result
     */
    public boolean postUser(User user) throws Exception {
        try {
            URL url = new URL("https://reqres.in/api/users");
        } catch (Exception e) {
            throw new Exception("Post request failed");
        }
        return true;
    }

    /**
     * It will Fetch all the Users from the Rest API
     * @return boolean, depending on the Get Request result
     */
    public boolean getUsers() {
        return true;
    }

    /**
     * It will Fetch a single User from the Rest API
     * @param user
     * @return boolean, depending on the Get Request result
     */
    public boolean getUser(User user) {
        return true;
    }

    /**
     * It will delete an User from the Rest API
     * @param user
     * @return boolean, depending on the Delete Request result
     */
    public boolean deleteUser(User user) {
        return true;
    }
}
