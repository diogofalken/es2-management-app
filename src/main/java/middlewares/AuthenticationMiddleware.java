package middlewares;

import interfaces.AuthenticationRestApiMethods;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import types.Account;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AuthenticationMiddleware implements AuthenticationRestApiMethods {
    @Override
    public boolean postLogin(Account account) throws Exception {
        if (account.getEmail().isEmpty() == true)
            throw new Exception("Missing Email");

        if (account.getPassword().isEmpty() == true)
            throw new Exception("Missing Password");

        // JSON Object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", account.getEmail());
        jsonObject.put("password", account.getPassword());

        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/register");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            // Output To send
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(jsonObject.toJSONString().getBytes("UTF-8"));
            outputStream.close();

            connection.disconnect();

            if(connection.getResponseCode() == 200)
                return true;

            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean postRegister(Account account) throws Exception {
        if (account.getEmail().isEmpty() == true)
            throw new Exception("Missing Email");

        if (account.getPassword().isEmpty() == true)
            throw new Exception("Missing Password");

        // JSON Object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", account.getEmail());
        jsonObject.put("password", account.getPassword());

        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            // Output To send
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(jsonObject.toJSONString().getBytes("UTF-8"));
            outputStream.close();

            connection.disconnect();

            if(connection.getResponseCode() == 200)
                return true;

            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
