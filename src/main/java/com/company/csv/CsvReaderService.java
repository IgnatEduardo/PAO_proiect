package com.company.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReaderService {
    private static CsvReaderService instance;

    public static CsvReaderService getInstance(){
        if(instance == null){
            instance = new CsvReaderService();
        }
        return instance;
    }

    public List<String[]> readEmployeesFromCsv()
    {
        List<String[]> stringList = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\resources\\employee.csv"));
            br.readLine(); // read header
            while ((line = br.readLine()) != null)
            //returns a Boolean value
            {
                String[] employee = line.split(splitBy);
                stringList.add(employee);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    public List<String[]> readCostumersFromCsv()
    {
        List<String[]> stringList = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\resources\\customer.csv"));
            br.readLine(); // read header
            while ((line = br.readLine()) != null)
            //returns a Boolean value
            {
                String[] customer = line.split(splitBy);
                stringList.add(customer);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    public List<String[]> readBooksFromCsv()
    {
        List<String[]> stringList = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\resources\\book.csv"));
            br.readLine(); // read header
            while ((line = br.readLine()) != null)
            //returns a Boolean value
            {
                String[] book = line.split(splitBy);
                stringList.add(book);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    public List<String[]> readReviewsFromCsv()
    {
        List<String[]> stringList = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("src\\com\\company\\resources\\review.csv"));
            br.readLine(); // read header
            while ((line = br.readLine()) != null)
            //returns a Boolean value
            {
                String[] review = line.split(splitBy);
                stringList.add(review);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
}
