import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long l = 1;
        long r = N * (long)N;
        long answer = 0;

        while (l <= r) {
            long mid = (l + r) / 2;

            long cnt = 0;

            for (int i = 1; i < N + 1; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (cnt >= K) {
                r = mid - 1;
                answer = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
