package com.wallfacerrzd.blog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

/**
 * @author WallfacerRZD
 * @date 2018/5/23 19:56
 */
public class Comment {
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String content;
    private int id;
    private String user;
}
