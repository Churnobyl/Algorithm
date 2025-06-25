import java.io.*;

public class Main {
    static final int MOD = 10007;
    static int N;
    static long[][] dp = new long[14][53];
    static long[] comb = new long[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 3; i++) comb[i] = C(4, i);

        dp[0][0] = 1;
        for (int rank = 0; rank < 13; rank++) {
            for (int cnt = 0; cnt <= N; cnt++) {
                if (dp[rank][cnt] == 0) continue;
                for (int take = 0; take <= 3; take++) {
                    if (cnt + take <= N) {
                        dp[rank + 1][cnt + take] = (dp[rank + 1][cnt + take] + dp[rank][cnt] * comb[take]) % MOD;
                    }
                }
            }
        }

        long total = comb(52, N);
        long noFour = dp[13][N];
        long ans = (total - noFour + MOD) % MOD;
        System.out.println(ans);
    }
    
        static long C(int n, int k) {
        if (k > n) return 0;
        long res = 1;
        for (int i = 0; i < k; i++) {
            res = res * (n - i) / (i + 1);
        }
        return res;
    }

    static long comb(int n, int k) {
        long res = 1;
        for (int i = 0; i < k; i++) {
            res = res * (n - i) % MOD;
        }
        for (int i = 1; i <= k; i++) {
            res = res * pow(i, MOD - 2) % MOD;
        }
        return res;
    }

    static long pow(long x, long n) {
        long ret = 1;
        while (n > 0) {
            if ((n & 1) == 1) ret = ret * x % MOD;
            x = x * x % MOD;
            n >>= 1;
        }
        return ret;
    }
}
