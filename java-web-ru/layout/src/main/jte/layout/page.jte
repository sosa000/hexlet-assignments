@import gg.jte.Content
@param Content header
@param Content content = null
@param Content footer

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Hello, Hexlet!</title>
</head>
<body>
    <div class="container">
        ${header}
        @if(content != null)
            ${content}
        @else
            <div class="row-5 m-5 align-items-center">
                <h1 class="text-center">Hello this is Hexlet.<br>This is exercise for learn layout</h1>
            </div>
        @endif
        ${footer}
    </div>
</body>
</html>