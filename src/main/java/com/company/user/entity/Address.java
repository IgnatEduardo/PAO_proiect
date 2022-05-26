package com.company.user.entity;

import static java.lang.Integer.parseInt;

public class Address {
    private int id, streetNumber;
    private String streetName, cityName, countryName;

    public Address(){}

    //constructor to read from csv
    public Address(String string) {
        String[] arrOfStr = string.split(" ", 5);

        this.streetName = arrOfStr[0];
        this.streetNumber = parseInt(arrOfStr[1]);
        this.cityName = arrOfStr[2];
        this.countryName = arrOfStr[3];
    }

    public Address(int id, String streetName, int streetNumber, String cityName, String countryName) {
        this.id = id;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.cityName = cityName;
        this.countryName = countryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    //for csv
    public String toCsvString(){
        return streetName + ' ' + streetNumber + ' ' + cityName + ' ' + countryName;
    }

    @Override
    public String toString() {
        return  "\n\t" + "street name: " + this.streetName +
                "\n\t" + "street number: " + this.streetNumber +
                "\n\t" + "city name:" + this.cityName +
                "\n\t" + "country name: " + this.countryName
                ;
    }
}
