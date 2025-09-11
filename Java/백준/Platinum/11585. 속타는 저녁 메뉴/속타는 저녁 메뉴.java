import java.io.*;
import java.util.*;

public class Main {
    static int N, correct;
    static char[] meat, roulette;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        meat = new char[N];
        roulette = new char[2 * N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            meat[i] = st.nextToken().charAt(0);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            roulette[N + i] = roulette[i] = st.nextToken().charAt(0);
        }

        int[] pi = getPi();
        int j = 0;

        for (int i = 0; i < 2 * N - 1; i++) {
            while (j > 0 && meat[j] != roulette[i]) {
                j = pi[j - 1];
            }

            if (meat[j] == roulette[i]) {
                j++;
                if (j == N) {
                    correct++;
                    j = pi[j - 1];
                }
            } else {
                j = pi[j];
            }
        }

        int a = N;
        int b = correct;

        while (b > 0) {
            int t = a % b;
            a = b;
            b = t;
        }

        System.out.println(correct / a + "/" + N / a);
    }

    private static int[] getPi() {
        int[] pi = new int[N];
        int j = 0;

        for (int i = 1; i < N; i++) {
            while (j > 0 && meat[i] != meat[j]) {
                j = pi[j - 1];
            }

            if (meat[i] == meat[j]) {
                pi[i] = ++j;
            }
        }

        return pi;
    }
}
