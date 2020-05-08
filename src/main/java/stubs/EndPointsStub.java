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

    public void addUser(User user) {
        this.users.add(user);
    }

    public String listUsers() {
        JSONArray jsonArray = new JSONArray();

        for (User user : this.users) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Id", user.getId());
            jsonObject.put("Email", user.getEmail());
            jsonObject.put("First_Name", user.getFirstName());
            jsonObject.put("Last_Name", user.getLastName());
            jsonObject.put("Avatar", user.getAvatar());
        }

        return jsonArray.toJSONString();
    }

    public String singleUser(int _id) {
        JSONObject jsonObject = new JSONObject();

        for (User user : this.users) {
            if (user.getId() == _id) {
                jsonObject.put("Id", user.getId());
                jsonObject.put("Email", user.getEmail());
                jsonObject.put("First_Name", user.getFirstName());
                jsonObject.put("Last_Name", user.getLastName());
                jsonObject.put("Avatar", user.getAvatar());
            }
        }

        return jsonObject.toJSONString();
    }

    public String listResources() {
        JSONArray jsonArray = new JSONArray();

        for (Resource resource : this.resources) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Id", resource.getId());
            jsonObject.put("Name", resource.getName());
            jsonObject.put("Year", resource.getYear());
            jsonObject.put("Color", resource.getColor());
            jsonObject.put("PantoneValue", resource.getPantoneValue());
        }

        return jsonArray.toJSONString();
    }

    public String singleResource(int _id) {
        JSONObject jsonObject = new JSONObject();

        for (Resource resource : this.resources) {
            if (resource.getId() == _id) {
                jsonObject.put("Id", resource.getId());
                jsonObject.put("Name", resource.getName());
                jsonObject.put("Year", resource.getYear());
                jsonObject.put("Color", resource.getColor());
                jsonObject.put("PantoneValue", resource.getPantoneValue());
            }
        }

        return jsonObject.toJSONString();
    }

    public String authenticate(String email, String password) {
        JSONObject jsonObject = new JSONObject();

        if (email.isEmpty() == true) {
            jsonObject.put("error", "Missing Email");
            return jsonObject.toJSONString();
        }

        if (password.isEmpty() == true) {
            jsonObject.put("error", "Missing Password");
            return jsonObject.toJSONString();
        }

        if ((email.equals("eve.holt@reqres.in") == false) || (password.equals("cityslicka") == false)) {
            jsonObject.put("error", "User is not Valid");
            return jsonObject.toJSONString();
        }

        jsonObject.put("token", "QpwL5tke4Pnpja7X4");
        return jsonObject.toJSONString();
    }

    public String register(String email, String password) {
        JSONObject jsonObject = new JSONObject();

        if (email.isEmpty() == true) {
            jsonObject.put("error", "Missing Email");
            return jsonObject.toJSONString();
        }

        if (password.isEmpty() == true) {
            jsonObject.put("error", "Missing Password");
            return jsonObject.toJSONString();
        }

        jsonObject.put("id", 1);
        jsonObject.put("token", "QpwL5tke4Pnpja7X4");

        return jsonObject.toJSONString();
    }

}