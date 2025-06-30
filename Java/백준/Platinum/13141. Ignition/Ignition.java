import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]>[] graph;
    static List<Edge> edgeList = new ArrayList<>();
    static class Edge {
        int u, v, l;
        Edge(int u, int v, int l) { this.u = u; this.v = v; this.l = l; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph[s].add(new int[]{e, l});
            graph[e].add(new int[]{s, l});
            edgeList.add(new Edge(s, e, l));
        }

        double ans = Double.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            double t = burnAll(i);
            ans = Math.min(ans, t);
        }
        System.out.printf("%.1f\n", ans);
    }

    static double burnAll(int start) {
        // Dijkstra
        double[] dist = new double[N + 1];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));
        dist[start] = 0;
        pq.add(new double[]{0, start});
        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            double d = cur[0];
            int u = (int) cur[1];
            if (dist[u] < d) continue;
            for (int[] next : graph[u]) {
                int v = next[0], len = next[1];
                if (dist[v] > dist[u] + len) {
                    dist[v] = dist[u] + len;
                    pq.add(new double[]{dist[v], v});
                }
            }
        }

        double ret = 0;
        for (int i = 1; i <= N; i++) ret = Math.max(ret, dist[i]);

        for (Edge edge : edgeList) {
            int u = edge.u, v = edge.v, l = edge.l;
            double meet = (dist[u] + dist[v] + l) / 2.0;
            ret = Math.max(ret, meet);
        }
        return ret;
    }
}
