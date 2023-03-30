package ap1;

public class Book extends LibraryItem {
    private final String author;

    public Book(int id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        return "Book " + super.toString() + " Author: " + this.getAuthor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Book)) {
            return false;
        }

        Book comparingObj = (Book) o;
        return super.equals(comparingObj);
    }
}
