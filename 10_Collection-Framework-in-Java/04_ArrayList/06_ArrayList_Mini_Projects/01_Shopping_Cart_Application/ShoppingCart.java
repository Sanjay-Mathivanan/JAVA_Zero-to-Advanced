package Collections.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<String> cart = new ArrayList<>();

    // Add Item
    public void addItem(String item) {
        cart.add(item);
        System.out.println(item + " added successfully.");
    }

    // Display Items
    public void printItems() {

        if (cart.isEmpty()) {
            System.out.println("\nShopping cart is empty.");
            return;
        }

        System.out.println("\nShopping Cart Items");

        for (int i = 0; i < cart.size(); i++) {
            System.out.println((i + 1) + ". " + cart.get(i));
        }
    }

    // Modify Item
    public void modifyItem(int position, String newItem) {

        if (position >= 0 && position < cart.size()) {

            String oldItem = cart.get(position);

            cart.set(position, newItem);

            System.out.println(oldItem + " updated to " + newItem);

        } else {

            System.out.println("Invalid Item Number.");

        }
    }

    // Remove Item
    public void removeItem(int position) {

        if (position >= 0 && position < cart.size()) {

            String removedItem = cart.remove(position);

            System.out.println(removedItem + " removed successfully.");

        } else {

            System.out.println("Invalid Item Number.");

        }
    }

    // Search Item
    public void searchItem(String item) {

        int index = cart.indexOf(item);

        if (index >= 0) {

            System.out.println(item + " found at position " + (index + 1));

        } else {

            System.out.println(item + " not found.");

        }

    }

}
