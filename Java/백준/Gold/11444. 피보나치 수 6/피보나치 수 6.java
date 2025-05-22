import java.io.*;
import java.util.*;

public class Main {
    static Map<Long, long[][]> dp = new HashMap<>();
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        dp.put(1L, new long[][] {{1, 1}, {1, 0}});

        long[][] result = divide(n);

        System.out.println(result[0][1]);
    }

    private static long[][] divide(long n) {
        if (dp.containsKey(n)) return dp.get(n);

        if (n % 2 == 0) {
            return multiplyMatrix(n, divide(n / 2), divide(n / 2));
        } else {
            return multiplyMatrix(n, divide(n / 2 + 1), divide(n / 2));
        }
    }

    public static long[][] multiplyMatrix(long n, long[][] matrix1, long[][] matrix2) {
        long[][] newMatrix = new long[2][2];

        newMatrix[0][0] = (matrix1[0][0] * matrix2[0][0] % MOD + matrix1[0][1] * matrix2[1][0] % MOD) % MOD;
        newMatrix[0][1] = (matrix1[0][0] * matrix2[0][1] % MOD + matrix1[0][1] * matrix2[1][1] % MOD) % MOD;
        newMatrix[1][0] = (matrix1[1][0] * matrix2[0][0] % MOD + matrix1[1][1] * matrix2[1][0] % MOD) % MOD;
        newMatrix[1][1] = (matrix1[1][0] * matrix2[0][1] % MOD + matrix1[1][1] * matrix2[1][1] % MOD) % MOD;

        if (!dp.containsKey(n)) dp.put(n, newMatrix);
        return newMatrix;
    }
}
