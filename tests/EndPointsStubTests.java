// Test Imports
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

// Types/Classes imports
import stubs.EndPointsStub;
import types.User;

import java.util.ArrayList;

public class EndPointsStubTests {
    @Test
   public void addUser_Status201AndNewUser() throws ParseException {
        // Classes instances
        final User user = new User(1, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // EndpointStub method
        final String stubAnswer = new EndPointsStub().addUser(user);

        assertEquals("{\"body\":{\"First_Name\":\"Diogo\",\"Email\":\"xX69FalcaoZinhoGamer69Xx@outlook.pt\",\"Last_Name\":\"Falcao\",\"Id\":1,\"Avatar\":\"TiagovskiCoolXxX6969\"},\"status\":201}", stubAnswer);
    }

    @Test
    public void listUsers_Status200AllUsers() throws ParseException {
        // JSON declarations
        JSONObject finalObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        // Users Arraylist
        ArrayList<User> users = new ArrayList<User>();

        // Classes instances
        final User user0 = new User(2, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");
        final User user1 = new User(3, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MariaLealFanboyXxX6969");
        final User user2 = new User(4, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MinecraftGajasEAlcoolXxX6969");

        // Adding the users
        users.add(user0);
        users.add(user1);
        users.add(user2);

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

        System.out.println(finalObject);

        // EndpointStub method
        final String stubAnswer = new EndPointsStub().listUsers();

        // Parsing string to object
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(stubAnswer);

        assertEquals(finalObject, stubAnswer);

    }
}