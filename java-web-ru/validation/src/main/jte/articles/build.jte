@import exercise.dto.articles.BuildArticlePage

@param BuildArticlePage page

<form action="/articles" method="post">
    <div>
        <label for="title">Title</label>
        <input type="text" name="title" id="title" value="${page.getTitle()}">
    </div>
    <div>
        <label for="content">Content</label>
        <textarea name="content" id="content">${page.getContent()}</textarea>
    </div>
    <input type="submit" value="Create">
</form>

@if(page.getErrors() != null)
    @for(var validator : page.getErrors().values())
        @for(var elem : validator)
            <h2>${elem.getMessage()}</h2>
        @endfor
    @endfor
@endif