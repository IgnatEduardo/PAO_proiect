package com.company;

import com.company.service.MenuService;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        MenuService service = MenuService.getInstance();
        service.menu();
    }
}
//test commit