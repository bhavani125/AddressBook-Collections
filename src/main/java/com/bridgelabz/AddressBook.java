package com.bridgelabz;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddressBook {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contacts> contactsArrayList = new ArrayList<>();
    static HashMap<String, ArrayList<Contacts>> addressBook = new HashMap<String, ArrayList<Contacts>>();

    static String firstName, lastName, address, city, state, emailId, zip, phoneNumber;
    static HashMap<String, Contacts> cityToPerson = new HashMap<String, Contacts>();
    static HashMap<String, Contacts> stateToPerson = new HashMap<String, Contacts>();

    //adding contacts
    public void addContact() {
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
        System.out.println("Enter the zip");
        person.setZip(sc.next());
        System.out.println("Enter the phoneNumber");
        person.setPhoneNumber(sc.next());
        if (duplicateCheck()) {
            System.out.println("This Contact Is Already Added.");
        } else {
            //using console
            contactsArrayList.add(person);
            cityToPerson.put(city, person);
            stateToPerson.put(state, person);
            System.out.println("Added:- " + person);
        }
    }

    //editing contacts
    public void editContacts() {
        System.out.println("Enter firstname of the user you want to the edit:");
        String firstName = sc.next();
        contactsArrayList.stream().filter(c -> c.getFirstName().equals(firstName)).forEach(c -> {
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
                c.setZip(sc.next());
            } else if (field.equals("phoneNumber")) {
                c.setPhoneNumber(sc.next());
            }
        });
    }

    //deleting contacts
    public void deleteContacts() {
        System.out.println("Enter firstname of the user you want to delete:");
        String firstName = sc.next();
        contactsArrayList.stream().filter(c -> c.getFirstName().equals(firstName)).forEach(c -> contactsArrayList.remove(c));
        System.out.println(contactsArrayList);

    }

    //duplicateCheck method
    public boolean duplicateCheck() {
        System.out.println("Enter the first name to check weather name there or not");
        String enteredName = sc.next();
        for (Contacts c : contactsArrayList) {
            if (c.getFirstName().equals(enteredName)) {
                System.out.println("This Person is Already Present");
            } else {
                System.out.println("You can  Add this Person");
            }
        }

        return false;
    }

    //View contacts method
    public void display(ArrayList<Contacts> contactsArrayList) {
        for (int i = 0; i < contactsArrayList.size(); i++) {
            Contacts c = contactsArrayList.get(i);
            System.out.println(c);
        }
    }

    //Creating viewPersonByCity method
    public void viewPersonByCity() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter City name :");
        String cityName = userInput.nextLine();
        int flag = 0;
        for (Map.Entry record : cityToPerson.entrySet()) {
            if (cityName.equalsIgnoreCase((String) record.getKey())) {
                flag = 1;
                System.out.println(record.getValue());
            }
        }
        if (flag == 0)
            System.out.println("This City does not exists!");
    }

    //Creating viewPersonByState method
    public void viewPersonByState() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter State name :");
        String stateName = userInput.nextLine();
        int flag = 0;
        for (Map.Entry record : stateToPerson.entrySet()) {
            if (stateName.equalsIgnoreCase((String) record.getKey())) {
                flag = 1;
                System.out.println(record.getValue());
            }
        }
        if (flag == 0)
            System.out.println("This State does not exists!");
    }
}