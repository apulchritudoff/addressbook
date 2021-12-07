import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Create a arraylist of class addressBook
        ArrayList<addressBook> addressBookArray = new ArrayList<addressBook>();

        boolean quit = false;

        do {

            // ask user to input a value from 1 to 6
            System.out.println("Please enter a number from 1 to 6");
            System.out.println("1. Add a new address book entry");
            System.out.println("2. Remove an address book entry");
            System.out.println("3. Search for a contact");
            System.out.println("4. Print all contacts");
            System.out.println("5. Delete all contacts");
            System.out.println("6. Exit");

            // Create a scanner object
            Scanner input = new Scanner(System.in);

            // Create a variable to store user input
            int userInput = input.nextInt();

            // Make a switch case for the user input from 1 to 6
            switch (userInput) {
                case 1:
                    // Create a new addressBook object
                    addressBook newAddressBook = new addressBook();

                    // ask user to input values for the new address book entry
                    System.out.println("Please enter the first name of the contact");
                    newAddressBook.setFirstName(input.next());

                    System.out.println("Please enter the last name of the contact");
                    newAddressBook.setLastName(input.next());

                    System.out.println("Please enter the phone number of the contact");
                    newAddressBook.setPhoneNumber(input.nextLong());

                    // make sure the email address entry is unique
                    boolean unique = true;
                    do {
                        System.out.println("Please enter the email address of the contact");
                        newAddressBook.setEmail(input.next());
                        for (int i = 0; i < addressBookArray.size(); i++) {
                            if (newAddressBook.getEmail().equals(addressBookArray.get(i).getEmail())) {
                                System.out.println("The email address is already in the address book");
                                unique = false;
                            } else {
                                unique = true;
                            }
                        }
                    } while (!unique);

                    // add the new address book entry to the arraylist
                    addressBookArray.add(newAddressBook);


                    break;
                case 2:

                    // ask user to input the email of the address book entry to be deleted
                    System.out.println("Please enter the email of the contact to be deleted");
                    String deleteEmail = input.next();

                    // loop through the arraylist to find the address book entry to be deleted
                    for (int i = 0; i < addressBookArray.size(); i++) {
                        if (deleteEmail.equals(addressBookArray.get(i).getEmail())) {
                            addressBookArray.remove(i);
                            System.out.println("The contact has been deleted");
                            break;
                        } else {
                            System.out.println("The contact does not exist");
                        }
                    }

                    break;
                case 3:

                    // ask user if they want to search by first name, last name, phone number, or
                    // email
                    System.out.println("Please enter the search criteria");
                    System.out.println("1. Search by first name");
                    System.out.println("2. Search by last name");
                    System.out.println("3. Search by phone number");
                    System.out.println("4. Search by email");

                    // Create a variable to store user input
                    int searchCriteria = input.nextInt();

                    // Make a switch case for the user input from 1 to 4
                    switch (searchCriteria) {
                        case 1:
                            // ask user to input the first name of the contact
                            System.out.println("Please enter the first name of the contact");
                            String searchFirstName = input.next();

                            // loop through the arraylist to find the address book entry to be printed
                            for (int i = 0; i < addressBookArray.size(); i++) {
                                if (searchFirstName.equals(addressBookArray.get(i).getFirstName())) {
                                    System.out.println("The contact exists");
                                    addressBookArray.get(i).toString();
                                    break;
                                } else {
                                    System.out.println("The contact does not exist");
                                }
                            }

                            break;
                        case 2:
                            // ask user to input the last name of the contact
                            System.out.println("Please enter the last name of the contact");
                            String searchLastName = input.next();

                            // loop through the arraylist to find the address book entry to be printed
                            for (int i = 0; i < addressBookArray.size(); i++) {
                                if (searchLastName.equals(addressBookArray.get(i).getLastName())) {
                                    System.out.println("The contact exists");
                                    addressBookArray.get(i).toString();
                                    break;
                                } else {
                                    System.out.println("The contact does not exist");
                                }
                            }

                            break;
                        case 3:
                            // ask user to input the phone number of the contact
                            System.out.println("Please enter the phone number of the contact");
                            long searchPhoneNumber = input.nextLong();

                            // loop through the arraylist to find the address book entry to be printed
                            for (int i = 0; i < addressBookArray.size(); i++) {
                                if (searchPhoneNumber == addressBookArray.get(i).getPhoneNumber()) {
                                    System.out.println("The contact exists");
                                    addressBookArray.get(i).toString();
                                    break;
                                } else {
                                    System.out.println("The contact does not exist");
                                }
                            }

                            break;

                        case 4:
                            // ask user to input the email of the contact
                            System.out.println("Please enter the email of the contact");
                            String searchEmail = input.next();

                            // loop through the arraylist to find the address book entry to be printed
                            for (int i = 0; i < addressBookArray.size(); i++) {
                                if (searchEmail.equals(addressBookArray.get(i).getEmail())) {
                                    System.out.println("The contact exists");
                                    addressBookArray.get(i).toString();
                                    break;
                                } else {
                                    System.out.println("The contact does not exist");
                                }
                            }

                            break;
                    }
                case 4:
                    // loop through the arraylist to pint all the address book entries
                    for (int i = 0; i < addressBookArray.size(); i++) {
                        System.out.println(addressBookArray.get(i).getFirstName());
                        System.out.println(addressBookArray.get(i).getLastName());
                        System.out.println(addressBookArray.get(i).getPhoneNumber());
                        System.out.println(addressBookArray.get(i).getEmail());
                    }

                    break;
                case 5:
                    // delete all the address book entries
                    addressBookArray.clear();
                    System.out.println("All the entries have been deleted");

                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

        } while (!quit);
    }

}
