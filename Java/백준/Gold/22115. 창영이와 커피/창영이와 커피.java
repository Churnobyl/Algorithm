import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] C;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < N + 1; i++) {
            int c = C[i];

            for (int j = K; j >= c; j--) {
                if (dp[j - c] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - c] + 1);
                }
            }
        }

        if (dp[K] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }
}
