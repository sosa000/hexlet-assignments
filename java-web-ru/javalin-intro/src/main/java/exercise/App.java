package exercise;

// BEGIN

// END

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {
        var app = Javalin.create()
                .get("/welcome", ctx -> ctx.result("Welcome to Hexlet!"))
                .start(7070);

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
