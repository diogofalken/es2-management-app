package main.java;

import cache.Users;
import interfaces.RestApiMethods;
import org.json.simple.parser.ParseException;
import stubs.UsersStub;
import types.User;

public class Main {
    public static void main(String[] args) throws ParseException {
        User user = new User(1, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        RestApiMethods endPointsMethods = new UsersStub();

        Users users = new Users(endPointsMethods);

        users.addUser(user);
    }
}
