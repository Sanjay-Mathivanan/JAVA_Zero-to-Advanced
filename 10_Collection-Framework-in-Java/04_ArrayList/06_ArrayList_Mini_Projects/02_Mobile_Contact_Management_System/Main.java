package Collections.ArrayList;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static MobilePhone mobile = new MobilePhone();

    public static void main(String[] args) {

        boolean exit = false;

        printMenu();

        while (!exit) {

            System.out.print("\nEnter Your Choice : ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {

                case 0:
                    printMenu();
                    break;

                case 1:
                    mobile.printName();
                    break;

                case 2:
                    addContact();
                    break;

                case 3:
                    modifyContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    searchContact();
                    break;

                case 6:
                    exit = true;
                    System.out.println("Exiting Mobile Contact Management System...");
                    break;

                default:
                    System.out.println("Invalid Choice.");

            }

        }

        scanner.close();

    }

    // Display Menu
    public static void printMenu() {

        System.out.println("\n========== MOBILE CONTACT MENU ==========");

        System.out.println("0. Print Menu");
        System.out.println("1. Display Contacts");
        System.out.println("2. Add Contact");
        System.out.println("3. Modify Contact");
        System.out.println("4. Remove Contact");
        System.out.println("5. Search Contact");
        System.out.println("6. Exit");

    }

    // Add Contact
    public static void addContact() {

        System.out.print("Enter Contact Name : ");

        String name = scanner.nextLine();

        mobile.addName(name);

    }

    // Modify Contact
    public static void modifyContact() {

        System.out.print("Enter Contact Number : ");

        int number = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter New Contact Name : ");

        String newName = scanner.nextLine();

        mobile.modifyItem(number - 1, newName);

    }

    // Remove Contact
    public static void removeContact() {

        System.out.print("Enter Contact Number : ");

        int number = scanner.nextInt();

        scanner.nextLine();

        mobile.removeItem(number - 1);

    }

    // Search Contact
    public static void searchContact() {

        System.out.print("Enter Contact Name : ");

        String name = scanner.nextLine();

        String result = mobile.searchItem(name);

        if (result != null) {

            System.out.println(result + " found in contacts.");

        } else {

            System.out.println("Contact not found.");

        }

    }

}
