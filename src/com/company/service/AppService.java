package com.company.service;

import com.company.book.entity.Book;
import com.company.book.service.BookService;
import com.company.book.service.ReviewService;
import com.company.csv.CsvWriterService;
import com.company.user.entity.Customer;
import com.company.user.entity.Employee;
import com.company.user.service.CustomerService;
import com.company.user.service.EmployeeService;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class AppService {
    private EmployeeService employeeService = EmployeeService.getInstance();
    private CustomerService customerService = CustomerService.getInstance();
    private BookService bookService = BookService.getInstance();
    private ReviewService reviewService = ReviewService.getInstance();
    CsvWriterService csvWriterService = CsvWriterService.getInstance(); //for audit

    private static AppService instance;

    private Scanner scanner = new Scanner(System.in);

    private AppService() {
    }

    public void readFromCsv() throws ParseException, FileNotFoundException {
        employeeService.readEmployeesFromCsv();
        customerService.readCustomersFromCsv();
        bookService.readBooksFromCsv();
        reviewService.readReviewInCsv();
        menu();

    }

    public static AppService getInstance() {
        if (instance == null) {
            instance = new AppService();
        }
        return instance;
    }

    public void printMenu() {
        System.out.println("0 - Admin");
        System.out.println("1 - Costumer");
        System.out.println("2 - Exit");
    }

    public void printOptions() {
        System.out.println("0 - Get All");
        System.out.println("1 - Get By Id");
        System.out.println("2 - Add");
        System.out.println("3 - Update");
        System.out.println("4 - Delete");
        System.out.println("5 - Exit");
    }

    public void adminOptions() {
        System.out.println("0 - Manage Employees");
        System.out.println("1 - Manage Customers");
        System.out.println("2 - Manage Books");
        System.out.println("3 - Exit");
    }

    public void costumerOptions() {
        System.out.println("0 - Add review to book");
        System.out.println("1 - Exit");
    }

    public void menu() throws ParseException, FileNotFoundException{
        while (true) {
            printMenu();
            int option = scanner.nextInt();
            if (option == 0) {
                while (true) {
                    adminOptions(); //CRUD Costumer, Employee, Book
                    int option1 = scanner.nextInt();
                    if (option1 == 0) {
                        manageEmployeesMenu();
                    } else if (option1 == 1) {
                        manageCustomersMenu();
                    } else if (option1 == 2) {
                        manageBooks();
                    } else if (option1 == 3) {
                        break;
                    }
                }
            } else if (option == 1) {
                while (true) {
                    costumerOptions();
                    int option2 = scanner.nextInt();
                    if (option2 == 0) {
                        //add review TODO
                    } else if (option2 == 1) {
                        break;
                    }
                }
            } else if (option == 2) {
                break;
            }
        }
    }


    public void manageEmployeesMenu() throws ParseException, FileNotFoundException{
        while (true) {
            printOptions();
            int option = scanner.nextInt();
            if (option == 0) {
                for (int i = 0; i < employeeService.getEmployees().size(); ++i) {
                    System.out.println(employeeService.getEmployees().get(i).toString());
                }
                csvWriterService.writeActionInCsv("get all employees");
            } else if (option == 1) {
                int index = scanner.nextInt();
                System.out.println(employeeService.getEmployeeById(index).toString());
                csvWriterService.writeActionInCsv("get employee by id");
            } else if (option == 2) {
                Employee employee = employeeService.readEmployee();
                employeeService.addEmployees(employee);
                csvWriterService.writeActionInCsv("add employee");
            } else if (option == 3) {
                int index = scanner.nextInt();
                Employee employee = employeeService.readEmployee();
                employeeService.updateEmployee(index, employee);
                csvWriterService.writeActionInCsv("update employee");
            } else if (option == 4) {
                int index = scanner.nextInt();
                employeeService.deleteEmployeeById(index);
                csvWriterService.writeActionInCsv("delete employee");
            } else if (option == 5) {
                csvWriterService.writeActionInCsv("exit employee management menu");
                break;
            }
        }
    }

    public void manageCustomersMenu() throws ParseException, FileNotFoundException {
        while (true) {
            printOptions();
            int option = scanner.nextInt();
            if (option == 0) {
                for (int i = 0; i < customerService.getCustomers().size(); ++i) {
                    System.out.println(customerService.getCustomers().get(i).toString());
                }
                csvWriterService.writeActionInCsv("get all customers");
            } else if (option == 1) {
                int index = scanner.nextInt();
                System.out.println(customerService.getCustomerById(index).toString());
                csvWriterService.writeActionInCsv("get customer by id");
            } else if (option == 2) {
                Customer costumer = customerService.readCustomers();
                customerService.addCustomers(costumer);
                csvWriterService.writeActionInCsv("add customer");
            } else if (option == 3) {
                int index = scanner.nextInt();
                Customer costumer = customerService.readCustomers();
                customerService.updateCustomer(index, costumer);
                csvWriterService.writeActionInCsv("update customer");
            } else if (option == 4) {
                int index = scanner.nextInt();
                customerService.deleteCustomerById(index);
                csvWriterService.writeActionInCsv("delete customer");
            } else if (option == 5) {
                csvWriterService.writeActionInCsv("exit customer management menu");
                break;
            }
        }
    }

    public void manageBooks() throws ParseException, FileNotFoundException{
        while (true) {
            printOptions();
            int option = scanner.nextInt();
            if (option == 0) {
                for (int i = 0; i < bookService.getBooks().size(); ++i) {
                    System.out.println(bookService.getBooks().get(i).toString());
                }
                csvWriterService.writeActionInCsv("get all books");
            } else if (option == 1) {
                int index = scanner.nextInt();
                System.out.println(bookService.getBookById(index).toString());
                csvWriterService.writeActionInCsv("get book by id");
            } else if (option == 2) {
                Book book = bookService.readBooks();
                bookService.addBooks(book);
                csvWriterService.writeActionInCsv("add book");
            } else if (option == 3) {
                int index = scanner.nextInt();
                Book book = bookService.readBooks();
                bookService.updateBooks(index, book);
                csvWriterService.writeActionInCsv("update book");
            } else if (option == 4) {
                int index = scanner.nextInt();
                bookService.deleteBookById(index);
                csvWriterService.writeActionInCsv("delete book");
            } else if (option == 5) {
                csvWriterService.writeActionInCsv("exit book management menu");
                break;
            }
        }
    }
}