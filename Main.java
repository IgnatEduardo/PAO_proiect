package com.company;

import com.company.service.AppService;
import com.company.user.entity.Address;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        AppService service = AppService.getInstance();
        service.readFromCsv();
    }
}
