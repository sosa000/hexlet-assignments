package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        if (ctx.sessionAttribute("name") != null) {
            var page = new MainPage(ctx.sessionAttribute("name"));
            ctx.render("index.jte", model("page", page));
        } else {
            var page = new MainPage(null);
            ctx.render("index.jte", model("page", page));
        }
    }

    public static void build(Context ctx) {
        var page = new LoginPage("", "");
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParamAsClass("name", String.class).get();
        try {
            var user = UsersRepository.findByName(name).orElseThrow(() -> new Exception("Wrong username or password"));
            var password = ctx.formParam("password");

            if (user.getPassword().equals(encrypt(password))) {
                ctx.sessionAttribute("name", name);
                ctx.contentType("text/html; charset=UTF-8");
                ctx.redirect("/");
            } else {
                throw new Exception("Wrong username or password");
            }
        } catch (Exception e) {
            var page = new LoginPage(name, e.getMessage());
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("name", null);
        ctx.redirect("/");
    }
    // END
}
