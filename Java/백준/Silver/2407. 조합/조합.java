import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger[][] dp = new BigInteger[n + 1][m + 1];

        for (int i = 0; i <= m; i++) {
            dp[0][i] = BigInteger.ZERO;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = BigInteger.ONE;
            if (i == 0) continue;

            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
            }
        }

        System.out.println(dp[n][m]);
    }
}
