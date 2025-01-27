<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Student" %>

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="Form.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Details</title>
    
</head>
<body>
   <div class="box" style="
    position: absolute;
    top: 50%;
    left:50%;
    width: auto;
    padding: 40px;
    height:auto;
    transform: translate(-50%, -50%);
    background: grey !important;
    box-sizing: border-box;
    box-shadow: 0 15px 25px rgba(0,0,0,.6);
    border-radius: 10px;">
    <h1>Student Details</h1>

    <!-- Sorting Form -->
    <form action="ViewStudents" method="get">
        <label for="sortBy">Sort By:</label>
        <select name="sortBy" id="sortBy">
            <option value="studentid">ID</option>
            <option value="name">Name</option>
            <option value="age">Age</option>
            <option value="gender">Gender</option>
            <option value="room_number">Room Number</option>
        </select>

        <label for="sortOrder">Sort Order:</label>
        <select name="sortOrder" id="sortOrder">
            <option value="ASC">Ascending</option>
            <option value="DESC">Descending</option>
        </select>

        <button type="submit">Sort Students</button>
    </form>
	 <br><br>
    <!-- Student Details Table -->
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");
        if (students == null || students.isEmpty()) {
    %>
    
        <p>No student data available.</p>
    <%
        } else {
    %>
        <table border="1">
            <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Room Number</th>
                    <th>Contact</th>
                    <th>Year</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                for (Student student : students) {
                %>
                    <tr>
                        <td><%= student.getStudentId() %></td>
                        <td><%= student.getName() %></td>
                        <td><%= student.getAge() %></td>
                        <td><%= student.getGender() %></td>
                        <td><%= student.getRoomNumber() %></td>
                        <td><%= student.getContact() %></td>
                        <td><%= student.getYear() %></td>
                        <td>
                            <a href="UpdateStudent?studentid=<%= student.getStudentId() %>">Update</a> | 
                            <a href="DeleteStudent?studentid=<%= student.getStudentId() %>" onclick="return confirm('Are you sure?');">Delete</a>
                        </td>
                    </tr>
                <%
                }
                %>
            </tbody>
        </table>
    <%
        }
    %>
   </div>
</body>
</html>
