@import gg.jte.Content

@param Content index = null
@param Content users = null
@param Content user = null

<html>
<head>
    <title>Hexlet</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="container">
    <div class="row h-10">
        <header class="col d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
            <div class="icon m-1 p-2">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cookie" viewBox="0 0 16 16">
                    <path d="M6 7.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0Zm4.5.5a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3Zm-.5 3.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0Z"/>
                    <path d="M8 0a7.963 7.963 0 0 0-4.075 1.114c-.162.067-.31.162-.437.28A8 8 0 1 0 8 0Zm3.25 14.201a1.5 1.5 0 0 0-2.13.71A7.014 7.014 0 0 1 8 15a6.967 6.967 0 0 1-3.845-1.15 1.5 1.5 0 1 0-2.005-2.005A6.967 6.967 0 0 1 1 8c0-1.953.8-3.719 2.09-4.989a1.5 1.5 0 1 0 2.469-1.574A6.985 6.985 0 0 1 8 1c1.42 0 2.742.423 3.845 1.15a1.5 1.5 0 1 0 2.005 2.005A6.967 6.967 0 0 1 15 8c0 .596-.074 1.174-.214 1.727a1.5 1.5 0 1 0-1.025 2.25 7.033 7.033 0 0 1-2.51 2.224Z"/>
                </svg>
            </div>
            <h1 class="fs-4 m-0 p-1">Hexlet</h1>
            <ul class="nav nav-pills">
                <li class="nav-item">
                    <a href="/" class="nav-link">Home</a>
                </li>
                <li class="nav-item">
                    <a href="/users" class="nav-link">All users</a>
                </li>
            </ul>
        </header>
    </div>
    <main>
        <div class="row h-80">
            @if(users != null)
                ${users}
            @endif

            @if(user != null)
                ${user}
            @endif

            @if(index != null)
                ${index}
            @endif
        </div>
    </main>
    <div class="row">
        <footer class="col py-3 my-4">
            <ul class="nav justify-content-center border-bottom pb-3 mb-3">
                <li class="nav-item">
                    <a href="/" class="nav-link px-2 text-muted">Home</a>
                </li>
                <li class="nav-item">
                    <a href="/users" class="nav-link px-2 text-muted">All users</a>
                </li>
                <p class="text-center text-muted m-0 p-2">2024 Hexlet, Inc</p>
            </ul>
        </footer>
    </div>
</body>
</html>