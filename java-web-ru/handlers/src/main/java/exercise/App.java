package exercise;

import io.javalin.Javalin;

import java.util.List;

public final class App {

    public static Javalin getApp() {
        List<String> phones = Data.getPhones();
        List<String> domains = Data.getDomains();

        return Javalin.create(config -> config.bundledPlugins.enableDevLogging())
                .get("/phones", ctx -> ctx.json(phones))
                .get("/domains", ctx -> ctx.json(domains));
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
