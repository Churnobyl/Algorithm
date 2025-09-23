import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// k = 0 -> 0, 1, 0, 1, 0, 1 -> block = 2
// k = 1 -> 0, 0, 1, 1, 0, 0 -> block = 4
// k = 2 -> 0, 0, 0, 0, 1, 1 -> block = 8

public class Main {
    static long sum(long n) {
        long total = 0L;
        for (int k = 0; k < 63; k++) {
            long bit = 1L << k; // 2^k
            if (bit > n) break;
            long block = bit << 1;
            long full = (n + 1) / block;
            long rem = (n + 1) % block;
            total += full * bit + Math.max(0L, rem - bit);
        }

        return total;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        System.out.println(sum(B) - sum(A - 1));
    }
}