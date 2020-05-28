package service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import types.Account;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationServiceTesting {

    @Test
    public void testLogin_CorrectEmailPassword_StatusMustBe200() {
        Account account = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(200, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testLogin_WrongEmailValidPassword_StatusMustBe400() {
        Account account = new Account("eve.holtd@reqres.in", "pistol");

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

            assertEquals(400, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testLogin_WrongEmailWrongPassword_StatusMustBe400() {
        Account account = new Account("eve.holtd@rdeqres.in", "pdistol");

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

            assertEquals(400, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testLogin_MissingEmailValidPassword_StatusMustBe400() {
        Account account = new Account("", "pistol");

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

            assertEquals(400, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testLogin_ValidEmailMissingPassword_StatusMustBe400() {
        Account account = new Account("eve.holtd@reqres.in", "");

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

            assertEquals(400, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testLogin_MissingEmailMissingPassword_StatusMustBe400() {
        Account account = new Account("", "");

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

            assertEquals(400, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testLogin_CorrectEmailPassword_ContentTypeMustBeJson() {
        Account account = new Account("eve.holtd@reqres.in", "pistol");

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

            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testLogin_CorrectEmailPassword_TokenFieldMustBeString() {
        Account account = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());

            for (Object key : jsonObject.keySet()) {
                if(key.equals("token") == true) {
                    assertTrue(jsonObject.get(key) instanceof String );
                }
            }

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testLogin_CorrectEmailPassword_TokenFieldMustNotBeLong() {
        Account account = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());

            for (Object key : jsonObject.keySet()) {
                if(key.equals("token") == true) {
                    assertFalse(jsonObject.get(key) instanceof Long );
                }
            }


            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testLogin_CorrectEmailPassword_TokenFieldMustOnlyContainNumbersAndLetters() {
        Account account = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());

            assertTrue(jsonOutput.get("token").toString().matches("[a-zA-Z0-9]*") );

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testLogin_CorrectEmailPassword_TokenFieldMustNotBeEmpty() {
        Account account = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());

            assertFalse(jsonOutput.get("token").toString().isEmpty() );

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_CorrectEmailPassword_StatusMustBe200() {
        Account account = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(200, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_WrongEmailValidPassword_StatusMustBe400() {
        Account account = new Account("eve.holdt@reqres.in", "pistol");

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

            assertEquals(400, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_WrongEmailWrongPassword_StatusMustBe400() {
        Account account = new Account("eve.holt@rdeqres.in", "pidstol");

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

            assertEquals(400, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_MissingEmailValidPassword_StatusMustBe400() {
        Account account = new Account("", "pistol");

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

            assertEquals(400, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_ValidEmailMissingPassword_StatusMustBe400() {
        Account account = new Account("eve.holt@reqres.in", "");

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

            assertEquals(400, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_MissingEmailMissingPassword_StatusMustBe400() {
        Account account = new Account("", "");

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

            assertEquals(400, connection.getResponseCode());

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_CorrectEmailPassword_ContentTypeMustBeJson() {
        Account account = new Account("eve.holtd@reqres.in", "pistol");

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

            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_CorrectEmailPassword_IdFieldMustBeLong() {
        Account account = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());

            assertTrue(jsonOutput.get("id") instanceof Long );

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_CorrectEmailPassword_IdFieldMustNotBeString() {
        Account account = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());

            assertFalse(jsonOutput.get("id") instanceof String );

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_CorrectEmailPassword_IdFieldMustBeHigherThanZero() {
        Account account = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());

            assertTrue(Integer.parseInt(String.valueOf(jsonOutput.get("id"))) > 0 );

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_CorrectEmailPassword_IdFieldMustOnlyContainNumbers() {
        Account account = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());

            assertTrue(jsonOutput.get("id").toString().matches("[0-9]+"));

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_CorrectEmailPassword_IdFieldMustNotBeEmpty() {
        Account account = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());

            assertFalse(jsonOutput.get("id").toString().isEmpty());

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_CorrectEmailPassword_TokenFieldMustBeString() {
        Account account = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());

            for (Object key : jsonObject.keySet()) {
                if(key.equals("token") == true) {
                    assertTrue(jsonObject.get(key) instanceof String );
                }
            }

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_CorrectEmailPassword_TokenFieldMustNotBeLong() {
        Account account = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());

            for (Object key : jsonObject.keySet()) {
                if(key.equals("token") == true) {
                    assertFalse(jsonObject.get(key) instanceof Long );
                }
            }


            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_CorrectEmailPassword_TokenFieldMustOnlyContainNumbersAndLetters() {
        Account account = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());

            assertTrue(jsonOutput.get("token").toString().matches("[a-zA-Z0-9]*") );

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

    @Test
    public void testRegister_CorrectEmailPassword_TokenFieldMustNotBeEmpty() {
        Account account = new Account("eve.holt@reqres.in", "pistol");

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

            assertEquals(200, connection.getResponseCode());
            assertEquals("application/json; charset=utf-8", connection.getHeaderField("content-type"));

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonOutput = (JSONObject) jsonParser.parse(result.toString());

            assertFalse(jsonOutput.get("token").toString().isEmpty() );

            connection.disconnect();
        } catch (Exception error) {
            throw new Error(error);
        }
    }

}
