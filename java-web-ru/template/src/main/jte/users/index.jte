@import exercise.dto.users.UsersPage
@param UsersPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Users</title>
</head>
<body>
<div class="mx-auto p-4 py-md-5">
    <div class="container">
        <h1 class="text-center">Пользователи</h1>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Имя</th>
                    <th scope="col">Фамилия</th>
                </tr>
            </thead>
            <tbody>
            @for(var user : page.getListUsers())
                <tr>
                    <td scope="row"><a href="/users/${user.getId()}">${user.getId()}</a></td>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getLastName()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    </div>
</div>
</body>
</html>