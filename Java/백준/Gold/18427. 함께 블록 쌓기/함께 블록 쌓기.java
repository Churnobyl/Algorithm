import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][H + 1];
        dp[0][0] = 1;

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> blocks = new ArrayList<>();

            while (st.hasMoreTokens()) {
                int block = Integer.parseInt(st.nextToken());
                blocks.add(block);
            }

            for (int j = 0; j < H + 1; j++) {
                dp[i][j] = dp[i - 1][j]; // 안 쓴 거
                for (Integer block : blocks) {
                    if (j - block >= 0) {
                        dp[i][j] += dp[i - 1][j - block];
                    }
                }

                dp[i][j] %= 10007;
            }
        }

        System.out.println(dp[N][H]);
    }
}
