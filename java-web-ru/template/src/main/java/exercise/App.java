package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/users", ctx -> {
            var usersPage = new UsersPage(USERS);
            ctx.render("users/index.jte", model("page", usersPage));
        });

        app.get("/users/{id}", ctx -> {
            var id = Long.parseLong(ctx.pathParam("id"));
            var obj = USERS.stream()
                    .filter(elem -> elem.getId() == id)
                    .findFirst();

            if (obj.isPresent()) {
                UserPage userPage = new UserPage(obj.get());
                ctx.render("users/show.jte", model("page", userPage));
            } else {
                throw new NotFoundResponse("User not found");
            }
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });



        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
