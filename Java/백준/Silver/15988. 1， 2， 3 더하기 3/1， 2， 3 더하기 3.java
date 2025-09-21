import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dp;
    static int[] problems;
    static int maxSize;
    static int MOD = 1_000_000_009;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        problems = new int[T];

        for (int i = 0; i < T; i++) {
            problems[i] = Integer.parseInt(br.readLine());
            maxSize = Math.max(maxSize, problems[i]);
        }

        dp = new int[maxSize + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < maxSize + 1; i++) {
            dp[i] = ((dp[i - 3] + dp[i - 2]) % MOD + dp[i - 1]) % MOD;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            sb.append(dp[problems[i]]).append("\n");
        }

        System.out.println(sb);
    }
}