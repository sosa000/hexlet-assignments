package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            if (ctx.queryParamMap().size() == 0) {
                ctx.json(USERS.subList(0, 5));
            } else {
                var last = (Integer.parseInt(ctx.queryParam("page")) * Integer.parseInt(ctx.queryParam("per")));
                var start = last - Integer.parseInt(ctx.queryParam("per"));
                ctx.json(USERS.subList(start, last));
            }
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
