package stubs;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import interfaces.EndPointsMethods;
import types.Resource;
import types.User;

@SuppressWarnings("unchecked")
public class EndPointsStub implements EndPointsMethods {

    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Resource> resources = new ArrayList<Resource>();

    public EndPointsStub() {
        this.defaultUsers();
        this.defaultResources();
    }

    private void defaultUsers() {
        // Classes instances
        final User user0 = new User(2, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");
        final User user1 = new User(3, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MariaLealFanboyXxX6969");
        final User user2 = new User(4, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MinecraftGajasEAlcoolXxX6969");

        // Adding the users
        users.add(user0);
        users.add(user1);
        users.add(user2);
    }

    private void defaultResources() {
        final Resource resource1 = new Resource(1, "xX69FalcaoZinhoGamer69Xx@outlook.pt",  1997, "Yellow", "lol123");
        final Resource resource2 = new Resource(2, "xX69FalcaoZinhoGamer69Xx@outlook.pt",  1997, "Yellow", "lol123");
        final Resource resource3 = new Resource(3, "xX69FalcaoZinhoGamer69Xx@outlook.pt",  1997, "Yellow", "lol123");

        this.resources.add(resource1);
        this.resources.add(resource2);
        this.resources.add(resource3);
    }

    @Override
    public String addUser(User user) {
        JSONObject finalObject = new JSONObject();

        this.users.add(user);

        // Transform user in object
        JSONObject userObject = new JSONObject();
        userObject.put("Id", user.getId());
        userObject.put("Email", user.getEmail());
        userObject.put("First_Name", user.getFirstName());
        userObject.put("Last_Name", user.getLastName());
        userObject.put("Avatar", user.getAvatar());

        // Create final response object
        finalObject.put("status", 201);
        finalObject.put("body", userObject);

        return finalObject.toJSONString();
    }

    @Override
    public String listUsers() {
        JSONObject finalObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (User user : this.users) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Id", user.getId());
            jsonObject.put("Email", user.getEmail());
            jsonObject.put("First_Name", user.getFirstName());
            jsonObject.put("Last_Name", user.getLastName());
            jsonObject.put("Avatar", user.getAvatar());
            jsonArray.add(jsonObject);

        }

        // Create final response object
        finalObject.put("status", 200);
        finalObject.put("data", jsonArray);

        return finalObject.toJSONString();
    }

    @Override
    public String singleUser(int _id) {
        int flag = 0;
        JSONObject jsonObject = new JSONObject();
        JSONObject finalObject = new JSONObject();

        for (User user : this.users) {
            if (user.getId() == _id) {
                jsonObject.put("Id", user.getId());
                jsonObject.put("Email", user.getEmail());
                jsonObject.put("First_Name", user.getFirstName());
                jsonObject.put("Last_Name", user.getLastName());
                jsonObject.put("Avatar", user.getAvatar());
                flag = 1;
            }
        }

        // Create final response object
        if (flag == 0) {
            finalObject.put("status", 404);
            finalObject.put("data", jsonObject);
        } else {
            finalObject.put("status", 200);
            finalObject.put("data", jsonObject);
        }

        return finalObject.toJSONString();
    }

    @Override
    public String listResources() {
        JSONArray jsonArray = new JSONArray();
        JSONObject finalObject = new JSONObject();

        for (Resource resource : this.resources) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Id", resource.getId());
            jsonObject.put("Name", resource.getName());
            jsonObject.put("Year", resource.getYear());
            jsonObject.put("Color", resource.getColor());
            jsonObject.put("PantoneValue", resource.getPantoneValue());
            jsonArray.add(jsonObject);
        }

        // Create final response object
        finalObject.put("status", 200);
        finalObject.put("data", jsonArray);

        return finalObject.toJSONString();
    }

    @Override
    public String singleResource(int _id) {
        int flag = 0;
        JSONObject jsonObject = new JSONObject();
        JSONObject finalObject = new JSONObject();

        for (Resource resource : this.resources) {
            if (resource.getId() == _id) {
                jsonObject.put("Id", resource.getId());
                jsonObject.put("Name", resource.getName());
                jsonObject.put("Year", resource.getYear());
                jsonObject.put("Color", resource.getColor());
                jsonObject.put("PantoneValue", resource.getPantoneValue());
                flag = 1;
            }
        }

        // Create final response object
        if (flag == 0) {
            finalObject.put("status", 404);
            finalObject.put("data", jsonObject);
        } else {
            finalObject.put("status", 200);
            finalObject.put("data", jsonObject);
        }

        return finalObject.toJSONString();
    }

    @Override
    public String authenticate(String email, String password) {
        JSONObject finalObject = new JSONObject();

        // Wrong Email
        if (email.isEmpty() == true) {
            finalObject.put("status", 400);
            finalObject.put("error", "Missing Email");
            return finalObject.toJSONString();
        }

        // No password
        if (password.isEmpty() == true) {
            finalObject.put("status", 400);
            finalObject.put("error", "Missing Password");
            return finalObject.toJSONString();
        }

        // Wrong user
        if ((email.equals("eve.holt@reqres.in") == false) || (password.equals("cityslicka") == false)) {
            finalObject.put("status", 400);
            finalObject.put("error", "User is not Valid");
            return finalObject.toJSONString();
        }

        // On success
        finalObject.put("status", 200);
        finalObject.put("token", "QpwL5tke4Pnpja7X4");
        return finalObject.toJSONString();
    }

    @Override
    public String register(String email, String password) {
        JSONObject finalObject = new JSONObject();
        JSONObject jsonObject = new JSONObject();

        // Empty email
        if (email.isEmpty() == true) {
            finalObject.put("status", 400);
            finalObject.put("error", "Missing Email");
            return finalObject.toJSONString();
        }

        // Empty password
        if (password.isEmpty() == true) {
            finalObject.put("status", 400);
            finalObject.put("error", "Missing Password");
            return finalObject.toJSONString();
        }

        // Successful register
        finalObject.put("status", 200);
        jsonObject.put("id", 1);
        jsonObject.put("token", "QpwL5tke4Pnpja7X4");
        finalObject.put("data", jsonObject);

        return finalObject.toJSONString();
    }

    @Override
    public String updateUser(User user) {
        int flag = 0;
        JSONObject finalObject = new JSONObject();

        for (User tempUser : this.users) {
            if (tempUser.getId() == user.getId()) {
                JSONObject userObject = new JSONObject();
                tempUser.setEmail(user.getEmail());
                tempUser.setFirstName(user.getFirstName());
                tempUser.setLastName(user.getLastName());
                tempUser.setAvatar(user.getAvatar());
                userObject.put("Id", tempUser.getId());
                userObject.put("Email", tempUser.getEmail());
                userObject.put("First_Name", tempUser.getFirstName());
                userObject.put("Last_Name", tempUser.getLastName());
                userObject.put("Avatar", tempUser.getAvatar());
                // Create final response object
                finalObject.put("status", 200);
                finalObject.put("body", userObject);
            }
        }

        return finalObject.toJSONString();
    }

    @Override
    public String patchUser(User user) {
        int flag = 0;
        JSONObject finalObject = new JSONObject();

        for (User tempUser : this.users) {
            if (tempUser.getId() == user.getId()) {
                JSONObject userObject = new JSONObject();
                tempUser.setEmail(user.getEmail());
                tempUser.setFirstName(user.getFirstName());
                tempUser.setLastName(user.getLastName());
                tempUser.setAvatar(user.getAvatar());
                userObject.put("Id", tempUser.getId());
                userObject.put("Email", tempUser.getEmail());
                userObject.put("First_Name", tempUser.getFirstName());
                userObject.put("Last_Name", tempUser.getLastName());
                userObject.put("Avatar", tempUser.getAvatar());
                // Create final response object
                finalObject.put("status", 200);
                finalObject.put("body", userObject);
            }
        }

        return finalObject.toJSONString();
    }

    @Override
    public String deleteUser(int _id) {
        JSONObject finalObject = new JSONObject();

        for (User user : this.users) {
            if (user.getId() == _id) {
                this.users.remove(user.getId());
            }
        }

        finalObject.put("status", 204);
        return finalObject.toJSONString();
    }

    @Override
    public String listUsersDelayed() throws InterruptedException {
        JSONObject finalObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (User user : this.users) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Id", user.getId());
            jsonObject.put("Email", user.getEmail());
            jsonObject.put("First_Name", user.getFirstName());
            jsonObject.put("Last_Name", user.getLastName());
            jsonObject.put("Avatar", user.getAvatar());
            jsonArray.add(jsonObject);

        }

        // Create final response object
        finalObject.put("status", 200);
        finalObject.put("data", jsonArray);

        TimeUnit.SECONDS.sleep(3);

        return finalObject.toJSONString();
    }


}