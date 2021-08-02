package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    //here iam using ArrayList to store
    public static ArrayList<Contacts> contactsArrayList = new ArrayList<>();

    //Main method
    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook System");
        AddressBook addressBook=new AddressBook();
        addressBook.addContact();
    }
    //Creating method to add Contact into AddressBook
    public void addContact(){
        Scanner sc = new Scanner(System.in);
        // creating object person for Contacts class
        Contacts person = new Contacts();
        System.out.println("Enter the firstName");
        person.setFirstName(sc.next());
        System.out.println("Enter the lastName");
        person.setLastName(sc.next());
        System.out.println("Enter the address");
        person.setAddress(sc.next());
        System.out.println("Enter the city");
        person.setCity(sc.next());
        System.out.println("Enter the state");
        person.setState(sc.next());
        System.out.println("Enter the EmailId");
        person.setEmailId(sc.next());
        System.out.println("Enter the phoneNumber");
        person.setPhoneNumber(sc.nextLong());
        System.out.println("Enter the zip");
        person.setZip(sc.nextLong());
        contactsArrayList.add(person);
        System.out.println(person);
        }
}




