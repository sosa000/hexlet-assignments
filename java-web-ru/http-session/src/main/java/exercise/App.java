package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/users", ctx -> {
            if (ctx.queryString() == null) {
                ctx.json(USERS.subList(0, 5));
            } else {
                int j = Integer.parseInt(ctx.queryParam("page")) * Integer.parseInt(ctx.queryParam("per"));
                int i = j - Integer.parseInt(ctx.queryParam("per"));


                ctx.json(USERS.subList(i, j));
            }
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
