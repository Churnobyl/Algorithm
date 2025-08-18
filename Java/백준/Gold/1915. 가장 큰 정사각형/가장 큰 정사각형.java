import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][m];
        int maxSide = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(
                                Math.min(dp[i-1][j], dp[i][j-1]),
                                dp[i-1][j-1]
                        ) + 1;
                    }
                    if (dp[i][j] > maxSide) maxSide = dp[i][j];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        System.out.println(maxSide * maxSide);
    }
}
