import java.io.*;
import java.util.*;

public class Main {
    static int N, D;
    static long[] stones, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        stones = new long[N];
        dp = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stones[i] = Long.parseLong(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        long answer = Long.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - D) {
                deque.pollFirst();
            }

            dp[i] = stones[i] + (deque.isEmpty() ? 0 : Math.max(dp[deque.peekFirst()], 0));

            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
