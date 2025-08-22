import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] t, p;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 2];
        t = new int[N + 2];
        p = new int[N + 2];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            t[i] = T;
            p[i] = P;
        }

        for (int i = 1; i < N + 1; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);

            int next = i + t[i];
            if (next <= N + 1) {
                dp[next] = Math.max(dp[next], dp[i] + p[i]);
            }
        }
        dp[N + 1] = Math.max(dp[N + 1], dp[N]);
        System.out.println(dp[N + 1]);
    }
}
