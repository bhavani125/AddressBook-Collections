package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

import static com.bridgelabz.AddressBook.addressBook;
import static com.bridgelabz.AddressBook.countByOption;

public class AddressBookMain {
    static HashMap<String,AddressBook> addressbooks=new HashMap<String,AddressBook>();
    static AddressBook addressbook = new AddressBook();
    //Main method
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program ");
        Scanner userInput = new Scanner(System.in);
        int choice;
        String addressbookName = "Default";
        addressbooks.put(addressbookName, addressbook);
        do {
            System.out.println("Enter 1) To Create new Address book\n 2) To edit address books \n 3) To view all the address books\n 4)To Search Person By City Or State In All Address Books\n 5) To View Person by City or State in Current Address Book\n6) To Count No. Of Persons by City Or State\n7) To Exit");
            choice = userInput.nextInt();
            userInput.nextLine();
            switch (choice) {
                case 1: {
                    ArrayList<Contacts> contactsArrayList = new ArrayList<>();
                    System.out.println("Enter the new addressBook name : ");
                    String addressBookName = userInput.next();
                    //  to add new address book
                    if (!addressBook.containsKey(addressBookName)) {
                        boolean flag = true;
                        while (flag) {
                            System.out.println("Enter 1) To Add contact in " + addressBookName + "\n 2) To Exit from " + addressBookName);
                            int option = userInput.nextInt();
                            if (option == 1) {
                                addressbook.addContact();
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
                }
                // editing the previous address book
                case 2: {
                    ArrayList<Contacts> contactsArrayList = new ArrayList<>();
                    System.out.println("Enter a address book name u want to edit : ");
                    String addressBookName = userInput.next();
                    try {
                        if (addressBook.containsKey(addressBookName)) {
                            contactsArrayList = addressBook.get(addressBookName);
                            boolean flag = true;
                            while (flag) {
                                System.out.println("Enter 1) To Add contact in " + addressBookName + "\n2) To Edit Contact from " + addressBookName + "\n3) To Delete contact from " + addressBookName + "\n4) To Check Duplicate Contact from" + addressBookName + "\n5) To View contact from " + addressBookName + "\n6) To Exit " + addressBookName);
                                int option = userInput.nextInt();
                                switch (option) {
                                    case 1:
                                        addressbook.addContact();
                                        addressbook.display(addressbook.contactsArrayList);
                                        break;
                                    case 2:
                                        addressbook.editContacts();
                                        addressbook.display(addressbook.contactsArrayList);
                                        break;
                                    case 3:
                                        addressbook.deleteContacts();
                                        addressbook.display(addressbook.contactsArrayList);
                                        break;
                                    case 4:
                                        addressbook.duplicateCheck();
                                        break;
                                    case 5:
                                        addressbook.display(addressbook.contactsArrayList);
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
                }
                // shows address book names
                case 3: {
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
                }//search Person By City Or State
                case 4:
                    searchPersonsByCityOrState();
                break;
                case 5://view Person By City Or State
                    viewPersonsByCityOrState();
                break;
                case 6://count By City Or State
                    countByOption();
                break;
                // exit
                default:
                    break ;
            }
        }while(choice!=7);
    }
    //method to check whether addressBook contains given name
    public static boolean isKeyExists(String name) {
        return addressbooks.containsKey(name);
    }

    public static void display() {
        System.out.println("All Address Book Details\n");
        addressbooks.entrySet().stream().forEach(book->{
            System.out.println("\""+book.getKey()+"\""+" "+book.getValue());
        });
    }

    //Creating searchPersonByCity method
    public static void searchPersonByCity() {
        Scanner userInput=new Scanner(System.in);
        System.out.print("Enter city name :");
        int flag=0;
        String cityName=userInput.nextLine();
        for(Map.Entry record : addressbooks.entrySet()){
            AddressBook addressbook=(AddressBook) record.getValue();
            for(Contacts c : addressbook.contactsArrayList) {
                if(c.city.equalsIgnoreCase(cityName)) {
                    flag=1;
                    System.out.println(c);
                }
            }
        }
        if(flag==0)
            System.out.println("This City does not exists!");
    }
    //Creating searchPersonByState method
    public static void searchPersonByState() {
        Scanner userInput=new Scanner(System.in);
        System.out.print("Enter State name :");
        String stateName=userInput.nextLine();
        int flag=0;
        for(Map.Entry record : addressbooks.entrySet()){
            AddressBook addressbook=(AddressBook) record.getValue();
            for(Contacts c : addressbook.contactsArrayList) {
                if(c.state.equalsIgnoreCase(stateName)) {
                    flag=1;
                    System.out.println(c);
                }
            }
        }
        if(flag==0)
            System.out.println("This State does not exists!");
    }
    //method to select options to search persons in city or state
    public static void searchPersonsByCityOrState() {
        System.out.println("Enter (C) to search by City\nEnter (S) to search by State\n");
        Scanner userInput=new Scanner(System.in);
        String searchInput=userInput.nextLine();
        if(searchInput.equalsIgnoreCase("C"))
            searchPersonByCity();
        else if(searchInput.equalsIgnoreCase("S"))
            searchPersonByState();
        else
            System.out.println("Invalid Input!");
    }
    //method to view options to search persons in city or state
    public static void viewPersonsByCityOrState() {
        System.out.println("Enter (C) to View by City\nEnter (S) to View by State\n");
        Scanner userInput=new Scanner(System.in);
        String input = userInput.nextLine();
        if (input.equalsIgnoreCase("C"))
            addressbook.viewPersonByCity();
        else if (input.equalsIgnoreCase("S"))
            addressbook.viewPersonByState();
        else
            System.out.println("Invalid Input!");

    }
}


