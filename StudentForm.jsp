
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
    <link rel="stylesheet" href="Form.css">
</head>
<body>
 <div class="login-box">
        <h2>Student Registration </h2>
        <form action="SubmitStudent" method="post">
            <div class="user-box">
            <input type="text" id="studentid" name="studentid" required>
            <label for="studentid">StudentID:</label>
            </div>
          <div class="user-box">
          	<input type="text" id="name" name="name" required>
            <label for="name">Name:</label>
          </div>
          <div class="user-box">
          	<input type="number" id="age" name="age" required>
            <label for="age">Age:</label>
          </div>
          <div class="user-box">
          	<input type="text" id="gender" name="gender" required>
            <label for="gender">Gender:</label>
          </div>
          <div class="user-box">
          	<input type="number" id="roomNumber" name="roomNumber" required>
            <label for="roomNumber">Room Number:</label>
            
          </div>
          <div class="user-box">
          <input type="text" id="contact" name="contact" required>
            <label for="contact">Contact:</label>
            
          </div>
          <div class="user-box">
            <div class="user-box">
           		<input type="text" id="year" name="year" required>
                <label for="year">Year:</label>
                
            </div>
            <div >
            <button class="card-button">Submit</button>
            </div>
          </div>
        </form>
      </div>
</body>
</html>
