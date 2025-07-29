import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] isNotPrime;
    static List<Integer> primeNum = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        isNotPrime = new boolean[N + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i * i < N + 1; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j < N + 1; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        for (int i = 0; i < N + 1; i++) {
            if (!isNotPrime[i]) primeNum.add(i);
        }

        int cnt = 0;

        int l = 0;
        int total = 0;

        for (int r = 0; r < primeNum.size(); r++) {
            total += primeNum.get(r);

            if (total > N) {
                while (total > N) {
                    total -= primeNum.get(l++);
                }
            }

            if (total == N) cnt++;
        }

        System.out.println(cnt);
    }
}
