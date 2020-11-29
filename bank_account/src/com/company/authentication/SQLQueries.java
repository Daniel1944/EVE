package com.company.authentication;

import com.company.Constructors.RegularPayments;
import com.company.Constructors.User;
import com.company.Constructors.RegularPayments;

import java.sql.*;

public class SQLQueries {

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
        String sqlQuery = "INSERT INTO user_data (user_name, email, password, role, balance) VALUES (?,?,?,?,?)";

        try (Connection con = this.connectToDB()) {
            PreparedStatement psmt = con.prepareStatement(sqlQuery);
            psmt.setString(1, user.name);
            psmt.setString(2, user.email);
            psmt.setString(3, user.password);
            psmt.setString(4, user.role);
            psmt.setDouble(5, user.balance);
            psmt.executeUpdate();
            psmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertToTable(RegularPayments regP){
        String sqlQuery = "INSERT INTO regular_payments (id, type, amount, date) VALUES (?,?,?,?,?)";

        try (Connection con = this.connectToDB()) {
            PreparedStatement psmt = con.prepareStatement(sqlQuery);
            psmt.setInt(1,regP.id);
            psmt.setString(2,regP.type);
            psmt.setDouble(3,regP.amount);
            psmt.setString(4,regP.date);
            psmt.executeUpdate();
            psmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public User extractData() {
        String sqlQuery = "SELECT user_name, email, password, role, balance FROM user_data";
        User user = new User("", "", "", "", 0);
        try (Connection con = this.connectToDB()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            user.name = rs.getString("user_name");
            user.email = rs.getString("email");
            user.password = rs.getString("password");
            user.role = rs.getString("role");
            user.balance = rs.getInt("balance");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
    public RegularPayments extractMonthlyRevenue() {
        String sqlQuery = "SELECT user_id, amount, type, role, balance FROM monthly_revenue";
        RegularPayments regularPayments = new RegularPayments(0, 0, "", "");
        try (Connection con = this.connectToDB()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            regularPayments.id = rs.getInt("user_id");
            regularPayments.amount = rs.getDouble("amount");
            regularPayments.type = rs.getString("type");
            regularPayments.date = rs.getString("date");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return regularPayments;
    }

    public int getId() {
        String sqlQuery = "SELECT id FROM user_data";
        int id = 0;
        try (Connection con = this.connectToDB()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            id = rs.getInt("id");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return id;
    }

    public void bankFunction(String sql) {
        try (Connection con = this.connectToDB()) {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateBalance(double balance, int id) {
        String sql = "UPDATE user_data SET balance = ? "
                + "WHERE id = ?";
        try (Connection conn = this.connectToDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, balance);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
