import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] requests;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        requests = new int[N];

        int max = 0;
        int total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, requests[i]);
            total += requests[i];
        }

        M = Integer.parseInt(br.readLine());

        if (total <= M) {
            System.out.println(max);
            return;
        }

        int left = 0;
        int right = max;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isPossible(int limit) {
        long sum = 0;

        for (int r : requests) {
            sum += Math.min(r, limit);
        }

        return sum <= M;
    }
}
