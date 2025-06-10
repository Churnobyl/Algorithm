import java.io.*;
import java.util.*;

public class Main {
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        long ans = N;

        for (long i = 2; i * i <= N; i++) {
            if (N % i == 0) { // 소인수라면
                while (N % i == 0) {
                    N /= i;
                }
                ans -= ans / i;
            }
        }

        if (N > 1) {
            // N이 소수라면
            ans -= ans / N;
        }
        System.out.println(ans);
    }
}
