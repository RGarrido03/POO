package ap1;

import java.util.ArrayList;

public class Library implements ILibrary {
    private final ArrayList<LibraryItem> itemsArray = new ArrayList<>();

    public void addItem(LibraryItem item) {
        itemsArray.add(item);
    }

    public void removeItem(LibraryItem item) {
        for (int i = 0; i < itemsArray.size(); i++) {
            if (itemsArray.get(i).equals(item)) {
                itemsArray.remove(i);
                return;
            }
        }

        System.out.println("Item not found. Input correct type and ID.");
    }

    public LibraryItem searchForItem(String title) {
        for (LibraryItem temp : itemsArray) {
            if (temp.getTitle().equals(title)) {
                return temp;
            }
        }

        return null;
    }

    public boolean borrowItem(int itemId, String username) {
        for (LibraryItem temp : itemsArray) {
            if (temp.getId() == itemId && temp.isAvailable()) {
                temp.checkout(username);
                return true;
            }
        }

        return false;
    }

    public boolean returnItem(int itemId) {
        for (LibraryItem temp : itemsArray) {
            if (temp.getId() == itemId && !temp.isAvailable()) {
                temp.returnItem();
                return true;
            }
        }

        return false;
    }

    public void printInventory() {
        for (LibraryItem temp : itemsArray) {
            System.out.println(temp.toString());
        }
    }
}
