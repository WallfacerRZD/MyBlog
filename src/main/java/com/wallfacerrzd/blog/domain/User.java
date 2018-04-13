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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    private String userName;

    private String password;

    private boolean isAdmin;



    @Override
    public String toString() {
        return userName + " " + password + " " + isAdmin;
    }
}
