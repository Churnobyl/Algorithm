import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, cost, id;
        boolean isActivated;

        Edge(int to, int cost, int id, boolean isActivated) {
            this.to = to;
            this.cost = cost;
            this.id = id;
            this.isActivated = isActivated;
        }
    }

    static class Node implements Comparable<Node> {
        int idx;
        long dist;

        Node(int idx, long dist) {
            this.idx = idx;
            this.dist = dist;
        }

        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    static int N, M;
    static List<Edge>[] graph;
    static long[] dist;
    static Edge[] parentEdge;  // 최단 경로로 도달할 때 사용한 Edge
    static boolean[] result;   // 각 무빙워크의 전원 상태 결과

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, d, i, true));
//            graph[u].add(new Edge(v, 2 * d, i, false)); // 껐을 때 이득
            graph[v].add(new Edge(u, 2 * d, i, false));
        }

        dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        parentEdge = new Edge[N];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.dist > dist[cur.idx]) continue;

            for (Edge e : graph[cur.idx]) {
                if (dist[e.to] > dist[cur.idx] + e.cost) {
                    dist[e.to] = dist[cur.idx] + e.cost;
                    parentEdge[e.to] = e;
                    pq.offer(new Node(e.to, dist[e.to]));
                }
            }
        }

        long sum = 0;
        result = new boolean[M];

        for (int i = 0; i < N; i++) {
            sum += dist[i];
            if (i == 0) continue;
            Edge e = parentEdge[i];
            if (e != null && e.isActivated) result[e.id] = true;
        }

        System.out.println(sum);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(result[i] ? "1 " : "0 ").append(" ");
        }

        System.out.println(sb);
    }
}
