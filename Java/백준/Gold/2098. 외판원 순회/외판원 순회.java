import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 외판원 순회 - 동적 계획법
 */
public class Main {
    static int N;
    static int[][] weight;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weight = new int[N][N];
        dp = new int[N][1 << N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][1] = 0; // 0번째 도시에서 시작, 0번째 도시 방문처리하고 0으로 초기화

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                weight[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 방문지
        for (int visited = 1; visited < (1 << N); visited++) {
            for (int currentCity = 0; currentCity < N; currentCity++) {
                // 현재 curr도시가 bit에 포함되어 있지않으면 패스
                if ((visited & (1 << currentCity)) == 0) continue;

                // 다음 도시 찾기
                for (int nextCity = 0; nextCity < N; nextCity++) {
                    // 이미 방문한 도시거나, 갈 수 있는 경로가 없을 경우 패스
                    if ((visited & (1 << nextCity)) != 0 || weight[currentCity][nextCity] == 0) {
                        continue;
                    }
                    //
                    if (dp[currentCity][visited] == Integer.MAX_VALUE) continue;

                    dp[nextCity][(visited | (1 << nextCity))] =
                            Math.min(dp[nextCity][visited | (1 << nextCity)], dp[currentCity][visited] + weight[currentCity][nextCity]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < N; i++) {
            if (weight[i][0] != 0 && dp[i][(1 << N) - 1] != Integer.MAX_VALUE) {
                ans = Math.min(ans, dp[i][(1 << N) - 1] + weight[i][0]);
            }
        }

        System.out.println(ans);
    }
}
