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
import java.security.Key;
import java.util.Collection;

public class UsersMiddleware implements UserRestApiMethods {

    public UsersMiddleware() {
    }

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

            Collection<User> userCollection = null;

            for(int i = 0; i <= jsonArray.size(); i++) {
                System.out.println("hey");
                JSONObject jsonobject = (JSONObject) jsonArray.get(i);

                User user = new User(
                        jsonobject.get("email").toString(),
                        jsonobject.get("firstName").toString(),
                        jsonobject.get("lastName").toString(),
                        jsonobject.get("avatar").toString()
                );

                System.out.println(jsonobject.get("email").toString());

                user.setId((Integer) jsonobject.get("id"));

                userCollection.add(user);
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User getUser(Integer id) {
        return null;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return false;
    }
}
