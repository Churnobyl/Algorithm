import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] fw;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        fw = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dp[s][e] = w;
            dp[e][s] = w;
            fw[s][e] = e;
            fw[e][s] = s;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (i == j) continue;
                    if (dp[i][k] == Integer.MAX_VALUE || dp[k][j] == Integer.MAX_VALUE) continue;
                    int lowestCandidate = dp[i][k] + dp[k][j];

                    if (dp[i][j] > lowestCandidate) {
                        dp[i][j] = lowestCandidate;
                        fw[i][j] = fw[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (fw[i][j] == 0) sb.append("-").append(" ");
                else sb.append(fw[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
