package com.company.authentication;

import java.sql.*;

public class SQLQueries {

    public static class User {
        String name;
        String email;
        String password;
        String role;
        int balance;

        public User(String name, String email, String password, String role, int balance) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.role = role;
            this.balance = balance;
        }

    }

    public Connection connectToDB() {

        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:verification_data.db");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    public void insertToTable(User user) {
        String sqlQuery = "INSERT INTO user_data (user_name, email, password, role, balance) VALUES (?,?,?.?,?)";

        try (Connection con = this.connectToDB()) {
            PreparedStatement psmt = con.prepareStatement(sqlQuery);
            psmt.setString(1, user.name);
            psmt.setString(2, user.email);
            psmt.setString(3, user.password);
            psmt.setString(4, user.role);
            psmt.setInt(5, user.balance);
            psmt.executeUpdate();
            psmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User extractData() {
        String sqlQuery = "SELECT user_name, email, password FROM user_data";
        User user = null;
        try (Connection con = this.connectToDB()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                user.name = rs.getString("user_name");
                user.email = rs.getString("email");
                user.password = rs.getString("password");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }
}
