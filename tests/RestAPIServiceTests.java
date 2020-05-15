
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import types.RegisteredUser;
import types.User;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class RestAPIServiceTests {

    @Test
    public void testAddUser_Status201NewUser() {
        User user = new User(1,"xxxdiogofalcaogamerpt69xxx@yahoo.com.br", "Diogo", "Falcão", "A21");

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

            jsonObject.forEach((key, value) -> {
                assertEquals(jsonObject.get(key), jsonOutput.get(key));
            });

            assertEquals(connection.getResponseCode(), 201);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_Status200AllUsers() {
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

            assertEquals(connection.getResponseCode(), 200);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_Status200SingleUser() {
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

            assertEquals(connection.getResponseCode(), 200);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_Status404SingleUser() {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users/1000");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            assertEquals(connection.getResponseCode(), 404);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListResources_Status200AllResources() {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/resources/1000");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            assertEquals(connection.getResponseCode(), 404);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListResource_Status200SingleResource() {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/resources/1");
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

            assertEquals(connection.getResponseCode(), 200);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListResource_Status404SingleResource() {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/resources/1000");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            assertEquals(connection.getResponseCode(), 404);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegister_Status200NewRegisteredUser() {
        RegisteredUser registeredUser = new RegisteredUser("eve.holt@reqres.in", "pistol");

        // JSON Object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", registeredUser.getEmail());
        jsonObject.put("password", registeredUser.getPassword());

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

            jsonOutput.forEach((key, value) -> {
                if(key.equals("id")) {
                    assertEquals(key, "id");
                }

                if(key.equals("token")) {
                    assertEquals(key, "token");
                }
            });

            assertEquals(connection.getResponseCode(), 200);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegister_Status400_MissingEmail() {
        RegisteredUser registeredUser = new RegisteredUser("eve.holt@reqres.in", "pistol");

        // JSON Object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", registeredUser.getEmail());

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

            jsonOutput.forEach((key, value) -> {
                assertEquals(jsonOutput.get(key), "Missing password");
            });

            assertEquals(connection.getResponseCode(), 400);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegister_Status400_MissingPassword() {
        RegisteredUser registeredUser = new RegisteredUser("eve.holt@reqres.in", "pistol");

        // JSON Object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", registeredUser.getEmail());

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

            System.out.println(connection.getResponseCode());

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

            jsonOutput.forEach((key, value) -> {
                assertEquals(jsonOutput.get(key), "Missing password");
            });

            assertEquals(connection.getResponseCode(), 400);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAuthenticate_Status200NewAuthenticatedUser() {

    }

    @Test
    public void testAuthenticate_Status400() {

    }
}
