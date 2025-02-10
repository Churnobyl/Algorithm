import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] W, V;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        setting();
        solve();
    }

    private static void solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j - W[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][K + 1];

        W = new int[N + 1];
        V = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
    }
}
