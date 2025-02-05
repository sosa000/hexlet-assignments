@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    header = @`
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <svg class="bi me-2" width="40" height="32">
                    <use xlink:href="#bootstrap"></use>
                </svg>
                <span class="fs-4">Hello, Hexlet!</span>
            </a>
    
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="/" class="nav-link" aria-current="page">Home</a></li>
                <li class="nav-item"><a href="/users" class="nav-link">Users</a></li>
            </ul>
        </header>
    `,
    content = @`
        <div class="row">
            <h1 class="text-center mb-5">Users</h1>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Email</th>
                </tr>
                </thead>
                <tbody>
                @for(var elem : page.getUsers())
                    <tr>
                        <th scope="row"><a href="/users/${elem.getId()}">${elem.getId()}</a></th>
                        <td>${elem.getFirstName()}</td>
                        <td>${elem.getLastName()}</td>
                        <td>${elem.getEmail()}</td>
                    </tr>
                @endfor
                </tbody>
            </table>
        </div>
    `,
    footer = @`
        <footer class="py-3 my-4">
            <ul class="nav justify-content-center border-bottom pb-3 mb-3">
                <li class="nav-item"><a href="/" class="nav-link px-2 text-muted">Home</a></li>
                <li class="nav-item"><a href="/users" class="nav-link px-2 text-muted">Users</a></li>
            </ul>
            <p class="text-center text-muted">© 2025 Hexlet, Inc</p>
        </footer>
    `
)
