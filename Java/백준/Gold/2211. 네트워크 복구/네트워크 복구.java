import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]>[] edges;
    static int[] dp;
    static int[] p;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        dp = new int[N + 1];
        p = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }

        dp[1] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges[A].add(new int[] {B, C});
            edges[B].add(new int[] {A, C});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        pq.add(new int[] {1, 0});

        while (!pq.isEmpty()) {
            int[] nxt = pq.poll();
            int node = nxt[0];
            int dist = nxt[1];

            if (dp[node] < dist) continue;

            List<int[]> edge = edges[node];

            for (int[] e : edge) {
                if (dp[e[0]] > dist + e[1]) {
                    dp[e[0]] = dist + e[1];
                    pq.add(new int[] {e[0], dp[e[0]]});
                    p[e[0]] = node;
                }
            }
        }

        for (int i = 2; i < N + 1; i++) {
            int current = i;

            while (current != 1) {
                int parent = p[current];
                String a = current + " " + parent;
                String b = parent + " " + current;

                if (!set.contains(a) && !set.contains(b)) {
                    set.add(a);
                }

                current = parent;
            }
        }

        System.out.println(set.size());

        StringBuilder sb = new StringBuilder();

        for (String s : set) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
