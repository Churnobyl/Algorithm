import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());

            dp = new int[M + 1];
            dp[0] = 1;

            for (int j = 0; j < N; j++) {
                int coin = arr[j];

                for (int k = 1; k < M + 1; k++) {
                    if (k - coin >= 0) {
                        dp[k] += dp[k - coin];
                    }
                }
            }

            sb.append(dp[M]).append("\n");
        }

        System.out.println(sb);
    }
}