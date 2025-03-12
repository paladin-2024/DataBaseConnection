package Lib_GUI;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library_db", "root", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println(rs.getString("user_name"));
                System.out.println(rs.getString("user_password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
