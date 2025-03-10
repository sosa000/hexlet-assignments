@import exercise.dto.MainPage
@import exercise.util.NamedRoutes

@param MainPage page

@template.layout.page(
    content = @`
        @if(page.getName() == null)
            <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
        @else
            <h1>${page.getName().toString()}</h1>
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <input type="submit" value="Выйти">
            </form>
        @endif
    `
)