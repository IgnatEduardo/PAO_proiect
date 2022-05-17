package com.company.csv;

import com.company.book.entity.Book;
import com.company.book.entity.Review;
import com.company.user.entity.Customer;
import com.company.user.entity.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CsvWriterService {
    private static CsvWriterService instance;
    public static CsvWriterService getInstance(){
        if(instance == null){
            instance = new CsvWriterService();
        }
        return instance;
    }

    // Employee
    public void writeEmployeeInCsv(Employee employee) throws FileNotFoundException
    {
        File csvOutputFile = new File("src\\com\\company\\resources\\employee.csv");
        String formattedCustomer = convertToCsvFormat(employee);

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(csvOutputFile, true))) {
            pw.append(formattedCustomer);
        }
    }

    private static String convertToCsvFormat(Employee employee) {

        return  employee.getId() +
                "," +
                employee.getName() +
                "," +
                employee.getAge() +
                "," +
                employee.getEmail() +
                "," +
                employee.writeCsvAddress()+
                "," +
                employee.getPosition() +
                "," +
                employee.getSalary() +"\n";
    }

    //customer
    public void writeCustomerInCsv(Customer customer) throws FileNotFoundException
    {
        File csvOutputFile = new File("src\\com\\company\\resources\\customer.csv");
        String formattedCustomer = convertToCsvFormat(customer);

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(csvOutputFile, true))) {
            pw.append(formattedCustomer);
        }
    }

    private static String convertToCsvFormat(Customer customer) {

        return  customer.getId() +
                "," +
                customer.getName() +
                "," +
                customer.getAge() +
                "," +
                customer.getEmail() +
                "," +
                customer.writeCsvAddress()+
                "," +
                customer.getNrBooks() + "\n";
    }

    //book
    public void writeBookInCsv(Book book) throws FileNotFoundException
    {
        File csvOutputFile = new File("src\\com\\company\\resources\\book.csv");
        String formattedCustomer = convertToCsvFormat(book);

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(csvOutputFile, true))) {
            pw.append(formattedCustomer);
        }
    }

    private static String convertToCsvFormat(Book book) {

        return book.getId() +
                "," +
                book.getName() + "\n";
    }

    //review
    public void writeReviewInCsv(Review review) throws FileNotFoundException
    {
        File csvOutputFile = new File("src\\com\\company\\resources\\review.csv");
        String formattedCustomer = convertToCsvFormat(review);

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(csvOutputFile, true))) {
            pw.append(formattedCustomer);
        }
    }

    private static String convertToCsvFormat(Review review) {

        return review.getSubject() +
                "," +
                review.getReview() + "\n";
    }

    //audit
    public void writeActionInCsv(String action) throws FileNotFoundException
    {
        File csvOutputFile = new File("src\\com\\company\\resources\\audit.csv");

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date currentDateAndTime = new Date(System.currentTimeMillis());


        String log = action + "," + currentDateAndTime + "\n";

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(csvOutputFile, true))) {
            pw.append(log);
        }
    }
}
