import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        Set<String> set = new TreeSet<>();

        StringBuilder a = new StringBuilder();

        for (int i = S.length() - 1; i >= 0; i--) {
            a.insert(0, S.charAt(i));
            set.add(a.toString());
        }

        StringBuilder sb = new StringBuilder();

        for (String s : set) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
