package com.company.user.entity;


import com.company.book.entity.Book;

import java.util.List;

public class Author extends Person {
    private List<Book> booksPublished;

    public Author() {
    }

    public Author(int id, String name, int age, String email, Address address, List<Book> booksPublished) {
        super(id, name, age, email, address);
        this.booksPublished = booksPublished;
    }

    public List<Book> getBooksPublished() {
        return booksPublished;
    }

    public void setBooksPublished(List<Book> booksPublished) {
        this.booksPublished = booksPublished;
    }

    public void addBooks(Book book){
        this.booksPublished.add(book);
    }

    @Override
    public String toString() {
        return  "Id " + getId() + '\n' +
                "Age: " + getAge() + '\n' +
                "Name: " + getName() + '\n' +
                "Email: "  + getEmail() + '\n'
                ;
    }
}
