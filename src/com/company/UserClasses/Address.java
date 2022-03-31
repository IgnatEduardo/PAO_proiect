package com.company.UserClasses;

public class Address {
    private int id, streetNumber;
    private String streetName, cityName, countryName;

    public Address(){}

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

    @Override
    public String toString() {
        return  "\n\t" + "street name: " + this.streetName +
                "\n\t" + "street number: " + this.streetNumber +
                "\n\t" + "city name:" + this.cityName +
                "\n\t" + "country name: " + this.countryName
                ;
    }
}
