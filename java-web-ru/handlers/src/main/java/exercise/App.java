package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        return Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        })
                .get("/phones", ctx -> ctx.json(Data.getPhones()))
                .get("/domains", ctx -> ctx.json(Data.getDomains()));
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
