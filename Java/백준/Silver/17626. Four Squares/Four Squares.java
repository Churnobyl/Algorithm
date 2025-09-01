import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });

        pq.add(new int[] {0, 0});
        dp[0] = 0;

        while (!pq.isEmpty()) {
            int[] nxt = pq.poll();
            int dist = nxt[0];
            int num = nxt[1];

            if (dp[num] < dist) continue;

            for (int i = 1; num + i * i <= n; i++) {
                int nextNum = num + i * i;
                if (dp[nextNum] > dp[num] + 1) {
                    dp[nextNum] = dp[num] + 1;
                    pq.add(new int[] {dp[nextNum], nextNum});
                }
            }
        }

        System.out.println(dp[n]);
    }
}
