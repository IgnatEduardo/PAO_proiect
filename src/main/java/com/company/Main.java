package com.company;

import com.company.config.DatabaseConfiguration;
import com.company.repository.AddressRepository;
import com.company.repository.EmployeeRepository;
import com.company.service.AppService;
import com.company.user.entity.Address;
import com.company.user.entity.Employee;
import com.company.user.service.AddressService;
import com.company.user.service.EmployeeService;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Main {

        public static void main(String[] args) throws FileNotFoundException, ParseException {
            AppService service = AppService.getInstance();
            service.readFromCsv();

            //etapa 3 este jos ( am uitat sa adaug in meniu :) )
//            AddressRepository addressRepository = new AddressRepository();
//            addressRepository.createTable();
//            AddressService addressService = AddressService.getInstance();
//            Address address =  addressService.readAddress();
//
//            AddressRepository.insertAddress(address);
//            DatabaseConfiguration.closeDatabaseConnection();
        }
    }
