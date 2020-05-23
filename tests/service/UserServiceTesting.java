package service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import types.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTesting {
    @Test
    public void testAddUser_CorrectUser_StatusMustBe201() {
        User user = new User("xxxdiogofalcaogamerpt69xxx@yahoo.com.br", "Diogo", "Falcão", "A21");

        // JSON Object
        JSONObject userJson = new JSONObject();
        userJson.put("email", user.getEmail());
        userJson.put("firstName", user.getFirstName());
        userJson.put("lastName", user.getLastName());
        userJson.put("avatar", user.getAvatar());

        // JSON String
        String userJsonString = userJson.toString();

        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Output To send
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(userJsonString.getBytes("UTF-8"));
            outputStream.close();

            assertEquals(201, connection.getResponseCode());

            connection.disconnect();

        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testAddUser_CorrectUser_StatusMustNotBe400() {
        User user = new User("xxxdiogofalcaogamerpt69xxx@yahoo.com.br", "Diogo", "Falcão", "A21");

        // JSON Object
        JSONObject userJson = new JSONObject();
        userJson.put("email", user.getEmail());
        userJson.put("firstName", user.getFirstName());
        userJson.put("lastName", user.getLastName());
        userJson.put("avatar", user.getAvatar());

        // JSON String
        String userJsonString = userJson.toString();

        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Output To send
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(userJsonString.getBytes("UTF-8"));
            outputStream.close();

            assertNotEquals(400, connection.getResponseCode());

            connection.disconnect();

        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testAddUser_CorrectUser_ContentTypeMustBeJsonString() {
        User user = new User("xxxdiogofalcaogamerpt69xxx@yahoo.com.br", "Diogo", "Falcão", "A21");

        // JSON Object
        JSONObject userJson = new JSONObject();
        userJson.put("email", user.getEmail());
        userJson.put("firstName", user.getFirstName());
        userJson.put("lastName", user.getLastName());
        userJson.put("avatar", user.getAvatar());

        // JSON String
        String userJsonString = userJson.toString();

        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Output To send
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(userJsonString.getBytes("UTF-8"));
            outputStream.close();

            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            connection.disconnect();

        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testAddUser_CorrectUser_BodyMustMatchTheSchema() {
        User user = new User("xxxdiogofalcaogamerpt69xxx@yahoo.com.br", "Diogo", "Falcão", "A21");

        // JSON Object
        JSONObject userJson = new JSONObject();
        userJson.put("email", user.getEmail());
        userJson.put("firstName", user.getFirstName());
        userJson.put("lastName", user.getLastName());
        userJson.put("avatar", user.getAvatar());

        // JSON String
        String userJsonString = userJson.toString();

        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Output To send
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(userJsonString.getBytes("UTF-8"));
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

            userJson.forEach((key, value) -> {
                assertEquals(userJson.get(key), jsonOutput.get(key));
            });

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testListUsers_AllUsers_StatusMustBe200() {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            assertEquals(200, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_StatusMustNotBe400() {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            assertNotEquals(400, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_ContentTypeMustBeJsonString() {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_IdFieldMustBeLong() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("id") == true) {
                        assertTrue(jsonObject.get(key) instanceof Long );
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_IdFieldMustNotBeString() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("id") == true) {
                        assertFalse(jsonObject.get(key) instanceof String );
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_EmailFieldMustBeString() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("email") == true) {
                        assertTrue(jsonObject.get(key) instanceof String);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_EmailFieldMustNotBeInteger() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("email") == true) {
                        assertFalse(jsonObject.get(key) instanceof Integer);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_EmailFieldMustHaveSizeUnder50() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("email") == true) {
                        String email = (String) jsonObject.get(key);
                        assertTrue(email.length() < 50);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_EmailFieldMustNotHaveSizeOver50() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("email") == true) {
                        String email = (String) jsonObject.get(key);
                        assertFalse(email.length() > 50);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_EmailFieldMustNotBeEmpty() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("email") == true) {
                        String email = (String) jsonObject.get(key);
                        assertFalse(email.isEmpty());
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_FirstNameFieldMustBeString() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("firstName") == true) {
                        assertTrue(jsonObject.get(key) instanceof String);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_FirstNameFieldMustNotBeInteger() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("firstName") == true) {
                        assertFalse(jsonObject.get(key) instanceof Integer);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_FirstNameFieldMustHaveSizeUnder25() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("firstName") == true) {
                        String field = (String) jsonObject.get(key);
                        assertTrue(field.length() < 25);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_FirstNameFieldMustNotHaveSizeOver25() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("firstName") == true) {
                        String field = (String) jsonObject.get(key);
                        assertFalse(field.length() > 25);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_FirstNameFieldMustNotBeEmpty() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("firstName") == true) {
                        String field = (String) jsonObject.get(key);
                        assertFalse(field.isEmpty());
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_LastNameFieldMustBeString() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("lastName") == true) {
                        assertTrue(jsonObject.get(key) instanceof String);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_LastNameFieldMustNotBeInteger() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("lastName") == true) {
                        assertFalse(jsonObject.get(key) instanceof Integer);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_LastNameFieldMustHaveSizeUnder50() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("lastName") == true) {
                        String field = (String) jsonObject.get(key);
                        assertTrue(field.length() < 50);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_LastNameFieldMustNotHaveSizeOver50() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("lastName") == true) {
                        String field = (String) jsonObject.get(key);
                        assertFalse(field.length() > 50);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_LastNameFieldMustNotBeEmpty() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("lastName") == true) {
                        String field = (String) jsonObject.get(key);
                        assertFalse(field.isEmpty());
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_AvatarFieldMustBeString() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("avatar") == true) {
                        assertTrue(jsonObject.get(key) instanceof String);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_AvatarFieldMustNotBeInteger() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("avatar") == true) {
                        assertFalse(jsonObject.get(key) instanceof Integer);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_AvatarFieldMustHaveSizeUnder100() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("avatar") == true) {
                        String field = (String) jsonObject.get(key);
                        assertTrue(field.length() < 100);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_AvatarFieldMustNotHaveSizeOver100() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("avatar") == true) {
                        String field = (String) jsonObject.get(key);
                        assertFalse(field.length() > 100);
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUsers_AllUsers_AvatarFieldMustNotBeEmpty() {
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
            JSONArray data = (JSONArray) jsonOutput.get("data");

            for(int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = (JSONObject) data.get(i);
                for (Object key : jsonObject.keySet()) {
                    if(key.equals("avatar") == true) {
                        String field = (String) jsonObject.get(key);
                        assertFalse(field.isEmpty());
                    }
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_StatusMustBe200() {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users/1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            assertEquals(200, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_StatusMustBe404() {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users/1000");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            assertEquals(404, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_ContentTypeMustBeJsonString() {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users/1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_IdFieldMustBeLong() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("id") == true) {
                    assertTrue(data.get(key) instanceof Long );
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_IdFieldMustNotBeString() {
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
            JSONObject data = (JSONObject)  jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("id") == true) {
                    assertFalse(data.get(key) instanceof String );
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_EmailFieldMustBeString() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("email") == true) {
                    assertTrue(data.get(key) instanceof String);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_EmailFieldMustNotBeInteger() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("email") == true) {
                    assertFalse(data.get(key) instanceof Integer);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_EmailFieldMustHaveSizeUnder50() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("email") == true) {
                    String email = (String) data.get(key);
                    assertTrue(email.length() < 50);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_EmailFieldMustNotHaveSizeOver50() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("email") == true) {
                    String email = (String) data.get(key);
                    assertFalse(email.length() > 50);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_EmailFieldMustNotBeEmpty() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("email") == true) {
                    String email = (String) data.get(key);
                    assertFalse(email.isEmpty());
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_FirstNameFieldMustBeString() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("firstName") == true) {
                    assertTrue(data.get(key) instanceof String);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_FirstNameFieldMustNotBeInteger() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("firstName") == true) {
                    assertFalse(data.get(key) instanceof Integer);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_FirstNameFieldMustHaveSizeUnder25() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("firstName") == true) {
                    String field = (String) data.get(key);
                    assertTrue(field.length() < 25);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_FirstNameFieldMustNotHaveSizeOver25() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("firstName") == true) {
                    String field = (String) data.get(key);
                    assertFalse(field.length() > 25);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_FirstNameFieldMustNotBeEmpty() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("firstName") == true) {
                    String field = (String) data.get(key);
                    assertFalse(field.isEmpty());
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_LastNameFieldMustBeString() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("lastName") == true) {
                    assertTrue(data.get(key) instanceof String);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_LastNameFieldMustNotBeInteger() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("lastName") == true) {
                    assertFalse(data.get(key) instanceof Integer);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_LastNameFieldMustHaveSizeUnder50() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("lastName") == true) {
                    String field = (String) data.get(key);
                    assertTrue(field.length() < 50);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_LastNameFieldMustNotHaveSizeOver50() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("lastName") == true) {
                    String field = (String) data.get(key);
                    assertFalse(field.length() > 50);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_LastNameFieldMustNotBeEmpty() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("lastName") == true) {
                    String field = (String) data.get(key);
                    assertFalse(field.isEmpty());
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_AvatarFieldMustBeString() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("avatar") == true) {
                    assertTrue(data.get(key) instanceof String);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_AvatarFieldMustNotBeInteger() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("avatar") == true) {
                    assertFalse(data.get(key) instanceof Integer);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_AvatarFieldMustHaveSizeUnder100() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("avatar") == true) {
                    String field = (String) data.get(key);
                    assertTrue(field.length() < 100);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListUser_SingleUser_AvatarFieldMustNotHaveSizeOver100() {
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
            JSONObject data = (JSONObject) jsonOutput.get("data");

            for (Object key : data.keySet()) {
                if(key.equals("avatar") == true) {
                    String field = (String) data.get(key);
                    assertFalse(field.length() > 100);
                }
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteUser_ValidUser_StatusMustBe204() {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users/1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            assertEquals(204, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteUser_InvalidUser_StatusMustNotBe200() {
        try {
            // Creation URL Connection
            URL url = new URL("https://reqres.in/api/users/10000");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Defining Request methods and Content Type
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");

            assertNotEquals(200, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
