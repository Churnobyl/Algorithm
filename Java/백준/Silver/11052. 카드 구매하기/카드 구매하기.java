import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] P;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        P = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (j - i >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i - 1][j - i] + P[i], dp[i][j - i] + P[i]));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][N]);
    }
}
