<html>
<head>
<link rel="stylesheet" href="style.css">
<head>
<body>
    <form action="RegisterServlet" method="get">
        <div class="container">
          <h1>Register</h1>
          <p>Please fill in this form to register.</p>
          <hr>

          <label for="name"><b>Student name</b></label>
          <input type="text" placeholder="Enter name" name="name" id="name" required>

          <label for="id"><b>Student ID</b></label>
          <input type="text" placeholder="Enter your ID" name="id" id="id" required>

          <label for="psw"><b>Password</b></label>
          <input type="password" placeholder="Enter Password" name="psw" id="psw" required>

          <label for="gender"><b>Gender</b></label>
          <div class="gender">
            <input type="radio" name="Gender" value="Male" />
            Male
            <input type="radio" name="Gender" value="Female" />
            Female
            </div>
          <label for="ph"><b>Mobile</b></label>
          <input type="text" name="MobileNumber" maxlength="10" placeholder="7842xxxxxx"/>

          <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
          <button type="submit" class="rbtn">Register</button>
        </form>
          <form action="DisplayServlet" method="get">
            <button type="submit" class="rbtn d">Display Registered Students</button>
          </form>
        </div>



</body>
</html>
