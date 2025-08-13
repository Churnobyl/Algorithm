import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int[] arr, prefixSum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            K = Integer.parseInt(br.readLine());
            arr = new int[K];
            prefixSum = new int[K + 1];
            dp = new int[K + 1][K + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < K; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                prefixSum[j + 1] = prefixSum[j] + arr[j];
                dp[j][j] = 0;
            }

            for (int len = 2; len <= K; len++) {
                for (int j = 0; j < K - len + 1; j++) {
                    int k = j + len - 1;
                    dp[j][k] = Integer.MAX_VALUE;

                    for (int l = j; l < k; l++) {
                        int cost = dp[j][l] + dp[l + 1][k] + (prefixSum[k + 1] - prefixSum[j]);
                        dp[j][k] = Math.min(dp[j][k], cost);
                    }
                }
            }

            sb.append(dp[0][K - 1]).append("\n");
        }

        System.out.println(sb);

    }
}