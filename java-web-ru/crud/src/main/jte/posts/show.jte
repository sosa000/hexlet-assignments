@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes

@param PostPage page

@template.layout.page(
    content = @`
        <h1 class="text-center">Info about post</h1>
        <div class="col-1 m-5 justify-content-center">
            <h2>${page.getPost().getId()}</h2>
            <h3>${page.getPost().getName()}</h3>
            <h4>${page.getPost().getBody()}</h4>
            <form action="${NamedRoutes.postsPath()}" method="get">
                <input type="submit" value="back!">
            </form>
        </div>
    `
)