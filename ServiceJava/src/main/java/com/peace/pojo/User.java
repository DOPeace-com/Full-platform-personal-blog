package com.peace.pojo;

public class User {
    private String user_id;
    private String user_name;
    private String user_password;
    private String user_phonenum;
    private String user_remember;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_phonenum() {
        return user_phonenum;
    }

    public void setUser_phonenum(String user_phonenum) {
        this.user_phonenum = user_phonenum;
    }

    public String getUser_remember() {
        return user_remember;
    }

    public void setUser_remember(String user_remember) {
        this.user_remember = user_remember;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_phonenum='" + user_phonenum + '\'' +
                ", user_remember='" + user_remember + '\'' +
                '}';
    }
}
