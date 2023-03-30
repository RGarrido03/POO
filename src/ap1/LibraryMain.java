package ap1;

import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        ILibrary library = new Library();
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        int id = 0;

        while (!choice.equals("7")) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Search for item");
            System.out.println("4. Borrow item");
            System.out.println("5. Return item");
            System.out.println("6. Print inventory");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    
                    System.out.print("Choose a type:\n1. Book\n2. DVD\n>> ");
                    String type = scanner.nextLine();

                    switch (type) {
                        case "1" -> {
                            System.out.print("Author: ");
                            String author = scanner.nextLine();

                            library.addItem(new Book(id++, title, author));
                        }
                        case "2" -> {
                            System.out.print("Duration: ");
                            int duration = Integer.parseInt(scanner.nextLine());

                            try {
                                library.addItem(new DVD(id++, title, duration));
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        default -> System.out.println("Invalid option.");
                    }
                }
                case "2" -> {
                    library.printInventory();

                    System.out.print("ID of item to remove: ");
                    int removeId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Type of item to remove:\n1. Book\n2. DVD\n>> ");
                    int removeType = Integer.parseInt(scanner.nextLine());

                    switch (removeType) {
                        case 1 -> {
                            Book temp = new Book(removeId, "", "");
                            library.removeItem(temp);
                        }
                        case 2 -> {
                            DVD temp = new DVD(removeId, "", 1);
                            library.removeItem(temp);
                        }
                        default -> System.out.println("Invalid option.");
                    }
                }
                case "3" -> {
                    System.out.print("Title: ");
                    String searchTitle = scanner.nextLine();

                    LibraryItem found = library.searchForItem(searchTitle);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Item not found.");
                    }
                }
                case "4" -> {
                    library.printInventory();

                    System.out.print("ID of item to borrow: ");
                    int borrowId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Username: ");
                    String borrowUsername = scanner.nextLine();

                    if (library.borrowItem(borrowId, borrowUsername)) {
                        System.out.println("Item borrowed successfully.");
                    } else {
                        System.out.println("Item not borrowed because it's not available.");
                    }
                }
                case "5" -> {
                    library.printInventory();

                    System.out.print("ID of item to return: ");
                    int returnId = Integer.parseInt(scanner.nextLine());

                    if (library.returnItem(returnId)) {
                        System.out.println("Item returned successfully.");
                    } else {
                        System.out.println("Item not returned because it was already available.");
                    }
                }
                case "6" -> {
                    library.printInventory();
                }
                case "7" -> {
                    System.out.println("Exiting program.");
                }
                default -> {
                    System.out.println("Invalid option.\n");
                }
            }
        }
        scanner.close();
    }
}
