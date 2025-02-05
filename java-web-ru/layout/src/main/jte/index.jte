@template.layout.page(
    header = @`
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
            <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
            <span class="fs-4">Hello, Hexlet!</span>
        </a>

        <ul class="nav nav-pills">
            <li class="nav-item"><a href="/" class="nav-link" aria-current="page">Home</a></li>
            <li class="nav-item"><a href="/users" class="nav-link">Users</a></li>
        </ul>
    </header>
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