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

        dp = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            int pages = Integer.parseInt(st.nextToken());

            for (int j = N; j >= days; j--) {
                dp[j] = Math.max(dp[j - days] + pages, dp[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
