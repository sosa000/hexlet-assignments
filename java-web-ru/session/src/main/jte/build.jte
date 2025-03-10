@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage

@param LoginPage page

@template.layout.page(
    content = @`
        <h3 class="text-red">${page.getError()}</h3>
        <div class="container">
            <form action="${NamedRoutes.loginPath()}" method="post">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name" placeholder="name" value="${page.getName()}">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" placeholder="password">
                </div>
                <input type="submit" placeholder="Login" class="btn btn-primary">
            </form>
        </div>
    `
)