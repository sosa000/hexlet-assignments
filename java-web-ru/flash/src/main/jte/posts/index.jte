@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes

@param PostsPage page

@template.layout.page(
    content = @`
        <div class="container">
            @if(page.getFlash() != null)
                <div class="alert alert-success" role="alert">
                    ${page.getFlash()}
                </div>
            @endif
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Body</th>
                </tr>
                </thead>
                <tbody>
                @for(var elem : page.getPosts())
                    <tr>
                        <th><a href="${NamedRoutes.postPath(elem.getId())}">${elem.getId()}</a></th>
                        <td>${elem.getName()}</td>
                        <td>${elem.getBody()}</td>
                    </tr>
                @endfor
                </tbody>
            </table>
        </div>
    `
)