package com.wallfacerrzd.blog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

/**
 * @author
 * @date
 */
public class Article {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + path + " " + time;
    }

    private String name;
    private String path;
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Timestamp time;
}
