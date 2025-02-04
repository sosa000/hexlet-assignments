@import exercise.dto.users.UsersPage
@param UsersPage page

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Hello Hexlet!</title>
</head>
<body>
    <div class="container">
        <div class="row text-center mt-5">
            <h1>Users</h1>
        </div>
        <div class="row">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Email</th>
                </tr>
                </thead>
                <tbody>
                @for(var elem : page.getArrUsers())
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
    </div>
</body>
</html>