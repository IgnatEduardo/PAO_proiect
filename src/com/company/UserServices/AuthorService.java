package com.company.UserServices;

import com.company.BookClasses.Book;
import com.company.BookServices.BookService;
import com.company.UserClasses.Address;
import com.company.UserClasses.Author;

import java.util.ArrayList;
import java.util.List;
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

    public Author readAuthor(){
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

        System.out.println("Address details: ");
        Address address = addressService.readAddress();
        author.setAddress(address);

//        System.out.println("Books published: ");
//        List<Book> books = (List<Book>) bookService.readBooks();
//        author.addBooks((Book) books);

        return author;
    }
}
