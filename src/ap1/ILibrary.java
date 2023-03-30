package ap1;

public interface ILibrary {
    public void addItem(LibraryItem item);
    public void removeItem(LibraryItem item);
    public LibraryItem searchForItem(String title);
    public boolean borrowItem(int itemId, String username);
    public boolean returnItem(int itemId);
    public void printInventory();
}
