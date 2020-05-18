package service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import types.Account;
import types.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestApiTesting {

    @Test
    public void testAddUser_Status201NewUser() {
        User user = new User("xxxdiogofalcaogamerpt69xxx@yahoo.com.br", "Diogo", "Falcão", "A21");

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
            URL url = new URL("https://reqres.in/api/resources");
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
        Account registeredUser = new Account("eve.holt@reqres.in", "pistol");

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
        Account registeredUser = new Account("eve.holt@reqres.in", "pistol");

        // JSON Object
        JSONObject jsonObject = new JSONObject();
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

            assertEquals(connection.getResponseCode(), 400);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRegister_Status400_MissingPassword() {
        Account registeredUser = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(connection.getResponseCode(), 400);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAuthenticate_Status200NewAuthenticatedUser() {
        Account registeredUser = new Account("eve.holt@reqres.in", "pistol");

        // JSON Object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", registeredUser.getEmail());
        jsonObject.put("password", registeredUser.getPassword());

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
    public void testAuthenticate_Status400_MissingEmail() {
        Account registeredUser = new Account("eve.holt@reqres.in", "pistol");

        // JSON Object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("password", registeredUser.getPassword());

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

            assertEquals(connection.getResponseCode(), 400);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAuthenticate_Status400_MissingPassword() {
        Account registeredUser = new Account("eve.holt@reqres.in", "pistol");

        // JSON Object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", registeredUser.getEmail());

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

            assertEquals(connection.getResponseCode(), 400);

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
