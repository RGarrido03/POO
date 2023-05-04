package p10;

import java.util.*;

public class Ex2 {

    private static Book randomizeBook(Map<GenderEnum, List<Book>> hashMap, GenderEnum key) {
        List<Book> list = hashMap.get(key);
        return list.get((int) (Math.random() * list.size()));
    }

    public static void main(String[] args) {
        SortedMap<GenderEnum, List<Book>> bookTreeMap = new TreeMap<>();

        bookTreeMap.put(GenderEnum.DRAMA, new ArrayList<>());
        bookTreeMap.put(GenderEnum.FANTASY, new ArrayList<>());
        bookTreeMap.put(GenderEnum.SCIENCEFICTION, new ArrayList<>());
        bookTreeMap.put(GenderEnum.MYSTERY, new ArrayList<>());
        bookTreeMap.put(GenderEnum.HORROR, new ArrayList<>());

        bookTreeMap.get(GenderEnum.DRAMA).add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        bookTreeMap.get(GenderEnum.FANTASY).add(new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954));
        bookTreeMap.get(GenderEnum.FANTASY).add(new Book("The Hobbit", "J. R. R. Tolkien", 1937));
        bookTreeMap.get(GenderEnum.SCIENCEFICTION).add(new Book("Dune", "Frank Herbert", 1965));
        bookTreeMap.get(GenderEnum.MYSTERY).add(new Book("The Maltese Falcon", "Dashiell Hammett", 1930));
        bookTreeMap.get(GenderEnum.HORROR).add(new Book("The Shining", "Stephen King", 1977));

        bookTreeMap.get(GenderEnum.DRAMA).get(0).setYear(1926);
        bookTreeMap.get(GenderEnum.FANTASY).get(0).setTitle("The Hobbit");
        bookTreeMap.get(GenderEnum.SCIENCEFICTION).get(0).setAuthor("Frank Herbert");

        bookTreeMap.remove(GenderEnum.MYSTERY);

        System.out.println(bookTreeMap);
        System.out.println(bookTreeMap.keySet());
        for (List<Book> list : bookTreeMap.values()) {
            for (Book book : list) {
                System.out.println(book);
            }
        }

        System.out.println(randomizeBook(bookTreeMap, GenderEnum.DRAMA));
        System.out.println(randomizeBook(bookTreeMap, GenderEnum.FANTASY));
    }
}
