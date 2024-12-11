@import exercise.dto.users.UserPage
@param UserPage page

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
    <div class="container">
        <h1 class="text-center">Пользователь: ${page.getUser().getId()}</h1>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h5>
                <h4 class="card-text">Почта: ${page.getUser().getEmail()}</h4>
                <p class="card-text">Какой то хуесос. Я его не знаю и вам не советую с ним связываться</p>
            </div>
        </div>
    </div>
</body>
</html>