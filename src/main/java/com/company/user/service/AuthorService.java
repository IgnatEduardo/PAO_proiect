package com.company.user.service;

import com.company.book.service.BookService;
import com.company.user.entity.Address;
import com.company.user.entity.Author;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class AuthorService {
    private static AuthorService instance;

    private AuthorService(){}

    public static AuthorService getInstance() {
        if(instance == null){
            instance = new AuthorService();
        }
        return instance;
    }

    public Author readAuthor() throws ParseException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        AddressService addressService = AddressService.getInstance();
        BookService bookService = BookService.getInstance();

        Author author = new Author();
        System.out.println("Author id");
        author.setId(scanner.nextInt());

        System.out.println("Name: ");
        author.setName(scanner.next());

        System.out.println("Email: ");
        author.setEmail(scanner.next());

//        System.out.println("Books published: ");
//        List<Book> books = (List<Book>) bookService.readBooks();
//        author.addBooks((Book) books);

        return author;
    }
}
