package p10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ex2 {
    private static Book randomizeBook(HashMap<String, List<Book>> hashMap, String key) {
        List<Book> list = hashMap.get(key);
        return list.get((int) (Math.random() * list.size()));
    }
    public static void main(String[] args) {
        HashMap<String, List<Book>> bookHashMap = new HashMap<>();

        bookHashMap.put("Drama", new ArrayList<>());
        bookHashMap.put("Fantasy", new ArrayList<>());
        bookHashMap.put("Science Fiction", new ArrayList<>());
        bookHashMap.put("Mystery", new ArrayList<>());
        bookHashMap.put("Horror", new ArrayList<>());

        bookHashMap.get("Drama").add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        bookHashMap.get("Fantasy").add(new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954));
        bookHashMap.get("Fantasy").add(new Book("The Hobbit", "J. R. R. Tolkien", 1937));
        bookHashMap.get("Science Fiction").add(new Book("Dune", "Frank Herbert", 1965));
        bookHashMap.get("Mystery").add(new Book("The Maltese Falcon", "Dashiell Hammett", 1930));
        bookHashMap.get("Horror").add(new Book("The Shining", "Stephen King", 1977));

        bookHashMap.get("Drama").get(0).setYear(1926);
        bookHashMap.get("Fantasy").get(0).setTitle("The Hobbit");
        bookHashMap.get("Science Fiction").get(0).setAuthor("Frank Herbert");

        bookHashMap.remove("Mystery");

        System.out.println(bookHashMap);
        System.out.println(bookHashMap.keySet());
        for (List<Book> list : bookHashMap.values()) {
            for (Book book : list) {
                System.out.println(book);
            }
        }

        System.out.println(randomizeBook(bookHashMap, "Drama"));
        System.out.println(randomizeBook(bookHashMap, "Fantasy"));
    }
}
