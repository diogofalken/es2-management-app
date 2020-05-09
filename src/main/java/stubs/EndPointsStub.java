package stubs;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import interfaces.EndPointsMethods;
import types.Resource;
import types.User;

@SuppressWarnings("unchecked")
public class EndPointsStub implements EndPointsMethods {

    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Resource> resources = new ArrayList<Resource>();

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
        }

        // Create final response object
        finalObject.put("status", 200);
        finalObject.put("data", jsonArray);

        return finalObject.toJSONString();
    }

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

}