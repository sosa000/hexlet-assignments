@import gg.jte.Content
@import exercise.dto.BasePage

@param BasePage flash = null
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>HEXLET</title>
</head>
<body>
    <head>
        <div>HEXLET</div>
        @if(flash != null && flash.getFlash() != null)
            ${flash.getFlash()}
        @endif
    </head>
    @if(content != null)
        ${content}
    @endif
</body>
</html>
