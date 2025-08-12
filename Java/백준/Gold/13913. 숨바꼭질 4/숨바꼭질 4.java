import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] dp, prev;
    static int MAX = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[MAX];
        prev = new int[MAX];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });

        pq.add(new int[]{0, N});

        while (!pq.isEmpty()) {
            int[] nxt = pq.poll();
            int dist = nxt[0];
            int pos = nxt[1];

            if (pos == K) {
                break;
            }

            int[] m = new int[]{pos + 1, pos - 1, pos * 2};

            for (int i = 0; i < 3; i++) {
                if (0 <= m[i] && m[i] < MAX && dp[pos] + 1 < dp[m[i]]) {
                    dp[m[i]] = dp[pos] + 1;
                    prev[m[i]] = pos;
                    pq.add(new int[]{dist + 1, m[i]});
                }
            }
        }

        System.out.println(dp[K]);
        int[] moves = new int[dp[K] + 1];
        int p = 0;

        for (int i = dp[K]; i >= 0; i--) {
            if (i == dp[K]) {
                p = K;
            } else {
                p = prev[p];
            }
            moves[i] = p;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < dp[K] + 1; i++) {
            sb.append(moves[i]).append(" ");
        }
        System.out.println(sb);
    }
}