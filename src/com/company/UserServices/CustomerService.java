package com.company.UserServices;

import com.company.BookClasses.Book;
import com.company.BookServices.BookService;
import com.company.UserClasses.Address;
import com.company.UserClasses.Author;
import com.company.UserClasses.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private final List<Customer> customers = new ArrayList<>();
    private static CustomerService instance;

    private CustomerService(){}

    public static CustomerService getInstance() {
        if(instance == null){
            instance = new CustomerService();
        }
        return instance;
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

    public void addCustomers(Customer customer){
        this.customers.add(customer);
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

    public Customer readCustomers(){
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
