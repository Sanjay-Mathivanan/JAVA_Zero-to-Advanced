package Collections.ArrayList;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static ShoppingCart shoppingCart = new ShoppingCart();

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
                    shoppingCart.printItems();
                    break;

                case 2:
                    addItem();
                    break;

                case 3:
                    modifyItem();
                    break;

                case 4:
                    removeItem();
                    break;

                case 5:
                    searchItem();
                    break;

                case 6:
                    exit = true;
                    System.out.println("Thank You for Using Shopping Cart.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        }

        scanner.close();

    }

    // Menu
    public static void printMenu() {

        System.out.println("\n========== SHOPPING CART ==========");

        System.out.println("0. Print Menu");
        System.out.println("1. Display Shopping Cart");
        System.out.println("2. Add Item");
        System.out.println("3. Modify Item");
        System.out.println("4. Remove Item");
        System.out.println("5. Search Item");
        System.out.println("6. Exit");

    }

    // Add Item
    public static void addItem() {

        System.out.print("Enter Item Name : ");

        String item = scanner.nextLine();

        shoppingCart.addItem(item);

    }

    // Modify Item
    public static void modifyItem() {

        System.out.print("Enter Item Number : ");

        int itemNumber = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter New Item Name : ");

        String newItem = scanner.nextLine();

        shoppingCart.modifyItem(itemNumber - 1, newItem);

    }

    // Remove Item
    public static void removeItem() {

        System.out.print("Enter Item Number : ");

        int itemNumber = scanner.nextInt();

        scanner.nextLine();

        shoppingCart.removeItem(itemNumber - 1);

    }

    // Search Item
    public static void searchItem() {

        System.out.print("Enter Item Name : ");

        String item = scanner.nextLine();

        shoppingCart.searchItem(item);

    }

}
