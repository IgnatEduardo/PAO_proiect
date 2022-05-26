package com.company.user.entity;

public class Employee extends Person {
    private String position;
    private Double salary;

    public Employee(int id, String name, int age, String email, Address address, String position, Double salary) {
        super(id, name, age, email, address);
        this.position = position;
        this.salary = salary;
    }

    public Employee() {}

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee's name: " + getName() + '\n' +
                "Email: " + getEmail() + '\n' +
                "Address: " + getAddress().toString() + '\n' +
                "Age: " + getAge() + '\n' +
                "Position: " + getPosition() + '\n' +
                "Salary: " + getSalary() + '\n'
                ;
    }
}
