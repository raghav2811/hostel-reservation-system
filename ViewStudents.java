package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewStudents")
public class ViewStudents extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection settings
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hostel_db?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "prakash16";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve sorting choice from the request parameters
        String sortBy = request.getParameter("sortBy"); // Sorting field
        String sortOrder = request.getParameter("sortOrder"); // Sorting order

        // Set default sorting values if parameters are not provided
        if (sortBy == null || sortBy.isEmpty()) {
            sortBy = "name"; // Default sort by name
        }
        if (sortOrder == null || sortOrder.isEmpty()) {
            sortOrder = "ASC"; // Default sort order
        }

        List<Student> students = new ArrayList<>();

        // Database query to retrieve student records
        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                // Construct the SQL query with dynamic sorting
                String sql = "SELECT * FROM students ORDER BY " + sortBy + " " + sortOrder;

                // Prepare and execute the SQL statement
                try (PreparedStatement statement = connection.prepareStatement(sql);
                     ResultSet resultSet = statement.executeQuery()) {

                    // Process the result set and add each student to the list
                    while (resultSet.next()) {
                        Student student = new Student(
                            resultSet.getString("studentid"),
                            resultSet.getString("name"),
                            resultSet.getInt("age"),
                            resultSet.getString("gender"),
                            resultSet.getInt("room_number"),
                            resultSet.getString("contact"),
                            resultSet.getInt("year")
                        );
                        students.add(student);
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "MySQL JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error occurred: " + e.getMessage());
        }

        // Set the students list as a request attribute
        request.setAttribute("students", students);

        // Forward the request to StudentDetails.jsp to display the results
        RequestDispatcher dispatcher = request.getRequestDispatcher("StudentDetails.jsp");
        dispatcher.forward(request, response);
    }
}
