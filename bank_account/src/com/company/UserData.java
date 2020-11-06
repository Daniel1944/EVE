package com.company;

public class UserData {
    int userId;
    String userName;
    String userEmail;
    String userPassword;

    UserData(int id, String name, String email, String password){
        userId = id;
        userName = name;
        userEmail = email;
        userPassword = password;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
