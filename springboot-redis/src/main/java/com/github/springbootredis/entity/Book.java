package com.github.springbootredis.entity;

import java.io.Serializable;

/**
 *  实体类
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String autherName;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(Long id, String name, String autherName) {
        this.id = id;
        this.name = name;
        this.autherName = autherName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutherName() {
        return autherName;
    }

    public void setAutherName(String autherName) {
        this.autherName = autherName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", autherName='" + autherName + '\'' +
                '}';
    }
}
