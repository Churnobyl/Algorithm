import java.io.*;

public class Main {
    static final int MOD = 1_000_000_007;

    static long[][] mul(long[][] a, long[][] b) {
        int n = a.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j] % MOD) % MOD;
        return res;
    }

    static long[][] pow(long[][] a, long n) {
        int len = a.length;
        long[][] res = new long[len][len];
        for (int i = 0; i < len; i++) res[i][i] = 1;
        while (n > 0) {
            if ((n & 1) == 1) res = mul(res, a);
            a = mul(a, a);
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        if (N % 2 == 1) {
            System.out.println(0);
            return;
        }
        long k = N / 2;

        long[][] A = {
                {4, MOD - 1, 0},
                {1, 0, 0},
                {0, 1, 0}
        };

        long[] base = {11, 3, 1};

        if (k == 0) {
            System.out.println(1);
            return;
        } else if (k == 1) {
            System.out.println(3);
            return;
        } else if (k == 2) {
            System.out.println(11);
            return;
        }

        long[][] Ak = pow(A, k - 2);
        long res = 0;
        for (int i = 0; i < 3; i++) {
            res = (res + Ak[0][i] * base[i] % MOD) % MOD;
        }
        System.out.println(res);
    }
}
