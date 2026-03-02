import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        final int TOTAL = 2015;

        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine().trim();
            boolean[] seen = new boolean[26];

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                seen[c - 'A'] = true;
            }

            int presentSum = 0;
            for (int i = 0; i < 26; i++) {
                if (seen[i]) presentSum += ('A' + i);
            }

            sb.append(TOTAL - presentSum).append('\n');
        }

        System.out.print(sb.toString());
    }
}