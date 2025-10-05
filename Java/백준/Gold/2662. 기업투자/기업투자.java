import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr, dp;
    static int[][] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M + 1][N + 1];
        dp = new int[M + 1][N + 1];
        path = new int[M + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());

            for (int j = 1; j < M + 1; j++) {
                arr[j][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= M; i++) { // 기업 종류
            for (int k = 0; k <= N; k++) { // 총 투자 금액
                dp[i][k] = dp[i - 1][k];
                path[i][k] = 0;

                for (int j = 1; j <= k; j++) { // i번째 기업에 j만원 투자하기
                    int newProfit = dp[i - 1][k - j] + arr[i][j];

                    if (newProfit > dp[i][k]) {
                        dp[i][k] = newProfit;
                        path[i][k] = j;
                    }
                }
            }
        }

        System.out.println(dp[M][N]);

        int[] result = new int[M + 1];
        int i = N;

        for (int j = M; j >= 1; j--) {
            result[j] = path[j][i];
            i -= path[j][i];
        }

        for (int j = 1; j < M + 1; j++) {
            System.out.print(result[j] + " ");
        }
    }
}