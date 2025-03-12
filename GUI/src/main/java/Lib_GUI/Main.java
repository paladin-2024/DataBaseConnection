package Lib_GUI;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library_db", "root", "2006");

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a query to select all rows from the 'books' table
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");

            // Iterate through the result set and print the data
            while (rs.next()) {
                int bookId = rs.getInt("bookId"); // Retrieve bookId (int)
                String title = rs.getString("title"); // Retrieve title (String)
                String author = rs.getString("author"); // Retrieve author (String)
                String genre = rs.getString("genre"); // Retrieve genre (String)
                boolean availability = rs.getBoolean("availability"); // Retrieve availability (boolean)

                // Print the book details
                System.out.println("Book " + bookId);
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Genre: " + genre);
                System.out.println("Availability: " + (availability ? "Available" : "Not Available"));
                System.out.println("-----------------------------");
            }

            // Close the result set, statement, and connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            // Handle any SQL exceptions
            throw new RuntimeException(e);
        }
    }
}