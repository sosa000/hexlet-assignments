@import  exercise.dto.users.UsersPage

@param UsersPage up

<html>
    <head>
        <title>Hello, Hexlet!</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body class="container">
            <form action="/users" method="get">
                <div class="mb-3">
                    <label class="form-label" for="firstNameInput">First name</label>
                    <input type="text" class="form-control" name="term" id="firstNameInput" value="${up.getFirstName()}">
                </div>
                <button type="submit" class="btn btn-primary" value="Search">Submit</button>
            </form>
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
                    @for(var elem : up.getListUsers())
                        <tr>
                            <th scope="row">${elem.getId()}</th>
                            <td>${elem.getFirstName()}</td>
                            <td>${elem.getLastName()}</td>
                            <td>${elem.getEmail()}</td>
                        </tr>
                    @endfor
                </tbody>
            </table>
    </body>
</html>