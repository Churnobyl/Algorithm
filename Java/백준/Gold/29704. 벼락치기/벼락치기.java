import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static int[] d, m;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        d = new int[N + 1];
        m = new int[N + 1];

        dp = new int[N + 1][T + 1];

        int initial = 0;

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            m[i] = Integer.parseInt(st.nextToken());
            initial += m[i];
        }
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], initial);
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < T + 1; j++) {
                if (j - d[i] >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - d[i]] - m[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][T]);
    }
}
