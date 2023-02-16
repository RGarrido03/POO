package p1;

public class StringExample {
    public static void main(String[] args) {
        String s1 = "programar em Java";

        System.out.printf("%s é engraçado! :)\n", s1.split(" ")[0]);
        System.out.printf("É giro %s\n", s1);

        for (int i = 0; i < 14; i++) {
            System.out.printf("vamos %s na aula %d\n", s1, i);
        }
    }
}
