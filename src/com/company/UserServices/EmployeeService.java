package com.company.UserServices;

import com.company.UserClasses.Address;
import com.company.UserClasses.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private static EmployeeService instance;

    private EmployeeService(){}

    public static EmployeeService getInstance() {
        if(instance == null){
            instance = new EmployeeService();
        }
        return instance;
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

    public void addEmployees(Employee employee){
        this.employees.add(employee);
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

    public Employee readEmployee(){
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
