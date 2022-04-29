package com.company;

import com.company.Service.Service;
import com.company.UserServices.EmployeeService;

public class Main {

    public static void main(String[] args) {
        Service service = Service.getInstance();
        service.menu();
    }
}
