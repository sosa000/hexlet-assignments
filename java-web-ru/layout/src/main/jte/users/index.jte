@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(
    users = @`
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">First name</th>
            <th scope="col">Last name</th>
        </tr>
        </thead>
        <tbody>
            @for(var elem : page.getUsers())
            <tr>
                <th scope="row"><a href="users/${elem.getId()}">${elem.getId()}</a></th>
                <td>${elem.getFirstName()}</td>
                <td>${elem.getLastName()}</td>
            </tr>
            @endfor
        </tbody>
    </table>
    `
)

