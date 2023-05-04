package p10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ex2 {

    private static Book randomizeBook(HashMap<GenderEnum, List<Book>> hashMap, GenderEnum key) {
        List<Book> list = hashMap.get(key);
        return list.get((int) (Math.random() * list.size()));
    }

    public static void main(String[] args) {
        HashMap<GenderEnum, List<Book>> bookHashMap = new HashMap<>();

        bookHashMap.put(GenderEnum.DRAMA, new ArrayList<>());
        bookHashMap.put(GenderEnum.FANTASY, new ArrayList<>());
        bookHashMap.put(GenderEnum.SCIENCEFICTION, new ArrayList<>());
        bookHashMap.put(GenderEnum.MYSTERY, new ArrayList<>());
        bookHashMap.put(GenderEnum.HORROR, new ArrayList<>());

        bookHashMap.get(GenderEnum.DRAMA).add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        bookHashMap.get(GenderEnum.FANTASY).add(new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954));
        bookHashMap.get(GenderEnum.FANTASY).add(new Book("The Hobbit", "J. R. R. Tolkien", 1937));
        bookHashMap.get(GenderEnum.SCIENCEFICTION).add(new Book("Dune", "Frank Herbert", 1965));
        bookHashMap.get(GenderEnum.MYSTERY).add(new Book("The Maltese Falcon", "Dashiell Hammett", 1930));
        bookHashMap.get(GenderEnum.HORROR).add(new Book("The Shining", "Stephen King", 1977));

        bookHashMap.get(GenderEnum.DRAMA).get(0).setYear(1926);
        bookHashMap.get(GenderEnum.FANTASY).get(0).setTitle("The Hobbit");
        bookHashMap.get(GenderEnum.SCIENCEFICTION).get(0).setAuthor("Frank Herbert");

        bookHashMap.remove(GenderEnum.MYSTERY);

        System.out.println(bookHashMap);
        System.out.println(bookHashMap.keySet());
        for (List<Book> list : bookHashMap.values()) {
            for (Book book : list) {
                System.out.println(book);
            }
        }

        System.out.println(randomizeBook(bookHashMap, GenderEnum.DRAMA));
        System.out.println(randomizeBook(bookHashMap, GenderEnum.FANTASY));
    }
}
