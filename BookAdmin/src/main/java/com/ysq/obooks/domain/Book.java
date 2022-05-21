package com.ysq.obooks.domain;

import java.util.Date;

public class Book {
    private int id;
    private String bname;
    private String author;
    private String type;
    private String booknum;
    private Date btime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBooknum() {
        return booknum;
    }

    public void setBooknum(String booknum) {
        this.booknum = booknum;
    }

    public Date getBtime() {
        return btime;
    }

    public void setBtime(Date btime) {
        this.btime = btime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", booknum='" + booknum + '\'' +
                ", btime=" + btime +
                '}';
    }
}
