import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;

            sb = new StringBuilder();

            int N = Integer.parseInt(line);

            dfs((int) Math.pow(3, N), false);
            System.out.println(sb);
        }
    }

    public static void dfs(int len, boolean isBlank) {
        if (isBlank) {
            sb.append(" ".repeat(len));
            return;
        }

        if (len == 1) {
            sb.append("-");
            return;
        }

        dfs(len / 3, false);
        dfs(len / 3, true);
        dfs(len / 3, false);
    }
}
