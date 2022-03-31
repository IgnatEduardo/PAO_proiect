package com.company.UserClasses;


import com.company.BookClasses.Book;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person{
    private List<Book> booksPublished;

    public Author(int id, String name, int age, String email, Address address, List<Book> booksPublished) {
        super(id, name, age, email, address);
        this.booksPublished = booksPublished;
    }

    public Author() {

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
        return  "Id " + id + '\n' +
                "Age=" + age + '\n' +
                "Name='" + name + '\n' +
                "Email='" + email + '\n' +
                "Address=" + address + '\n'
                ;
    }
}
