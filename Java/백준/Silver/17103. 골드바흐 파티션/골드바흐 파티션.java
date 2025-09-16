import java.io.*;
import java.util.*;

public class Main {
    static int max;
    static int[] problems;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        problems = new int[T];

        for (int i = 0; i < T; i++) {
            problems[i] = Integer.parseInt(br.readLine());
            max = Math.max(problems[i], max);
        }

        sieve();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int p = problems[i];

            int cnt = 0;

            for (int j = 2; j <= p / 2; j++) {
                if (isPrime[j] && isPrime[p - j]) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void sieve() {
        isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < Math.sqrt(max) + 1; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < max + 1; j += i) {
                isPrime[j] = false;
            }
        }
    }
}