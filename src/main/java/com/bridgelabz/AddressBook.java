package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    //here iam using ArrayList to store
    public static ArrayList<Contacts> contactsArrayList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    //Main method
    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook System");
        boolean options = true;
        while (options) {
            AddressBook addressBook=new AddressBook();
            System.out.println("Enter \n 1)To Add contacts \n 2) To edit contacts\n 3)To Delete Contacts 4) To Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1://calling addContacts method
                    AddressBook.addContact();
                    break;
                case 2://calling editContacts method
                    AddressBook.editContacts();
                    break;
                case 3://calling deleteContacts method
                    AddressBook.deleteContacts();
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    //Creating method to add Contact into AddressBook
    static void addContact(){
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

    //creating method for editing contacts in previous Contacts
    static void editContacts() {
        System.out.println("Enter firstname of the user you want to the edit:");
        String firstName = sc.next();
        for (Contacts c : contactsArrayList) {
            if (c.getFirstName().equals(firstName)) {
                System.out.println("c");
                System.out.println("Enter the  field which u want to edit:");
                System.out.println(" Address");
                System.out.println(" City ");
                System.out.println(" State");
                System.out.println(" Email");
                System.out.println(" Phone Number");
                System.out.println(" ZipCode");
                System.out.println("Exit");
                String field = sc.next();

                if (field.equals("firstName")) {
                    c.setFirstName(sc.next());
                } else if (field.equals("lastName")) {
                    c.setLastName(sc.next());
                } else if (field.equals("Address")) {
                    c.setAddress(sc.next());
                } else if (field.equals("City")) {
                    c.setCity(sc.next());
                } else if (field.equals("State")) {
                    c.setState(sc.next());
                } else if (field.equals("Email")) {
                    c.setEmailId(sc.next());
                } else if (field.equals("Zip")) {
                    c.setZip(sc.nextLong());
                } else if (field.equals("phoneNumber")) {
                    c.setPhoneNumber(sc.nextLong());
                }
            }

        }
        System.out.println(contactsArrayList.toString());

    }
    //creating method for deleting contacts
    static void deleteContacts() {
        System.out.println("Enter firstname of the user you want to delete:");
        String firstName = sc.next();
        for (int i = 0; i < contactsArrayList.size(); i++) {
            Contacts c = contactsArrayList.get(i);
            if (c.getFirstName().equals(firstName)) {

                contactsArrayList.remove(c);

            }
            System.out.println(contactsArrayList);
        }
    }
}




