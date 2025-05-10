import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dfs(0, 0);
        System.out.println(sb.toString());
    }

    private static void dfs(int depth, int num) {
        if (depth >= N) {
            sb.append(num).append("\n");
            return;
        }

        int cache = num * 10;

        for (int i = 0; i < 10; i++) {
            int candidate = cache + i;

            if (isPrimeNumber(candidate)) {
                dfs(depth + 1, candidate);
            }
        }
    }

    private static boolean isPrimeNumber(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }

        return true;
    }
}
