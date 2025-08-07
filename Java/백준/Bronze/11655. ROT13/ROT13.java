import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);

            if ('a' <= c && c <= 'z') {
                int idx = c - 'a';
                char d = (char)('a' + (idx + 13) % 26);
                sb.append(d);
            } else if ('A' <= c && c <= 'Z') {
                int idx = c - 'A';
                char d = (char)('A' + (idx + 13) % 26);
                sb.append(d);
            } else sb.append(c);
        }
        System.out.println(sb);
    }
}