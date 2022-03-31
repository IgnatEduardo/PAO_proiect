package com.company.UserClasses;

import com.company.BookClasses.Book;

import java.util.List;

public class Customer extends Person{
    private int nrBooks;
    private List<Book> books;

    public Customer(){}

    public Customer(int id, String name, int age, String email, Address address, int nrBooks, List<Book> books) {
        super(id, name, age, email, address);
        this.nrBooks = nrBooks;
        this.books = books;
    }

    public int getNrBooks() {
        return nrBooks;
    }

    public void setNrBooks(int nrBooks) {
        this.nrBooks = nrBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Customer's name: " + this.name + '\n' +
                "Email: " + this.email + '\n' +
                "Address: " + this.address.toString() + '\n' +
                "Age: " + this.age + '\n' +
                "Number of books: " + this.nrBooks + '\n' +
                "Books: " + this.books + '\n'
                ;
    }
}
