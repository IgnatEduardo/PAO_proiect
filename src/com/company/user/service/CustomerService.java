package com.company.user.service;

import com.company.book.entity.Book;
import com.company.book.service.BookService;
import com.company.csv.CsvReaderService;
import com.company.csv.CsvWriterService;
import com.company.user.entity.Address;
import com.company.user.entity.Customer;
import com.company.user.entity.Employee;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class CustomerService {
    private final List<Customer> customers = new ArrayList<>();
    private static CustomerService instance;

    private CustomerService(){}

    CsvReaderService csvReaderService = CsvReaderService.getInstance();
    CsvWriterService csvWriterService = CsvWriterService.getInstance();

    public static CustomerService getInstance() {
        if(instance == null){
            instance = new CustomerService();
        }
        return instance;
    }

    public void readCustomersFromCsv() throws ParseException {
        List<String[]> customerList = csvReaderService.readCostumersFromCsv();
        //LAMBDA EXPRESSION
        customerList.forEach( (strings) -> {
            Customer newCustomer = null;
            try {
                newCustomer = createCustomer(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            customers.add(newCustomer);});

    }

    public Customer createCustomer(String id, String name, String age, String email, String address, String nrBooks) throws ParseException {
        Address newAddress = new Address(address);
        return new Customer(parseInt(id), name, parseInt(age), email, newAddress, parseInt(nrBooks));
    }

    //CRUD employees
    public List<Customer> getCustomers() {
        return new ArrayList<>(this.customers);
    }

    public Customer getCustomerById(int index){
        Customer customer = new Customer();
        for (Customer value : this.customers) {
            if (value.getId() == index) {
                customer = value;
            }
        }
        return customer;
    }

    public void updateCustomer(int index, Customer customer){
        for(int i = 0; i < this.customers.size(); ++i){
            if(this.customers.get(i).getId() == index){
                this.customers.remove(i);
                this.customers.add(index, customer);
                break;
            }
        }
    }

    public void addCustomers(Customer customer) throws FileNotFoundException {
        this.customers.add(customer);
        csvWriterService.writeCustomerInCsv(customer);
    }

    public void deleteCustomerById(int index){
        for(int i = 0; i < this.customers.size(); ++i){
            if(this.customers.get(i).getId() == index){
                this.customers.remove(i);
                break;
            }
        }
    }

    public void deleteEmployees(Customer customer){
        for(int i = 0;i < this.customers.size(); ++i){
            if(this.customers.get(i).equals(customer)){
                this.customers.remove(i);
                break;
            }
        }
    }

    public Customer readCustomers() throws ParseException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        AddressService addressService = AddressService.getInstance();
        BookService bookService = BookService.getInstance();

        Customer customer = new Customer();

        System.out.println("Customer id");
        customer.setId(scanner.nextInt());

        System.out.println("Name: ");
        customer.setName(scanner.next());

        System.out.println("Age: ");
        customer.setAge(scanner.nextInt());

        System.out.println("Email: ");
        customer.setEmail(scanner.next());

        System.out.println("Address details: ");
        Address address = addressService.readAddress();
        customer.setAddress(address);

        System.out.println("Number of books: ");
        customer.setNrBooks(scanner.nextInt());

        System.out.println("Books: ");
        for(int i = 0; i< customer.getNrBooks(); i++){
            Book book = bookService.readBooks();
            customer.getBooks().add(book);
        }


        return customer;
    }

}
