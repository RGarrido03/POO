package p1;

public class PescadaDeRaboNaBoca {
    public static void main(String[] args) {
        simpleRecursion(100);
    }

    public static void simpleRecursion(int x) {
        System.out.println(x);
        x--;
        if (x > 0) {
            simpleRecursion(x);
        }
    }
}
