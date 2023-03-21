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
        System.out.println();
        String name = UserInput.inputString(sc, "Name:");
        int cc = UserInput.inputInt(sc, "CC:");

        DateYMD dateOfBirth;
        Contact contactTemp;

        try {
            int year = UserInput.inputInt(sc, "Year of birth:");
            int month = UserInput.inputInt(sc, "Month of birth:");
            int day = UserInput.inputInt(sc, "Day of birth:");
            dateOfBirth = new DateYMD(day, month, year);

            Person person = new Person(name, cc, dateOfBirth);

            for (Contact contact : contacts.values()) {
                if (contact.equals(person)) {
                    String option = UserInput.inputString(sc, "Person already exists. Do you still want to add it? (y/n)");
                    if (option.equals("y") || option.equals("Y") || option.equals("yes") || option.equals("Yes")) {
                        break;
                    } else {
                        return;
                    }
                }
            }

            int phone = UserInput.inputInt(sc, "Phone:");
            String email = UserInput.inputString(sc, "Email:");
            contactTemp = new Contact(person, phone, email);

            contacts.put(contactTemp.getId(), contactTemp);
            System.out.println("Contact added successfully.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeContact (Scanner sc) {
        if (listContacts() != 0) {
            int id = UserInput.inputInt(sc, "Select contact ID to change:");
            int option = UserInput.inputInt(sc, "1. Change name\n2. Change phone\n3. Change e-mail\n>> ");

            switch (option) {
                case 1 -> {
                    String name = UserInput.inputString(sc, "New name:");
                    contacts.get(id).getPerson().setName(name);
                }
                case 2 -> {
                    int phone = UserInput.inputInt(sc, "New phone:");
                    try {
                        contacts.get(id).setPhone(phone);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    String email = UserInput.inputString(sc, "New e-mail:");
                    try {
                        contacts.get(id).setEmail(email);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                default -> System.out.println("Invalid option. No changes made.");
            }
        }
    }

    private static void removeContact (Scanner sc) {
        int count;
        int option = UserInput.inputInt(sc, "1. List all contacts\n2. Search contact\n>> ");
        switch (option) {
            case 1 -> count = listContacts();
            case 2 -> count = searchContact(sc);
            default -> {
                System.out.println("Invalid option.");
                count = 0;
            }
        }

        if (count >= 0) {
            option = UserInput.inputInt(sc, "Select contact ID to remove:");

            if (contacts.containsKey(option)) {
                contacts.remove(option);
            } else {
                System.out.println("Invalid ID.");
            }
        }
    }

    private static int searchContact (Scanner sc) {
        // Very inneficient method below. Its computational complexity is O(n).
        // What is the best way to search for a contact? The HashMap keys are the contacts' IDs, so they're not that useful.
        // A possible workaround for the number would be ordering the contacts' IDs by phone number, so that binary search could be used.
        //
        // If I remember any data structure that can help on this, I'll change this method or put that on a comment.
        // Either way, my code is always updated at github.com/RGarrido03.
        // Suggestions are welcome, thanks! :)

        int option = UserInput.inputInt(sc, "1. Search by name\n2. Search by phone\n>> ");
        int count = 0;

        switch (option) {
            case 1 -> {
                String name = UserInput.inputString(sc, "Name:");
                for (Contact contact : contacts.values()) {
                    if (contact.getPerson().getName().contains(name)) {
                        System.out.println(contact);
                        count++;
                    }
                }
            }
            case 2 -> {
                int phone = UserInput.inputInt(sc, "Phone (-1 for empty):");
                for (Contact contact : contacts.values()) {
                    if (contact.getPhone() == phone) {
                        System.out.println(contact);
                        count++;
                    }
                }
            }
            default -> System.out.println("Invalid option.");
        }

        if (count == 0) {
            System.out.println("No contacts found.");
        }
        return count;
    }

    private static int listContacts () {
        System.out.println("Contacts:");

        // Transverse the HashMap and print each contact
        for (Contact contact : contacts.values()) {
            System.out.println(contact.toString());
        }

        if (contacts.size() == 0) {
            System.out.println("No contacts found");
        }
        return contacts.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int option = mainMenu(sc);

            switch (option) {
                case 1 -> {
                    System.out.print("\033\143");
                    addContact(sc);
                    System.out.println();
                }
                case 2 -> {
                    System.out.print("\033\143");
                    changeContact(sc);
                    System.out.println();
                }
                case 3 -> {
                    System.out.print("\033\143");
                    removeContact(sc);
                    System.out.println();
                }
                case 4 -> {
                    System.out.print("\033\143");
                    searchContact(sc);
                    System.out.println();
                }
                case 5 -> {
                    System.out.print("\033\143");
                    listContacts();
                    System.out.println();
                }
                case 0 -> {
                    sc.close();
                    System.exit(0);
                }
                default -> {
                    System.out.print("\033\143");
                    System.out.println("Invalid option.\n");
                }
            }
        }
    }
}
