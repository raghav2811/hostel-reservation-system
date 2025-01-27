package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SubmitStudent")
public class SubmitStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Database connection settings
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hostel_db?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "prakash16";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Please submit the form using POST method.</h2>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Read form fields
        String studentid= request.getParameter("studentid");
        String name = request.getParameter("name");
        String ageParam = request.getParameter("age");
        String gender = request.getParameter("gender");
        String roomNumberParam = request.getParameter("roomNumber");
        String contact = request.getParameter("contact");
        String yearP = request.getParameter("year");

        // Check for null or empty parameters
        if (studentid==null ||name == null || ageParam == null || gender == null || roomNumberParam == null || contact == null || yearP == null) {
            out.println("<h2>All fields must be filled out.</h2>");
            return;
        }

        int age;
        int roomNumber;
        int year;
        
        try {
            age = Integer.parseInt(ageParam);
            roomNumber = Integer.parseInt(roomNumberParam);
            year = Integer.parseInt(yearP);
        } catch (NumberFormatException e) {
            out.println("<h2>Invalid input for age or room number.</h2>");
            return;
        }

        // Insert student data into the database
        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // Add this line
            
            // Establish the connection
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sql = "INSERT INTO students (studentid, name, age, gender, room_number, contact, year) VALUES (?, ?, ?, ?, ?,?,?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                	statement.setString(1, studentid);
                    statement.setString(2, name);
                    statement.setInt(3, age);
                    statement.setString(4, gender);
                    statement.setInt(5, roomNumber);
                    statement.setString(6, contact);
                    statement.setInt(7, year);

                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected > 0) {
                        out.println("<h2>Student registered successfully!</h2>");
                    } else {
                        out.println("<h2>Failed to register student.</h2>");
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("<h2>MySQL JDBC Driver not found: " + e.getMessage() + "</h2>");
        } catch (SQLException e) {
            e.printStackTrace(); // This prints the detailed error message to the console
            out.println("<h2>Database error occurred: " + e.getMessage() + "</h2>"); // Shows error on the web page
        }
    }
}
