import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            if (line.length() == 0) {
                sb.append('\n');
                continue;
            }

            char first = line.charAt(0);
            if (first >= 'a' && first <= 'z') {
                first = (char) (first - 'a' + 'A');
            }

            sb.append(first);
            if (line.length() > 1) sb.append(line.substring(1));
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
