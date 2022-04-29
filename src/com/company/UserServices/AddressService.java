package com.company.UserServices;

import com.company.UserClasses.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressService {
    private List<Address> addresses = new ArrayList<>();
    private static AddressService instance;

    private AddressService() {}

    public static AddressService getInstance() {
        if(instance == null) {
            instance = new AddressService();
        }
        return instance;
    }

    public List<Address> getAddresses() {
        return new ArrayList<>(this.addresses);
    }

    public Address getAddressById(int index) {
        Address address = new Address();
        for (Address value : this.addresses) {
            if (value.getId() == index) {
                address = value;
            }
        }
        return address;
    }

    public void updateAddress(int index, Address address) {
        for(int i = 0; i < this.addresses.size(); ++i) {
            if(this.addresses.get(i).getId() == index) {
                this.addresses.remove(i);
                this.addresses.add(index, address);
                break;
            }
        }
    }

    public void addAddress(Address address){
        this.addresses.add(address);
    }

    public void deleteAddressById(int index){
        for(int i = 0; i < this.addresses.size(); ++i){
            if(this.addresses.get(i).getId() == index){
                this.addresses.remove(i);
                break;
            }
        }
    }

    public Address readAddress(){
        Scanner scanner = new Scanner(System.in);
        Address address = new Address();
        System.out.println("Address id: ");
        address.setId(scanner.nextInt());

        System.out.println("Street name: ");
        address.setStreetName(scanner.next());

        System.out.println("Street number: ");
        address.setStreetNumber(scanner.nextInt());

        System.out.println("City name: ");
        address.setCityName(scanner.next());

        System.out.println("Country name: ");
        address.setCountryName(scanner.next());

        return address;
    }
}
