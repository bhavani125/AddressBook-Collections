package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

import static com.bridgelabz.AddressBook.addressBook;

 public class AddressBookMain {
    static HashMap<String, AddressBook> addressbooks = new HashMap<String, AddressBook>();
    static AddressBook addressbook = new AddressBook();
    //Main method
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program ");
        Scanner userInput = new Scanner(System.in);
        int choice;
        String addressbookName = "Default";
        addressbooks.put(addressbookName, addressbook);
        do {
            System.out.println("Enter 1) To Create new Address book\n 2) To edit address books \n 3) To view all the address books\n 4)To Search Person By City Or State In All Address Books\n" +
                    " 5) To View Person by City or State in Current Address Book\n 6) To Count No. Of Persons by City Or State\n 7) To Sort Entries in AddressBook By Person's Name\n" +
                    " 8) To Sort Entries in AddressBook By City State ZipCode\n 9) To Exit");
            choice = userInput.nextInt();
            userInput.nextLine();
            switch (choice) {
                case 1://Creating New AddressBooks
                    CreateAddressBook();
                    break;
                case 2://Edit AddressBook like Add(),Delete(),duplicateCheck()...
                    EditAddressBook();
                    break;
                case 3:  // shows address book names
                    if (!addressBook.isEmpty()) {
                        System.out.println("Address book names : ");
                        for (String key : addressBook.keySet()) {
                            System.out.print(key);
                        }
                        System.out.println(" \n ");
                    } else {
                        System.out.println("Address book is empty.");
                    }
                    break;
                case 4://search Person By City Or State
                    searchPersonsByCityOrState();
                    break;
                case 5://view Person By City Or State
                    viewPersonsByCityOrState();
                    break;
                case 6://count By City Or State
                    countByOption();
                    break;
                case 7://Sorting Persons By alphabetical order
                    sortPersonsByName();
                    break;
                case 8://Sorting Persons By alphabetical order
                    SortEntriesByCityOrStateOrZipcode();
                    break;
                // exit
                default:
                    break;
            }
        }
        while (choice != 9);
    }
    //method to check whether addressBook contains given name
    public static boolean isKeyExists(String name) {
        return addressbooks.containsKey(name);
    }
    public static void display() {
        System.out.println("All Address Book Details\n");
        addressbooks.entrySet().stream().forEach(book -> {
            System.out.println("\"" + book.getKey() + "\"" + " " + book.getValue());
        });

    }
    //Creating method to enter new addressBook Name
    public static void CreateAddressBook() {
        ArrayList<Contacts> contactsArrayList = new ArrayList<>();
        System.out.println("Enter the new addressBook name : ");
        Scanner userInput=new Scanner(System.in);
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
    }
    // editing the previous address book
    public static void EditAddressBook(){
        ArrayList<Contacts> contactsArrayList = new ArrayList<>();
        System.out.println("Enter a address book name u want to edit : ");
        Scanner userInput=new Scanner(System.in);
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
            } else {
                    System.out.println("No such address book");
              }
        } catch (Exception e) {
                System.out.println("No such address book");
         }
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
    // Creating countByOption method to count element by option
    private static void countByOption() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Count City ");
        System.out.println("2. Count State");
        System.out.println("3. Back ");
        System.out.println("Enter Your Choice : ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                Map<String, Long> countCity = addressbook.contactsArrayList.stream()
                        .collect(Collectors.groupingBy(e -> e.getCity(), Collectors.counting()));
                System.out.println(countCity + "\n");
                break;
            case 2:
                Map<String, Long> countState = addressbook.contactsArrayList.stream()
                        .collect(Collectors.groupingBy(e -> e.getState(), Collectors.counting()));
                System.out.println(countState + "\n");
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid Option");
        }
    }
    //method to sort person by first name and last name
    private static void sortPersonsByName() {
        List<Contacts> sortedList = addressbook.contactsArrayList.stream()
                .sorted(Comparator.comparing(Contacts::getFirstName)
                        .thenComparing(Contacts::getLastName))
                .collect(Collectors.toList());
        System.out.println("\n SORTED LIST OF PERSONS\n");
        sortedList.forEach(System.out::println);
    }
    //method to sort person by city
    public static void sortPersonsByCity() {
        List<Contacts> sortedList = addressbook.contactsArrayList.stream()
                .sorted(Comparator.comparing(Contacts::getCity))
                .collect(Collectors.toList());
        System.out.println("\nSORTED LIST OF PERSONS BY CITY \n");
        sortedList.forEach(System.out::println);

    }
    //method to sort person by state
    public static void sortPersonsByState() {
        List<Contacts> sortedList = addressbook.contactsArrayList.stream()
                .sorted(Comparator.comparing(Contacts::getState))
                .collect(Collectors.toList());
        System.out.println("\nSORTED LIST OF PERSONS BY STATE\n");
        sortedList.forEach(System.out::println);

    }
    //method to sort person by ZipCode
    public static void sortPersonsByZip() {
        List<Contacts> sortedList = addressbook.contactsArrayList.stream()
                .sorted(Comparator.comparing(Contacts::getZip))
                .collect(Collectors.toList());
        System.out.println("\n--------- SORTED LIST OF PERSONS BY ZIP CODE ------------\n");
        sortedList.forEach(System.out::println);
    }
    //method to select option to sort by city ,state or zipCode
    public static void SortEntriesByCityOrStateOrZipcode() {
        Scanner userInput=new Scanner(System.in);
        System.out.println("Enter (C) to Sort by City\nEnter (S) to Sort by State\nEnter (Z) to Sort by Zip\n");
        System.out.print("Enter your choice:");
        String choice=userInput.nextLine();
        switch(choice) {
            case "C":
            case "c":sortPersonsByCity();
                break;
            case "S":
            case "s":sortPersonsByState();
                break;
            case "Z":
            case "z":sortPersonsByZip();
                break;
            default : System.out.println("Invalid Input");
        }
    }
}





