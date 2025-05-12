import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // dp[pos][lastDigit][mask]
        long[][][] dp = new long[N + 1][10][1 << 10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int len = 2; len <= N; len++) {
            for (int digit = 0; digit <= 9; digit++) {
                for (int prev = 0; prev <= 9; prev++) {
                    if (Math.abs(digit - prev) != 1) continue;

                    for (int mask = 0; mask < (1 << 10); mask++) {
                        int nextMask = mask | (1 << digit);
                        dp[len][digit][nextMask] = (dp[len][digit][nextMask] + dp[len - 1][prev][mask]) % MOD;
                    }
                }
            }
        }
        
        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + dp[N][i][(1 << 10) - 1]) % MOD;
        }

        System.out.println(answer);
    }
}
