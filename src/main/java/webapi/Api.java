package webapi;

import org.joda.time.LocalTime;
import io.javalin.Javalin;

public class Api {

    public static final String version = System.getenv("VERSION");

    public static void main (String[] args) {
        System.out.println("Hello World!");

        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        Javalin.create()
            .get("/api/v1/ping", ctx -> ctx.result("pong"))
            .get("/api/v1/version", ctx -> ctx.result(version))
            .start(3000);
    }
}