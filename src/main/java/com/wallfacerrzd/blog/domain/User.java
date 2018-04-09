package com.wallfacerrzd.blog.domain;

/**
 * @author
 * @date
 */
public class User {

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String userName;

    private String password;

    @Override
    public String toString() {
        return userName + " " + password;
    }
}
