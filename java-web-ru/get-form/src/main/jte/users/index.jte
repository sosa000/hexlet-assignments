@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <div class="container">
            <div class="row m-5">
                <h1 class="text-center m-5">Search</h1>
                <form action="/users" method="get">
                    <label for="term">First name:</label>
                    <input type="search" name="term" id="term" value="${page.getTerm()}">
                </form>
            </div>
            <div class="row m-5">
                <h1 class="text-center">Users:</h1>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">First name</th>
                        <th scope="col">Last name</th>
                        <th scope="col">Email</th>
                    </tr>
                    </thead>
                    <tbody>
                    @for(var elem : page.getUsers())
                        <tr>
                            <th scope="row">${elem.getId()}</th>
                            <td>${elem.getFirstName()}</td>
                            <td>${elem.getLastName()}</td>
                            <td>${elem.getEmail()}</td>
                        </tr>
                    @endfor
                    </tbody>
                </table>
            </div>
        </div>
    `
)