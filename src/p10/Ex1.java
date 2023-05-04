package p10;

import java.util.HashMap;

public class Ex1 {

    public static void main(String[] args) {
        HashMap<String, Book> bookHashMap = new HashMap<>();

        bookHashMap.put("Drama", new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        bookHashMap.put("Fantasy", new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954));
        bookHashMap.put("Science Fiction", new Book("Dune", "Frank Herbert", 1965));
        bookHashMap.put("Mystery", new Book("The Maltese Falcon", "Dashiell Hammett", 1930));
        bookHashMap.put("Horror", new Book("The Shining", "Stephen King", 1977));

        bookHashMap.get("Drama").setYear(1926);
        bookHashMap.get("Fantasy").setTitle("The Hobbit");
        bookHashMap.get("Science Fiction").setAuthor("Frank Herbert");

        bookHashMap.remove("Mystery");

        System.out.println(bookHashMap);
        System.out.println(bookHashMap.keySet());
        System.out.println(bookHashMap.values());
    }
}
