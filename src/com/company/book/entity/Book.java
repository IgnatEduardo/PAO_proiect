package com.company.book.entity;


import com.company.user.entity.Author;

import java.util.List;

public class Book {
    private int id;
    private String name;
    private Author author;
    private List<Review> review;

    public Book() {
    }

    //for csv so it's simpler :)
    public Book(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Book(int id, String name, Author author, List<Review> review) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.review = review;
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
