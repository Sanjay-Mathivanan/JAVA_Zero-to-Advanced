package Collections.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {

    private List<String> contacts = new ArrayList<>();

    // Add Contact
    public void addName(String contact) {

        contacts.add(contact);

        System.out.println(contact + " added successfully.");

    }

    // Display Contacts
    public void printName() {

        if (contacts.isEmpty()) {

            System.out.println("No contacts available.");
            return;

        }

        System.out.println("\n----- Contact List -----");

        for (int i = 0; i < contacts.size(); i++) {

            System.out.println((i + 1) + ". " + contacts.get(i));

        }

    }

    // Modify Contact
    public void modifyItem(int position, String newContactName) {

        if (position >= 0 && position < contacts.size()) {

            String oldName = contacts.get(position);

            contacts.set(position, newContactName);

            System.out.println(oldName + " updated to " + newContactName);

        } else {

            System.out.println("Invalid Contact Number.");

        }

    }

    // Remove Contact
    public void removeItem(int position) {

        if (position >= 0 && position < contacts.size()) {

            String removedContact = contacts.remove(position);

            System.out.println(removedContact + " removed successfully.");

        } else {

            System.out.println("Invalid Contact Number.");

        }

    }

    // Search Contact
    public String searchItem(String contact) {

        int position = contacts.indexOf(contact);

        if (position >= 0) {

            return contacts.get(position);

        }

        return null;

    }

}
