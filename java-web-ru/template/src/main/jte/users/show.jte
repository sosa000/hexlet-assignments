@import exercise.dto.users.UserPage
@param UserPage page

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
<div class="container mt-5">
    @if(page.getUser() != null)
        <div class="row text-center"><h1>User id: ${page.getUser().getId()}</h1></div>
        <div class="row text-left">
            <span>First name: ${page.getUser().getFirstName()}</span>
            <span>Last name: ${page.getUser().getLastName()}</span>
            <span>Email: ${page.getUser().getEmail()}</span>
        </div>
    @endif
</div>
</body>
</html>