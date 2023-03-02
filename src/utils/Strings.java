package utils;

public class Strings {
    public static StringBuilder centerString(String str, int total_len) {
        StringBuilder sb = new StringBuilder();
        int num_spaces = total_len - str.length();

        for (int i = 0; i < (num_spaces / 2); i++) {
            sb.append(" ");
        }
        sb.append(str);
        for (int i = (num_spaces / 2); i < num_spaces; i++) {
            sb.append(" ");
        }

        return sb;
    }
}
