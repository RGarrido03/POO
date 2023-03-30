package ap1;

public class LibraryItem {
    private final int id;
    private final String title;
    private boolean available;
    private String username;

    public LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
        this.available = true;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void checkout(String username) {
        this.available = false;
        this.username = username;
    }

    public void returnItem() {
        this.available = true;
        this.username = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getId() + ": " + this.getTitle() + ". ");

        if (available) {
            sb.append("Available.");
        } else {
            sb.append("Not available, borrowed by " + this.getUsername() + ".");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof LibraryItem)) {
            return false;
        }

        LibraryItem comparingObj = (LibraryItem) o;
        return comparingObj.getId() == this.getId();
    }

    @Override
    public int hashCode() {
        return this.getId();
    }
}
