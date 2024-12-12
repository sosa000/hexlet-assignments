@import exercise.dto.users.UserPage

@param UserPage page

@template.layout.page(
    user = @`
    <div class="card">
        <h1>User: ${page.getUser().getId()}</h1>
        <div class="card-body p-0">
            <h5 class="card-title">${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h5>
            <p class="card-text">Email: ${page.getUser().getEmail()}</p>
        </div>
    </div>
    `
)