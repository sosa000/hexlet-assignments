<form action="/users" method="post">
    <div>
        <label for="firstName">First name</label>
        <input type="text" name="firstName" id="firstName">
    </div>
    <div>
        <label for="lastName">Last name</label>
        <input type="text" name="lastName" id="lastName">
    </div>
    <div>
        <label for="email">Email</label>
        <input required type="email" name="email" id="email">
    </div>
    <div>
        <label for="password">Password</label>
        <input required type="password" name="password" id="password">
    </div>
    <input type="submit" value="Register">
</form>