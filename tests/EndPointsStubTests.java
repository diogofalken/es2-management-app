// Test Imports
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Types/Classes imports
import org.junit.jupiter.api.Test;
import stubs.EndPointsStub;
import types.Resource;
import types.User;

import java.util.ArrayList;

public class EndPointsStubTests {

    @Test
    public void addUser_Status201AndNewUser() {
        User user = new User(1, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");
        JSONObject finalObject = new JSONObject();

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

        // EndpointStub method
        final String stubAnswer = new EndPointsStub().addUser(user);

        assertEquals(finalObject.toJSONString(), stubAnswer);
    }

    @Test
    public void listUsers_Status200AllUsers() {

        ArrayList<User> users = new ArrayList<User>();

        // User instances
        final User user0 = new User(2, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");
        final User user1 = new User(3, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MariaLealFanboyXxX6969");
        final User user2 = new User(4, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MinecraftGajasEAlcoolXxX6969");

        // Adding the users
        users.add(user0);
        users.add(user1);
        users.add(user2);

        // JSON declarations
        JSONObject finalObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (User user : users) {
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

        // EndpointStub method
        final String stubAnswer = new EndPointsStub().listUsers();

        assertEquals(finalObject.toJSONString(), stubAnswer);

    }

    @Test
    public void listUser_Status200OneSingleUser() {
        ArrayList<User> users = new ArrayList<User>();
        JSONObject jsonObject = new JSONObject();

        // User instances
        final User user = new User(2, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // Adding the users
        users.add(user);

        // JSON declarations
        JSONObject finalObject = new JSONObject();

        jsonObject.put("Id", user.getId());
        jsonObject.put("Email", user.getEmail());
        jsonObject.put("First_Name", user.getFirstName());
        jsonObject.put("Last_Name", user.getLastName());
        jsonObject.put("Avatar", user.getAvatar());

        finalObject.put("status", 200);
        finalObject.put("data", jsonObject);

        // EndpointStub method
        final String stubAnswer = new EndPointsStub().singleUser(user.getId());

        assertEquals(finalObject.toJSONString(), stubAnswer);
    }

    @Test
    public void listUser_Status404OneSingleUser() {
        ArrayList<User> users = new ArrayList<User>();
        JSONObject jsonObject = new JSONObject();

        // User instances
        final User user = new User(5, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // Adding the users
        users.add(user);

        // JSON declarations
        JSONObject finalObject = new JSONObject();

        finalObject.put("status", 404);
        finalObject.put("data", jsonObject);

        // EndpointStub method
        final String stubAnswer = new EndPointsStub().singleUser(user.getId());

        assertEquals(finalObject.toJSONString(), stubAnswer);
    }

    @Test
    public void listResources_Status200AllResources() {
        ArrayList<Resource> resources = new ArrayList<Resource>();

        final Resource resource1 = new Resource(1, "xX69FalcaoZinhoGamer69Xx@outlook.pt",  1997, "Yellow", "lol123");
        final Resource resource2 = new Resource(2, "xX69FalcaoZinhoGamer69Xx@outlook.pt",  1997, "Yellow", "lol123");
        final Resource resource3 = new Resource(3, "xX69FalcaoZinhoGamer69Xx@outlook.pt",  1997, "Yellow", "lol123");

        resources.add(resource1);
        resources.add(resource2);
        resources.add(resource3);

        JSONArray jsonArray = new JSONArray();
        JSONObject finalObject = new JSONObject();

        for (Resource resource : resources) {
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

        // EndpointStub method
        final String stubAnswer = new EndPointsStub().listResources();

        assertEquals(finalObject.toJSONString(), stubAnswer);
    }

    @Test
    public void listResource_Status200SingleResource() {
        final Resource resource = new Resource(1, "xX69FalcaoZinhoGamer69Xx@outlook.pt",  1997, "Yellow", "lol123");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Id", resource.getId());
        jsonObject.put("Name", resource.getName());
        jsonObject.put("Year", resource.getYear());
        jsonObject.put("Color", resource.getColor());
        jsonObject.put("PantoneValue", resource.getPantoneValue());

        // Create final response object
        JSONObject finalObject = new JSONObject();
        finalObject.put("status", 200);
        finalObject.put("data", jsonObject);

        // EndpointStub method
        final String stubAnswer = new EndPointsStub().singleResource(resource.getId());

        assertEquals(finalObject.toJSONString(), stubAnswer);
    }

    @Test
    public void listResource_Status404SingleResource() {
        final Resource resource = new Resource(5, "xX69FalcaoZinhoGamer69Xx@outlook.pt",  1997, "Yellow", "lol123");

        JSONObject jsonObject = new JSONObject();

        // Create final response object
        JSONObject finalObject = new JSONObject();
        finalObject.put("status", 404);
        finalObject.put("data", jsonObject);

        // EndpointStub method
        final String stubAnswer = new EndPointsStub().singleResource(resource.getId());
        assertEquals(finalObject.toJSONString(), stubAnswer);
    }

    @Test
    public void authenticate_Status400MissingEmail_EmailIsEmpty() {
        String email = "";
        String password = "falcaozinhoptgamer";

        final String stubAnswer = new EndPointsStub().authenticate(email, password);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 400);
        jsonObject.put("error", "Missing Email");

        assertEquals(jsonObject.toJSONString(), stubAnswer);
    }

    @Test
    public void authenticate_Status400MissingEmail_PasswordIsEmpty() {
        String email = "xX69FalcaoZinhoGamer69Xx@outlook.pt";
        String password = "";

        final String stubAnswer = new EndPointsStub().authenticate(email, password);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 400);
        jsonObject.put("error", "Missing Password");

        assertEquals(jsonObject.toJSONString(), stubAnswer);
    }

    @Test
    public void authenticate_Status400WrongEmail_EmailIsWrong() {
        String email = "xX69FalcaoZinhoGamer69Xx@outlook.pt";
        String password = "cityslicka";

        final String stubAnswer = new EndPointsStub().authenticate(email, password);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 400);
        jsonObject.put("error", "User is not Valid");

        assertEquals(jsonObject.toJSONString(), stubAnswer);
    }

    @Test
    public void authenticate_Status400WrongPassword_PasswordIsWrong() {
        String email = "eve.holt@reqres.in";
        String password = "falcaozinhoptgamer";

        final String stubAnswer = new EndPointsStub().authenticate(email, password);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 400);
        jsonObject.put("error", "User is not Valid");

        assertEquals(jsonObject.toJSONString(), stubAnswer);
    }

    @Test
    public void authenticate_Status200Token_ValidUser() {
        String email = "eve.holt@reqres.in";
        String password = "cityslicka";

        final String stubAnswer = new EndPointsStub().authenticate(email, password);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        jsonObject.put("token", "QpwL5tke4Pnpja7X4");

        assertEquals(jsonObject.toJSONString(), stubAnswer);
    }

    @Test
    public void register_Status400MissingEmail_EmailIsEmpty() {
        String email = "";
        String password = "falcaozinhoptgamer";

        final String stubAnswer = new EndPointsStub().register(email, password);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 400);
        jsonObject.put("error", "Missing Email");

        assertEquals(jsonObject.toJSONString(), stubAnswer);
    }

    @Test
    public void register_Status400MissingEmail_PasswordIsEmpty() {
        String email = "xX69FalcaoZinhoGamer69Xx@outlook.pt";
        String password = "";

        final String stubAnswer = new EndPointsStub().authenticate(email, password);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 400);
        jsonObject.put("error", "Missing Password");

        assertEquals(jsonObject.toJSONString(), stubAnswer);
    }

    @Test
    public void register_Status200TokenUserIdData_ValidUser() {
        JSONObject finalObject = new JSONObject();

        String email = "eve.holt@reqres.in";
        String password = "cityslicka";

        final String stubAnswer = new EndPointsStub().register(email, password);

        JSONObject jsonObject = new JSONObject();
        finalObject.put("status", 200);
        jsonObject.put("id", 1);
        jsonObject.put("token", "QpwL5tke4Pnpja7X4");
        finalObject.put("data", jsonObject);

        assertEquals(finalObject.toJSONString(), stubAnswer);
    }

    @Test
    public void updateUser_Status200UpdatedUser() {
        // Classes instances
        final User user = new User(2, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        JSONObject finalObject = new JSONObject();

        // Transform user in object
        JSONObject userObject = new JSONObject();
        userObject.put("Id", user.getId());
        userObject.put("Email", user.getEmail());
        userObject.put("First_Name", user.getFirstName());
        userObject.put("Last_Name", user.getLastName());
        userObject.put("Avatar", user.getAvatar());

        // Create final response object
        finalObject.put("status", 200);
        finalObject.put("body", userObject);

        // EndpointStub method
        final String stubAnswer = new EndPointsStub().updateUser(user);

        assertEquals(finalObject.toJSONString(), stubAnswer);
    }

    @Test
    public void patchUser_Status200PatchedUser() {
        // Classes instances
        final User user = new User(2, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        JSONObject finalObject = new JSONObject();

        // Transform user in object
        JSONObject userObject = new JSONObject();
        userObject.put("Id", user.getId());
        userObject.put("Email", user.getEmail());
        userObject.put("First_Name", user.getFirstName());
        userObject.put("Last_Name", user.getLastName());
        userObject.put("Avatar", user.getAvatar());

        // Create final response object
        finalObject.put("status", 200);
        finalObject.put("body", userObject);

        // EndpointStub method
        final String stubAnswer = new EndPointsStub().updateUser(user);

        assertEquals(finalObject.toJSONString(), stubAnswer);
    }

    @Test
    public void deleteUser_Status204() {
        // Delete user and get response
        String response = new EndPointsStub().deleteUser(10);

        // Create the expected output
        JSONObject finalObject = new JSONObject();
        finalObject.put("status", 204);

        assertEquals(finalObject.toJSONString(), response);
    }

    @Test
    public void listUsersDelayed_Status200AllUsers() throws InterruptedException {
        ArrayList<User> users = new ArrayList<User>();

        // User instances
        final User user0 = new User(2, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");
        final User user1 = new User(3, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MariaLealFanboyXxX6969");
        final User user2 = new User(4, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MinecraftGajasEAlcoolXxX6969");

        // Adding the users
        users.add(user0);
        users.add(user1);
        users.add(user2);

        // JSON declarations
        JSONObject finalObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (User user : users) {
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

        // EndpointStub method
        final String stubAnswer = new EndPointsStub().listUsersDelayed();

        assertEquals(finalObject.toJSONString(), stubAnswer);
    }


}