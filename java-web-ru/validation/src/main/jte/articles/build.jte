@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
    content = @`
        @if(page.getErrors() != null)
            <ul>
                @for(var validator : page.getErrors().values())
                    @for(var elem : validator)
                        <li class="text-danger">${elem.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        @endif
        <form action="/articles" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" id="title" name="title" value="${page.getTitle()}">
            </div>
            <div class="form-group">
                <label for="content">Content</label>
                <textarea id="content" name="content">${page.getContent()}</textarea>
            </div>
            <input type="submit" value="Add">
        </form>
    `
)