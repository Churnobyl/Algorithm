import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int base = 1;

            while (K > 0) {
                int num = Math.min(base, K);
                int v = V * num;
                int c = C * num;

                for (int j = M; j >= v; j--) {
                    dp[j] = Math.max(dp[j - v] + c, dp[j]);
                }

                K -= num;
                base <<= 1;
            }
        }

        System.out.println(dp[M]);
    }
}