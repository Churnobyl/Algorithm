import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int MOD = 9_901;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][3];
        dp[1][0] = 3;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i < N + 1; i++) {
            dp[i][1] = dp[i - 1][0];
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][0] = (dp[i][1] + (2 * dp[i][2]) % MOD);
        }
        System.out.println(dp[N][0] % MOD);
    }
}
