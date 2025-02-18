import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a;
    static int[] b;
    static int[] c;
    static int[] d;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[m + 1];
        b = new int[m + 1];
        c = new int[m + 1];
        d = new int[m + 1];

        c[0] = Integer.parseInt(st.nextToken());
        d[0] = Integer.parseInt(st.nextToken());

        dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            if (i - c[0] >= 0) {
                dp[0][i] = dp[0][i - c[0]] + d[0];
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j - c[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    for (int k = 1; k <= (j / c[i]); k++) {
                        if (a[i] - b[i] * k >= 0) {
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - c[i] * k] + d[i] * k);
                        }
                    }
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[m][n]);
    }
}
