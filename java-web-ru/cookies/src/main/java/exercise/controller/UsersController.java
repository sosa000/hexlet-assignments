package exercise.controller;

import io.javalin.http.HttpStatus;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        var firstName = ctx.formParamAsClass("firstName", String.class).get();
        var lastName = ctx.formParamAsClass("lastName", String.class).get();
        var email = ctx.formParamAsClass("email", String.class).get();
        var password = ctx.formParamAsClass("password", String.class).get();

        var token = Security.generateToken();
        var user = new User(firstName, lastName, email, Security.encrypt(password), token);
        UserRepository.save(user);
        ctx.cookie("key", token);
        ctx.redirect("/users/" + user.getId());
    }

    public static void show(Context ctx) {
        var key = ctx.cookie("key");
        var id = ctx.pathParam("id");

        try {
            var user = UserRepository.find(Long.parseLong(id)).get();
            if (!user.getToken().equals(key)) {
                throw new NotFoundResponse("Not found person");
            }

            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        } catch (NotFoundResponse e) {
            ctx.redirect("/users/build");
        }

    }
    // END
}
