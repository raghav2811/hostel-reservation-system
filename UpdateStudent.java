package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/hostel_db?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "prakash16";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentid = request.getParameter("studentid");
        response.setContentType("text/html");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT * FROM students WHERE studentid=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, studentid);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                response.getWriter().println("<form method='post' action='UpdateStudent'>");
                response.getWriter().println("ID: <input type='text' name='studentid' value='" + studentid + "' readonly><br>");
                response.getWriter().println("Name: <input type='text' name='name' value='" + resultSet.getString("name") + "'><br>");
                response.getWriter().println("Age: <input type='text' name='age' value='" + resultSet.getInt("age") + "'><br>");
                response.getWriter().println("Gender: <input type='text' name='gender' value='" + resultSet.getString("gender") + "'><br>");
                response.getWriter().println("Room Number: <input type='text' name='room_number' value='" + resultSet.getInt("room_number") + "'><br>");
                response.getWriter().println("Contact: <input type='text' name='contact' value='" + resultSet.getString("contact") + "'><br>");
                response.getWriter().println("Year: <input type='text' name='year' value='" + resultSet.getInt("year") + "'><br>");
                response.getWriter().println("<input type='submit' value='Update'>");
                response.getWriter().println("</form>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentid = request.getParameter("studentid");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        int roomNumber = Integer.parseInt(request.getParameter("room_number"));
        String contact = request.getParameter("contact");
        int year = Integer.parseInt(request.getParameter("year"));

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "UPDATE students SET name=?, age=?, gender=?, room_number=?, contact=?, year=? WHERE studentid=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, gender);
            statement.setInt(4, roomNumber);
            statement.setString(5, contact);
            statement.setInt(6, year);
            statement.setString(7, studentid);
            statement.executeUpdate();
            response.sendRedirect("ViewStudents");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
