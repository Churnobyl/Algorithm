import java.io.*;
import java.util.*;

public class Main {
    static long[] dp;
    static long[] sub;
    static int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N < 3) {
            System.out.println(N == 1 ? 2 : 7);
            return;
        }

        dp = new long[N + 1];
        sub = new long[N + 1];
        dp[0] = 1;
        sub[0] = 2;
        dp[1] = 2;
        sub[1] = 6;
        dp[2] = 7;
        sub[2] = 20;

        for (int i = 3; i < N + 1; i++) {
            dp[i] = (dp[i - 1] * 2 % MOD + dp[i - 2] * 3 % MOD + sub[i - 3]) % MOD;
            sub[i] = (sub[i - 1] + 2 * dp[i]) % MOD;
        }

        System.out.println(dp[N]);
    }
}