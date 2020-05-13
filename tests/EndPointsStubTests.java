// Test Imports
import org.json.simple.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Types/Classes imports
import org.junit.jupiter.api.Test;
import stubs.UsersStub;

public class EndPointsStubTests {

    @Test
    public void addUser_Status201AndNewUser() {

    }

    @Test
    public void listUsers_Status200AllUsers() {

    }

    @Test
    public void listUser_Status200OneSingleUser() {

    }

    @Test
    public void listUser_Status404OneSingleUser() {
    }

    @Test
    public void listResources_Status200AllResources() {
    }

    @Test
    public void listResource_Status200SingleResource() {

    }

    @Test
    public void listResource_Status404SingleResource() {

    }

    @Test
    public void authenticate_Status400MissingEmail_EmailIsEmpty() {

    }

    @Test
    public void authenticate_Status400MissingEmail_PasswordIsEmpty() {

    }

    @Test
    public void authenticate_Status400WrongEmail_EmailIsWrong() {

    }

    @Test
    public void authenticate_Status400WrongPassword_PasswordIsWrong() {

    }

    @Test
    public void authenticate_Status200Token_ValidUser() {

    }

    @Test
    public void register_Status400MissingEmail_EmailIsEmpty() {

    }

    @Test
    public void register_Status400MissingEmail_PasswordIsEmpty() {

    }

    @Test
    public void register_Status400EmailNotFound_EmailNotOnUsers() {

    }

    @Test
    public void register_Status200TokenUserIdData_ValidUser() {
        JSONObject finalObject = new JSONObject();

        String email = "eve.holt@reqres.in";
        String password = "cityslicka";

        final String stubAnswer = new UsersStub().register(email, password);

        JSONObject jsonObject = new JSONObject();
        finalObject.put("status", 200);
        jsonObject.put("id", 1);
        jsonObject.put("token", "QpwL5tke4Pnpja7X4");
        finalObject.put("data", jsonObject);

        assertEquals(finalObject.toJSONString(), stubAnswer);
    }


}