import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 외판원 순회
 * TSP 알고리즘
 */
public class Main {
    static int N;
    static int[][] costs;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        costs = new int[N][N];
        dp = new int[N][1 << N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][1] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int bit = 0; bit < (1 << N); bit++) {
            for (int curr = 0; curr < N; curr++) {
                // 현재 curr도시가 bit에 포함되어 있지않으면 패스
                if ((bit & (1 << curr)) == 0) continue;

                // 다음 도시 찾기
                for (int next = 0; next < N; next++) {
                    if ((bit & (1 << next)) != 0 || costs[curr][next] == 0) {
                        continue;
                    }
                    if (dp[curr][bit] == Integer.MAX_VALUE) continue;

                    dp[next][(bit | (1 << next))] = Math.min(dp[next][bit | (1 << next)], dp[curr][bit] + costs[curr][next]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < N; i++) {
            if (costs[i][0] != 0 && dp[i][(1 << N) - 1] != Integer.MAX_VALUE) {
                ans = Math.min(ans, dp[i][(1 << N) - 1] + costs[i][0]);
            }
        }

        System.out.println(ans);
    }
}
