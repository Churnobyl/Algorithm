import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;

        int allMin = Integer.MAX_VALUE;
        int eachMin = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int all = Integer.parseInt(st.nextToken());
            int each = Integer.parseInt(st.nextToken());
            allMin = Math.min(allMin, all);
            eachMin = Math.min(eachMin, each);
        }

        int[] dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            dp[i] = Math.min(dp[i - 1] + eachMin, (i - 6 >= 0 ? dp[i - 6] : 0) + allMin);
        }

        System.out.println(dp[N]);
    }
}
