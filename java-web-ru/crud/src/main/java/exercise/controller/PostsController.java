package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        var id = Long.parseLong(ctx.pathParam("id"));
        try {
            var post = PostRepository.find(id).orElseThrow(NotFoundResponse::new);
            var page = new PostPage(post);
            ctx.render("posts/show.jte", model("page", page));
        } catch (NotFoundResponse e) {
            ctx.status(404);
            ctx.result("Page not found");
        }
    }

    public static void index(Context ctx) {
        int page;
        if (ctx.queryParam("page") == null) {
            page = 1;
        } else {
            page = Integer.parseInt(ctx.queryParam("page"));
        }
        var posts = PostRepository.findAll(page, 5);
        var pagePosts = new PostsPage(posts, page);
        ctx.render("posts/index.jte", model("page", pagePosts));
    }
    // END
}
