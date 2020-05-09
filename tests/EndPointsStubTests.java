import static org.junit.Assert.assertEquals;

import org.junit.Test;

import stubs.EndPointsStub;
import types.User;

import java.util.HashMap;

public class EndPointsStubTests {
    @Test
   public void addUser_Status201AndNewUser() {
        final EndPointsStub endPointsStub = new EndPointsStub();

        final User user = new User(1, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        final String stubAnswer = endPointsStub.addUser(user);

        System.out.println(stubAnswer);

        assertEquals("{\"body\":{\"First_Name\":\"Diogo\",\"Email\":\"xX69FalcaoZinhoGamer69Xx@outlook.pt\",\"Last_Name\":\"Falcao\",\"Id\":1,\"Avatar\":\"TiagovskiCoolXxX6969\"},\"status\":201}", stubAnswer);
    }
}