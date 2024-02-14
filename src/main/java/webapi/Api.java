package webapi;

import org.joda.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.Javalin;
import model.User;

import java.util.List;
import java.util.Arrays;

public class Api {

    private static Logger logger = LoggerFactory.getLogger(Api.class); 
    private static final String version = System.getenv("VERSION");
    private static final List<User> users = Arrays.asList(
        new User(1, "Bernhard"),
        new User(2, "Susi"),
        new User(3, "Markus"),
        new User(4, "Cynthia")
    );

    public static void main (String[] args) {
        logger.info("Hello World!");

        LocalTime currentTime = new LocalTime();
        logger.info("The current local time is: {}", currentTime);

        Javalin.create()
            .get("/api/v1/ping", ctx -> ctx.result("pong"))
            .get("/api/v1/version", ctx -> ctx.result(version))
            .get("/api/v1/users", ctx -> {               
                logger.info("Users endpoint invoked: returning {} users", users.size());

                ObjectMapper mapper = new ObjectMapper();
                String json = mapper.writeValueAsString(users);
                ctx.result(json).contentType("application/json");
            })
            .start(3000);
    }
}