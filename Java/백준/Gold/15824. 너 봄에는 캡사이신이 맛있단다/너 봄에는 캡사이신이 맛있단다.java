import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static final int MOD = 1_000_000_007;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        long[] pow2 = new long[N];
        pow2[0] = 1;
        for (int i = 1; i < N; i++) pow2[i] = pow2[i - 1] * 2 % MOD;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            long add = (pow2[i] - pow2[N - 1 - i] + MOD) % MOD;
            answer = (answer + arr[i] * add % MOD) % MOD;
        }

        System.out.println(answer);
    }
}
