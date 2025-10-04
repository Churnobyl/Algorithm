import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        StringBuilder sb = new StringBuilder();

        while (!(line = br.readLine()).equals("0 0.00")) {
            StringTokenizer st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            m = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5f);
            dp = new int[m + 1];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = (int)(Double.parseDouble(st.nextToken()) * 100 + 0.5f);

                for (int j = p; j < m + 1; j++) {
                    dp[j] = Math.max(dp[j - p] + c, dp[j]);
                }
            }

            sb.append(dp[m]).append("\n");
        }

        System.out.println(sb);
    }
}