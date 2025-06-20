import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        P = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            dp[i] = Math.max(dp[i], P[i]);

            for (int j = i + 1; j < N + 1; j++) {
                dp[j] = Math.max(dp[j - i] + dp[i], dp[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
