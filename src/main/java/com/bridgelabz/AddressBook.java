package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    static Scanner sc = new Scanner(System.in);
    //main method
    public static void main(String[] args) {
        AddressBook addressBookObj = new AddressBook();
         addressBookObj.CreatingAddressBooks();
    }
    //Creating CreatingAddressBooks Method here
    public void CreatingAddressBooks() {
        //here iam using ArrayList to store
        HashMap<String, ArrayList<Contacts>> addressBook = new HashMap<String, ArrayList<Contacts>>();
        boolean options = true;
        while (options) {
            System.out.println("Enter 1) To Create new Address book\n 2) To edit address books \n 3) To view all the address books\n 4) To Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    ArrayList<Contacts> contactsArrayList = new ArrayList<>();
                    System.out.println("Enter the new addressBook name : ");
                    String addressBookName = sc.next();
                    //  to add new address book
                    if (!addressBook.containsKey(addressBookName)) {
                        boolean flag = true;
                        while (flag) {
                            Contacts person = new Contacts();
                            System.out.println("Enter 1) To Add contact in " + addressBookName + "\n 2) To Exit from " + addressBookName);
                            int choice = sc.nextInt();
                            if (choice == 1) {
                                addContact(person, contactsArrayList);
                                addressBook.put(addressBookName, contactsArrayList);
                                System.out.println("Added person details in " + addressBookName + " successfully.");
                            } else {
                                flag = false;
                                System.out.println("Exit from " + addressBookName + " address book.");
                            }
                        }
                    } else {
                        System.out.println(addressBookName + " address book is already present.");
                    }
                    break;

                // editing the previous address book
                case 2:
                    System.out.println("Enter a address book name u want to edit : ");
                    addressBookName = sc.next();
                    try {
                        if (addressBook.containsKey(addressBookName)) {
                            contactsArrayList = addressBook.get(addressBookName);
                            boolean flag = true;
                            while (flag) {
                                Contacts person = new Contacts();
                                System.out.println("Enter 1) To Add contact in " + addressBookName + "\n2) To Edit Contact from " + addressBookName + "\n3) To Delete contact from " + addressBookName + "\n4) To View contact from " + addressBookName + "\n5) To Exit " + addressBookName);
                                int choice = sc.nextInt();
                                switch (choice) {
                                    case 1:
                                        addContact(person, contactsArrayList);
                                        break;
                                    case 2:
                                        editContacts(person, contactsArrayList);

                                        break;
                                    case 3:
                                        deleteContacts(person, contactsArrayList);

                                        break;
                                    case 4:
                                        viewContact(contactsArrayList);
                                        break;
                                    default:
                                        flag = false;
                                        addressBook.put(addressBookName, contactsArrayList);
                                        System.out.println("Exit ");
                                }
                            }
                            // adding contact list to the dictionary (Address book)
                            addressBook.put(addressBookName, contactsArrayList);
                            break;
                        } else {
                            System.out.println("No such address book");
                        }
                    } catch (Exception e) {
                        System.out.println("No such address book");
                        break;
                    }

                    break;

                // shows address book names
                case 3:
                    if (!addressBook.isEmpty()) {
                        System.out.println("Address book names : ");
                        for (String key : addressBook.keySet()) {
                            System.out.print(key);
                        }
                        System.out.println("\n");
                    } else {
                        System.out.println("Address book is empty.");
                    }
                    break;
                // exit
                default:
                    break;
            }
        }
    }

    //adding contacts
    private static ArrayList<Contacts> addContact(Contacts person, ArrayList<Contacts> contactsArrayList) {
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
        person.setZip(sc.nextLong());
        System.out.println("Enter the phoneNumber");
        person.setPhoneNumber(sc.nextLong());
        //using console
        contactsArrayList.add(person);
        System.out.println(contactsArrayList);

        return contactsArrayList;
    }
    //editing contacts
    public static ArrayList<Contacts> editContacts( Contacts person, ArrayList < Contacts > contactsArrayList ) {
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
        return contactsArrayList;
    }

    //deleting contacts
    private static ArrayList<Contacts> deleteContacts (Contacts person, ArrayList < Contacts > contactsArrayList) {
        System.out.println("Enter firstname of the user you want to delete:");
        String firstName = sc.next();
        for (int i = 0; i < contactsArrayList.size(); i++) {
            Contacts c = contactsArrayList.get(i);
            if (c.getFirstName().equals(firstName)) {
                contactsArrayList.remove(c);
            }

        }
        System.out.println(contactsArrayList);
        return contactsArrayList;
    }
    //View contacts method
    private static void viewContact (ArrayList < Contacts > contactsArrayList) {
        for (Contacts c : contactsArrayList) {
            System.out.println(c);
        }

    }
}


