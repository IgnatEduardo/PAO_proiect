package com.company.user.service;

import com.company.book.entity.Book;
import com.company.csv.CsvReaderService;
import com.company.csv.CsvWriterService;
import com.company.user.entity.Address;
import com.company.user.entity.Customer;
import com.company.user.entity.Employee;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private static EmployeeService instance;

    private EmployeeService(){}

    CsvReaderService csvReaderService = CsvReaderService.getInstance();
    CsvWriterService csvWriterService = CsvWriterService.getInstance();

    public static EmployeeService getInstance() {
        if(instance == null){
            instance = new EmployeeService();
        }
        return instance;
    }

    //read from csv
    public void readEmployeesFromCsv() throws ParseException {
        List<String[]> employeeList = csvReaderService.readEmployeesFromCsv();
        //LAMBDA EXPRESSION
        employeeList.forEach( (strings) -> {
            Employee newEmployee = null;
            try {
                newEmployee = createEmployee(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            employees.add(newEmployee);});
    }

    public Employee createEmployee(String id, String name, String age, String email, String address, String position, String salary) throws ParseException {
        Address newAddress = new Address(address);
        return new Employee(parseInt(id), name, parseInt(age), email, newAddress, position, parseDouble(salary));
    }

    //CRUD employees
    public List<Employee> getEmployees() {
        return new ArrayList<>(this.employees);
    }

    public Employee getEmployeeById(int index){
        Employee employee = new Employee();
        for (Employee value : this.employees) {
            if (value.getId() == index) {
                employee = value;
            }
        }
        return employee;
    }

    public void updateEmployee(int index, Employee employee){

        for(int i = 0; i < this.employees.size(); ++i){
            if(this.employees.get(i).getId() == index){
                this.employees.remove(i);
                this.employees.add(index, employee);
                break;
            }
        }
    }

    public void addEmployees(Employee employee) throws FileNotFoundException {
        this.employees.add(employee);
        csvWriterService.writeEmployeeInCsv(employee);
    }

    public void deleteEmployeeById(int index){
        for(int i = 0; i < this.employees.size(); ++i){
            if(this.employees.get(i).getId() == index){
                this.employees.remove(i);
                break;
            }
        }
    }

    public void deleteEmployees(Employee employee){
        for(int i = 0;i < this.employees.size(); ++i){
            if(this.employees.get(i).equals(employee)){
                this.employees.remove(i);
                break;
            }
        }
    }

    public Employee readEmployee() throws ParseException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        AddressService addressService = AddressService.getInstance();

        Employee employee = new Employee();
        System.out.println("Employee id");
        employee.setId(scanner.nextInt());

        System.out.println("Name: ");
        employee.setName(scanner.next());

        System.out.println("Age: ");
        employee.setAge(scanner.nextInt());

        System.out.println("Email: ");
        employee.setEmail(scanner.next());

        System.out.println("Address details: ");
        Address address = addressService.readAddress();
        employee.setAddress(address);

        System.out.println("Position: ");
        employee.setPosition(scanner.next());

        System.out.println("Salary: ");
        employee.setSalary(scanner.nextDouble());

        return employee;
    }
}
