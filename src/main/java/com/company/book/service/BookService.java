package com.company.book.service;

import com.company.book.entity.Book;
import com.company.csv.CsvReaderService;
import com.company.csv.CsvWriterService;
import com.company.user.entity.Address;
import com.company.user.entity.Author;
import com.company.user.entity.Employee;
import com.company.user.service.AuthorService;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;


public class BookService {
    private final List<Book> books = new ArrayList<>();
    private static BookService instance;

    private BookService(){}

    CsvReaderService csvReaderService = CsvReaderService.getInstance();
    CsvWriterService csvWriterService = CsvWriterService.getInstance();

    public static BookService getInstance() {
        if(instance == null){
            instance = new BookService();
        }
        return instance;
    }

    //csv
    public void readBooksFromCsv() throws ParseException {
        List<String[]> bookList = csvReaderService.readBooksFromCsv();
        for (String[] strings : bookList) {
            Book newBook = createBook(strings[0], strings[1]);
            books.add(newBook);
        }
    }

    public Book createBook(String id, String name) throws ParseException {
        return new Book(parseInt(id), name);
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

    public void addBooks(Book book) throws FileNotFoundException {
        this.books.add(book);
        csvWriterService.writeBookInCsv(book);
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

    public Book readBooks() throws FileNotFoundException, ParseException {
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
