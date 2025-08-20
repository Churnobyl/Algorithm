import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static List<Integer>[] edges;
    static int[] dp;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        edges = new List[N + 1];
        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (edges[a] == null) edges[a] = new ArrayList<>();
            edges[a].add(b);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });
        pq.add(new int[] {0, X});
        dp[X] = 0;

        while (!pq.isEmpty()) {
            int[] nxt = pq.poll();
            int dist = nxt[0];
            int node = nxt[1];

            if (dp[node] < dist) continue;

            List<Integer> edge = edges[node];

            if (edge == null) continue;

            for (int e : edge) {
                if (dp[e] > dist + 1) {
                    dp[e] = dist + 1;
                    pq.add(new int[] {dist + 1, e});
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N + 1; i++) {
            if (dp[i] == K) sb.append(i).append("\n");
        }

        if (sb.toString().isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(sb);
    }
}
