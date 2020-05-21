package middlewares;

import interfaces.UserRestApiMethods;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import types.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

public class UsersMiddleware implements UserRestApiMethods {
    @Override
    public User postUser(User user) {
        // JSON Object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", user.getEmail());
        jsonObject.put("firstName", user.getFirstName());
        jsonObject.put("lastName", user.getLastName());
        jsonObject.put("avatar", user.getAvatar());

        // JSON String
        String jsonString = jsonObject.toString();

        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            // Output To send
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(jsonString.getBytes("UTF-8"));
            outputStream.close();

            // Buffer
            InputStreamReader in = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(in);

            // String Builder
            StringBuilder result = new StringBuilder();

            // Output
            String output;

            while ((output = br.readLine()) != null) {
                result.append(output);
            }

            // Closing the buffer
            br.close();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());


            for(Object key : jsonOutput.keySet()) {
                if(key.equals("id") == true) {
                    user.setId(Integer.parseInt((String) jsonOutput.get(key)));
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public Collection<User> getUsers() {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            // Buffer
            InputStreamReader in = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(in);

            // String Builder
            StringBuilder result = new StringBuilder();

            // Output
            String output;

            while ((output = br.readLine()) != null) {
                result.append(output);
            }

            // Closing the buffer
            br.close();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());
            JSONArray jsonArray = (JSONArray) jsonOutput.get("data");

            Collection<User> userCollection = new ArrayList<User>();

            for(int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonobject = (JSONObject) jsonArray.get(i);
                String email = jsonobject.get("email").toString();
                String firstName = jsonobject.get("email").toString();
                String lastName = jsonobject.get("email").toString();
                String avatar = jsonobject.get("email").toString();

                User user = new User(email, firstName, lastName, avatar);

                user.setId((Integer.parseInt(jsonobject.get("id").toString())));

                userCollection.add(user);
            }

            connection.disconnect();
            return userCollection;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User getUser(Integer id) {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users/1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            // Buffer
            InputStreamReader in = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(in);

            // String Builder
            StringBuilder result = new StringBuilder();

            // Output
            String output;

            while ((output = br.readLine()) != null) {
                result.append(output);
            }

            // Closing the buffer
            br.close();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());
            JSONObject jsonData = (JSONObject) jsonOutput.get("data");

            // fields
            String email = jsonData.get("email").toString();
            String firstName = jsonData.get("first_name").toString();
            String lastName = jsonData.get("last_name").toString();
            String avatar = jsonData.get("avatar").toString();

            User user = new User(email, firstName , lastName , avatar);

            user.setId(Integer.parseInt(jsonData.get("id").toString()));

            connection.disconnect();

            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteUser(Integer id) {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.disconnect();

            if(connection.getResponseCode() == 204)
                return true;

            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
