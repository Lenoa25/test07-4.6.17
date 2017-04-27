package com.company;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        try (Connection conn = DB.getConnection()) {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO NOAUSRES(USERNAME,USERPASSWORD) VALUES(?,?)");
            statement.setString(1, userName);
            statement.setString(2, password);
            int resultSet = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        try (Connection conn = DB.getConnection()) {
            PreparedStatement statement = conn.prepareStatement("UPDATE NOAUSRES SET USERNAME=? WHERE USERNAME=?");
                statement.setString(1, userName);
                statement.setString(2, this.userName);
            int resultSet = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try (Connection conn = DB.getConnection()) {
            PreparedStatement statement = conn.prepareStatement("UPDATE NOAUSRES SET USERPASSWORD=? WHERE USERPASSWORD=?");
            statement.setString(1, password);
            statement.setString(2, this.password);
            int resultSet = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.password = password;
    }
}
