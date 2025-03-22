import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static final int INF = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];
        for (int j = 1; j < M; j++) {
            dp[0][j] = dp[0][j - 1] + map[0][j];
        }

        for (int i = 1; i < N; i++) {
            int[] leftToRight = new int[M];
            int[] rightToLeft = new int[M];

            leftToRight[0] = dp[i - 1][0] + map[i][0];
            for (int j = 1; j < M; j++) {
                leftToRight[j] = Math.max(leftToRight[j - 1], dp[i - 1][j]) + map[i][j];
            }

            rightToLeft[M - 1] = dp[i - 1][M - 1] + map[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                rightToLeft[j] = Math.max(rightToLeft[j + 1], dp[i - 1][j]) + map[i][j];
            }

            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(leftToRight[j], rightToLeft[j]);
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}
