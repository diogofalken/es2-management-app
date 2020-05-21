package main.java;

import middlewares.UsersMiddleware;
import org.json.simple.parser.ParseException;
import types.User;

public class Main {
    public static void main(String[] args) throws ParseException {
        User user = new User("xxxdiogofalcaogamerpt69xxx@yahoo.com.br", "Diogo", "Falcão", "A21");
        UsersMiddleware usersMiddleware = new UsersMiddleware();
        System.out.println(usersMiddleware.getUsers());


    }
}
