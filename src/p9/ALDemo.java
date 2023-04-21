package p9;

import java.util.*;

import p5.DateYMD;
import p6.Person;
import p7.Date;
import p7.DateND;

public class ALDemo {
    public static void main(String[] args) {
        // ArrayList c1 ----------------------------------------
        ArrayList<Integer> c1 = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10)
            c1.add(i);
        System.out.println("Size: " + c1.size());

        for (Integer integer : c1) System.out.println("Elemento: " + integer);


        // ArrayList c2 ----------------------------------------
        ArrayList<String> c2 = new ArrayList<>();
        c2.add("Vento");
        c2.add("Calor");
        c2.add("Frio");
        c2.add("Chuva");
        System.out.println(c2);

        Collections.sort(c2);
        System.out.println(c2);

        c2.remove("Frio");
        c2.remove(0);
        System.out.println(c2);
        System.out.println(c2.contains("Frio"));
        System.out.println(c2.indexOf("Chuva"));


        // HashSet c3 ------------------------------------------
        Set<Person> c3 = new HashSet<>();
        c3.add(new Person("Rúben", 15558256, new DateYMD(8, 11, 2003)));
        c3.add(new Person("Diogo", 1, new DateYMD(25, 3, 2003)));
        c3.add(new Person("Diana", 2, new DateYMD(1, 4, 2000)));
        c3.add(new Person("Zé", 3, new DateYMD(1, 1, 2003)));
        c3.add(new Person("João", 4, new DateYMD(1, 1, 2003)));
        c3.add(new Person("João", 4, new DateYMD(1, 1, 2003))); // Duplicate

        for (Person p : c3) System.out.println("Person: " + p);


        // TreeSet c4 ------------------------------------------
        Set<Date> c4 = new TreeSet<>();
        c4.add(new p7.DateYMD(20, 4, 2023));
        c4.add(new p7.DateYMD(8, 11, 2003));
        c4.add(new DateND(2500));
        c4.add(new DateND(5000));
        c4.add(new DateND(1));
        c4.add(new p7.DateYMD(1, 1, 2000)); // Duplicate

        for (Date d : c4) System.out.println("Date: " + d);
    }
}