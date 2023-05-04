package p10;

import java.util.HashMap;
import java.util.Map;

public class Ex1 {

    public static void main(String[] args) {
        Map<GenderEnum, Book> bookHashMap = new HashMap<>();

        bookHashMap.put(GenderEnum.DRAMA, new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        bookHashMap.put(GenderEnum.FANTASY, new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954));
        bookHashMap.put(GenderEnum.SCIENCEFICTION, new Book("Dune", "Frank Herbert", 1965));
        bookHashMap.put(GenderEnum.MYSTERY, new Book("The Maltese Falcon", "Dashiell Hammett", 1930));
        bookHashMap.put(GenderEnum.HORROR, new Book("The Shining", "Stephen King", 1977));

        bookHashMap.get(GenderEnum.DRAMA).setYear(1926);
        bookHashMap.get(GenderEnum.FANTASY).setTitle("The Hobbit");
        bookHashMap.get(GenderEnum.SCIENCEFICTION).setAuthor("Frank Herbert");

        bookHashMap.remove(GenderEnum.MYSTERY);

        System.out.println(bookHashMap);
        System.out.println(bookHashMap.keySet());
        System.out.println(bookHashMap.values());
    }
}
