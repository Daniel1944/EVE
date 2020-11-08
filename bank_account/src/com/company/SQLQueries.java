package com.company;

import java.sql.*;
import java.util.List;

public class SQLQueries implements BasicSQLQueries{
    @Override
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
    @Override
    public void insertToTable(String name, String email, String password)   {
        String sqlQuery = "INSERT INTO user_data (user_name, email, password) VALUES (?,?,?)";

        try(Connection con = this.connectToDB()) {
            PreparedStatement psmt = con.prepareStatement(sqlQuery);
            psmt.setString(2, name);
            psmt.setString(3, email);
            psmt.setString(4, password);
            psmt.executeUpdate();
            psmt.close();
        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public String[] extractData() {
        String sqlQuery = "SELECT user_name, email, password FROM user_data";
        String[] infoArray = new String[3];
        try (Connection con = this.connectToDB()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while(rs.next()){
                infoArray[0] = rs.getString("user_name");
                infoArray[1] = rs.getString("email");
                infoArray[2] = rs.getString("password");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    return infoArray;
    }


}
