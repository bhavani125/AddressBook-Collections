package com.bridgelabz;

import java.util.List;

public class Contacts {
    //instance variables
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String emailId;
    String zip;
    String phoneNumber;

    public Contacts(String firstName, String lastName, String address, String city, String state, String emailId, String zip,String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.emailId = emailId;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }
    public Contacts() {
        // TODO Auto-generated constructor stub
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", emailId='" + emailId + '\'' +
                ", zip=" + zip +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;
        Contacts that = (Contacts) object;
        if (!(this.firstName.equalsIgnoreCase(that.firstName))) return false;
        if (!(this.lastName.equalsIgnoreCase(that.lastName))) return false;
        if (!(this.address.equalsIgnoreCase(that.address))) return false;
        if (!(this.city.equalsIgnoreCase(that.city))) return false;
        if (!(this.state.equalsIgnoreCase(that.state))) return false;
        if (!(this.emailId.equalsIgnoreCase(that.emailId))) return false;
        if (!(this.zip.equalsIgnoreCase(that.zip)))  return false;
        if (!(this.phoneNumber.equalsIgnoreCase(that.phoneNumber))) return false;
        return true;
    }
}


