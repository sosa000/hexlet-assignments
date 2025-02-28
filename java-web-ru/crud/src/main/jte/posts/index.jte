@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes

@param PostsPage page

@template.layout.page(
    content = @`
        <div class="col">
            <h1 class="m-5 text-center">All posts</h1>
            <div class="mb-3">
                <table class="table">
                    <thead class="text-center">
                    <tr>
                        <th scope="col">Name</th>
                    </tr>
                    </thead>
                    <tbody class="text-center">
                    @for(var elem : page.getPosts())
                        <tr>
                            <td><a href="${NamedRoutes.postPath(elem.getId())}">${elem.getName()}</a></td>
                        </tr>
                    @endfor
                    </tbody>
                </table>
            </div>
            <div class="col">
                <nav aria-label="...">
                    <ul class="pagination justify-content-center">
                        <li class="page-item
                        @if(page.getPage() <= 1)
                            disabled
                        @endif">
                            <a class="page-link" href="${NamedRoutes.postsPath(page.getPage() - 1)}">Previous</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="${NamedRoutes.postsPath(page.getPage() + 1)}">Next</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    `
)