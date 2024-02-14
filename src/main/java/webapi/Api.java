package webapi;

import org.joda.time.LocalTime;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.Javalin;
import model.User;

import java.util.List;
import java.util.Arrays;

public class Api {

    public static final String version = System.getenv("VERSION");
    public static final List<User> users = Arrays.asList(
        new User(1, "Bernhard"),
        new User(2, "Susi"),
        new User(3, "Markus"),
        new User(4, "Cynthia")
    );

    public static void main (String[] args) {
        System.out.println("Hello World!");

        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        Javalin.create()
            .get("/api/v1/ping", ctx -> ctx.result("pong"))
            .get("/api/v1/version", ctx -> ctx.result(version))
            .get("/api/v1/users", ctx -> {               
                System.out.println("Users endpoint invoked: returning " + users.size() + " users");

                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(users);
                ctx.result(json).contentType("application/json");
            })
            .start(3000);
    }
}