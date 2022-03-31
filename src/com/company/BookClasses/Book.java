package com.company.BookClasses;


import com.company.UserClasses.Author;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book {
    private int id;
    private String name;
    private Author author;
    private List<Review> review;

    public Book(int id, String name, Author author, List<Review> review) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.review = review;
    }

    public Book() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return  "Book's name: " + this.name + '\n' +
                "Author: " + this.author + '\n'
//                "Reviews:" + new ArrayList<>(this.review) + '\n' //TOSEE
                ;
    }
}
