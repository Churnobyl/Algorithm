import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = ((j - 1 >= 0 ? dp[i - 1][j - 1] : 0) + (j + 1 < 10 ? dp[i - 1][j + 1] : 0)) % 1_000_000_000;
            }
        }

        long ans = 0;

        for (int i = 0; i < 10; i++) {
            ans = (ans + dp[N][i]) % 1_000_000_000;
        }

        System.out.println(ans);
    }
}
