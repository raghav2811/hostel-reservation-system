package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/ViewStudentsServlet")
public class ViewStudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Database connection settings
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hostel_db?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "prakash16";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sortBy = request.getParameter("sortBy"); // Sorting field
        String sortOrder = request.getParameter("sortOrder"); // Sorting order

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
                String sql = "SELECT * FROM students ORDER BY " + sortBy + " " + sortOrder;
                
                try (PreparedStatement statement = connection.prepareStatement(sql);
                     ResultSet resultSet = statement.executeQuery()) {
                    
                    // Process the result set
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
            System.out.println("Number of students: " + students.size());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "MySQL JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error occurred: " + e.getMessage());
        }

        // Set the students list as a request attribute
        request.setAttribute("students", students);

        // Forward to the JSP page to display the results
        RequestDispatcher dispatcher = request.getRequestDispatcher("StudentDetails.jsp");
        dispatcher.forward(request, response);
    }
    
}
