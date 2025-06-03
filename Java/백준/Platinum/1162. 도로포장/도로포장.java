import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static List<int[]>[] edges;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        dp = new long[N + 1][K + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (edges[a] == null) edges[a] = new ArrayList<>();
            if (edges[b] == null) edges[b] = new ArrayList<>();

            edges[a].add(new int[] {b, w});
            edges[b].add(new int[] {a, w});
        }

        for (int i = 2; i < N + 1; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.add(new long[] {0, 1, K});

        while (!pq.isEmpty()) {
            long[] next = pq.poll();
            long dist = next[0];
            int node = (int)next[1];
            int rest = (int)next[2];

            if (dp[node][rest] < dist) continue;
            if (node == N) continue;

            List<int[]> edge = edges[node];

            for (int[] e : edge) {
                int arrive = e[0];
                int weight = e[1];

                if (dp[arrive][rest] > dp[node][rest] + weight) {
                    dp[arrive][rest] = dp[node][rest] + weight;
                    pq.add(new long[] {dp[arrive][rest], arrive, rest});
                }

                if (rest > 0) {
                    if (dp[arrive][rest - 1] > dp[node][rest]) {
                        dp[arrive][rest - 1] = dp[node][rest];
                        pq.add(new long[] {dp[arrive][rest - 1], arrive, rest - 1});
                    }
                }
            }
        }

        long answer = Long.MAX_VALUE;

        for (int i = 0; i < K + 1; i++) {
            answer = Math.min(answer, dp[N][i]);
        }

        System.out.println(answer);
    }
}
