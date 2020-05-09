import static org.junit.Assert.assertEquals;

import org.junit.Test;

import stubs.EndPointsStub;
import types.User;

public class EndPointsStubTests {
    @Test
   public void addUser_UserContainsAllFields_Status201AndNewUser() {
        final EndPointsStub endPointsStub = new EndPointsStub();

        final User user = new User(1, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        final String stubAnswer = endPointsStub.addUser(user);

        System.out.println(stubAnswer);
    }
}