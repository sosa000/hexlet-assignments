@template.layout.page(
    content = @`
        <form action="/users" method="post">
            <div class="form-group">
                <label for="firstName">First name</label>
                <input type="text" id="firstName" name="firstName">
            </div>
            <div class="form-group">
                <label for="lastName">Last name</label>
                <input type="text" id="lastName" name="lastName">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email">
            </div>
            <div class="form-group">
                <label for="pswd">Password</label>
                <input type="password" id="pswd" name="password">
            </div>
            <input type="submit" value="Register">
        </form>
    `
)