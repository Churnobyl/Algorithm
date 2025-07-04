import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    static final int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][10];

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        System.out.println(dp[N][9]);
    }
}
