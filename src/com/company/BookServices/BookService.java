package com.company.BookServices;

import com.company.BookClasses.Book;
import com.company.UserClasses.Author;
import com.company.UserServices.AuthorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BookService {
    private final List<Book> books = new ArrayList<>();
    private static BookService instance;

    private BookService(){}

    public static BookService getInstance() {
        if(instance == null){
            instance = new BookService();
        }
        return instance;
    }

    //CRUD books
    public List<Book> getBooks() {
        return new ArrayList<>(this.books);
    }

    public Book getBookById(int index){
        Book book = new Book();
        for (Book value : this.books) {
            if (value.getId() == index) {
                book = value;
            }
        }
        return book;
    }

    public void updateBooks(int index, Book book){
        for(int i = 0; i < this.books.size(); ++i){
            if(this.books.get(i).getId() == index){
                this.books.remove(i);
                this.books.add(index, book);
                break;
            }
        }
    }

    public void addBooks(Book book){
        this.books.add(book);
    }

    public void deleteBookById(int index){
        for(int i = 0; i < this.books.size(); ++i){
            if(this.books.get(i).getId() == index){
                this.books.remove(i);
                break;
            }
        }
    }

    public void deleteBooks(Book book){
        for(int i = 0;i < this.books.size(); ++i){
            if(this.books.get(i).equals(book)){
                this.books.remove(i);
                break;
            }
        }
    }

    public Book readBooks(){
        Scanner scanner = new Scanner(System.in);

        AuthorService authorService = AuthorService.getInstance();

        Book book = new Book();
        System.out.println("Book id");
        book.setId(scanner.nextInt());

        System.out.println("Name: ");
        book.setName(scanner.next());

        System.out.println("Author: ");
        Author author = authorService.readAuthor();
        book.setAuthor(author);

//        System.out.println("Review: ");
//        Review review = reviewService.readAddress();
//        book.setAddress(address);

        return book;
    }
}
