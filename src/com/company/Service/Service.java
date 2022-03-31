package com.company.Service;

import com.company.BookClasses.Book;
import com.company.BookServices.BookService;
import com.company.UserClasses.Customer;
import com.company.UserClasses.Employee;
import com.company.UserServices.CustomerService;
import com.company.UserServices.EmployeeService;

import java.text.ParseException;
import java.util.Scanner;

public class Service {
    private EmployeeService employeeService = EmployeeService.getInstance();
    private CustomerService customerService = CustomerService.getInstance();
    private BookService bookService = BookService.getInstance();

    private static Service instance;

    private Scanner scanner = new Scanner(System.in);

    private Service() {
    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
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

    public void menu() {
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


    public void manageEmployeesMenu() {
        while (true) {
            printOptions();
            int option = scanner.nextInt();
            if (option == 0) {
                for (int i = 0; i < employeeService.getEmployees().size(); ++i) {
                    System.out.println(employeeService.getEmployees().get(i).toString());
                }
            } else if (option == 1) {
                int index = scanner.nextInt();
                System.out.println(employeeService.getEmployeeById(index).toString());
            } else if (option == 2) {
                Employee employee = employeeService.readEmployee();
                employeeService.addEmployees(employee);
            } else if (option == 3) {
                int index = scanner.nextInt();
                Employee employee = employeeService.readEmployee();
                employeeService.updateEmployee(index, employee);
            } else if (option == 4) {
                int index = scanner.nextInt();
                employeeService.deleteEmployeeById(index);
            } else if (option == 5) {
                break;
            }
        }
    }

    public void manageCustomersMenu() {
        while (true) {
            printOptions();
            int option = scanner.nextInt();
            if (option == 0) {
                for (int i = 0; i < customerService.getCustomers().size(); ++i) {
                    System.out.println(customerService.getCustomers().get(i).toString());
                }
            } else if (option == 1) {
                int index = scanner.nextInt();
                System.out.println(customerService.getCustomerById(index).toString());
            } else if (option == 2) {
                Customer costumer = customerService.readCustomers();
                customerService.addCustomers(costumer);
            } else if (option == 3) {
                int index = scanner.nextInt();
                Customer costumer = customerService.readCustomers();
                customerService.updateCustomer(index, costumer);
            } else if (option == 4) {
                int index = scanner.nextInt();
                customerService.deleteCustomerById(index);
            } else if (option == 5) {
                break;
            }
        }
    }

    public void manageBooks() {
        while (true) {
            printOptions();
            int option = scanner.nextInt();
            if (option == 0) {
                for (int i = 0; i < bookService.getBooks().size(); ++i) {
                    System.out.println(bookService.getBooks().get(i).toString());
                }
            } else if (option == 1) {
                int index = scanner.nextInt();
                System.out.println(bookService.getBookById(index).toString());
            } else if (option == 2) {
                Book book = bookService.readBooks();
                bookService.addBooks(book);
            } else if (option == 3) {
                int index = scanner.nextInt();
                Book book = bookService.readBooks();
                bookService.updateBooks(index, book);
            } else if (option == 4) {
                int index = scanner.nextInt();
                bookService.deleteBookById(index);
            } else if (option == 5) {
                break;
            }
        }
    }
}