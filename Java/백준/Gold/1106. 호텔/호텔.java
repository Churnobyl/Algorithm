import java.io.*;
import java.util.*;

public class Main {
    static int C, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] dp = new int[1101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int earn = Integer.parseInt(st.nextToken());

            for (int j = 1; j < C + earn; j++) {
                if (j - earn >= 0 && dp[j - earn] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - earn] + cost);
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = C; i < 1101; i++) {
            min = Math.min(min, dp[i]);
        }

        System.out.println(min);
    }
}