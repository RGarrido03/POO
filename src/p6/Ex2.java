package p6;

import p5.DateYMD;
import utils.UserInput;

import java.util.HashMap;
import java.util.Scanner;

public class Ex2 {
    private static final HashMap<Integer, Contact> contacts = new HashMap<>();

    private static int mainMenu (Scanner sc) {
        System.out.println("1. Add contact");
        System.out.println("2. Change contact");
        System.out.println("3. Remove contact");
        System.out.println("4. Search contact");
        System.out.println("5. List contacts");
        System.out.println("0. Exit");
        System.out.print(">> ");

        return UserInput.inputInt(sc, null);
    }

    private static void addContact (Scanner sc) {
        String name = UserInput.inputString(sc, "Name:");
        int cc = UserInput.inputInt(sc, "CC:");
        DateYMD dateOfBirth;
        Contact contactTemp;

        try {
            int year = UserInput.inputInt(sc, "Year of birth");
            int month = UserInput.inputInt(sc, "Month of birth");
            int day = UserInput.inputInt(sc, "Day of birth");
            dateOfBirth = new DateYMD(year, month, day);

            int phone = UserInput.inputInt(sc, "Phone:");
            String email = UserInput.inputString(sc, "Email:");
            contactTemp = new Contact(new Person(name, cc, dateOfBirth), phone, email);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        // TODO: Check if contact already exists
        contacts.put(contactTemp.getId(), contactTemp);
    }

    private static void changeContact (Scanner sc) {
        // TODO: Complete this method
    }

    private static void removeContact (Scanner sc) {
        // TODO: Use either listContacts() or searchContact()
        listContacts();
        int option = UserInput.inputInt(sc, "Select contact ID to remove");

        if (contacts.containsKey(option)) {
            contacts.remove(option);
        } else {
            System.out.println("Invalid ID");
        }
    }

    private static void searchContact (Scanner sc) {
        // TODO: Complete this method
    }

    private static void listContacts () {
        System.out.println("Contacts:");

        // Transverse the HashMap and print each contact
        for (Contact contact : contacts.values()) {
            System.out.println(contact.toString());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int option = mainMenu(sc);

            switch (option) {
                case 1 -> addContact(sc);
                case 2 -> changeContact(sc);
                case 3 -> removeContact(sc);
                case 4 -> searchContact(sc);
                case 5 -> listContacts();
                case 0 -> {
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
