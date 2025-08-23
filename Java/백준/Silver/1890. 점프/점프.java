import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
        static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1) continue;
                if (dp[i][j] == 0) continue;
                int ny = 0;
                int nx = 0;

                // 우
                ny = i;
                nx = j + map[i][j];
                if (nx < N) {
                    dp[ny][nx] += dp[i][j];
                }

                // 밑
                ny = i + map[i][j];
                nx = j;

                if (ny < N) {
                    dp[ny][nx] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
