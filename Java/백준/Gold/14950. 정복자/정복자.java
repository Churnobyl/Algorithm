import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to, cost;
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static ArrayList<Edge>[] graph;
    static boolean[] visited;
    static int n, m, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited = new boolean[n + 1];

        int conquered = 1;
        int totalCost = 0;
        int addedCost = 0;

        visited[1] = true;
        for (Edge e : graph[1]) pq.offer(new Edge(e.to, e.cost));

        while (conquered < n) {
            Edge cur = pq.poll();
            if (visited[cur.to]) continue;

            totalCost += cur.cost + addedCost;
            addedCost += t;
            visited[cur.to] = true;
            conquered++;

            for (Edge e : graph[cur.to]) {
                if (!visited[e.to]) {
                    pq.offer(new Edge(e.to, e.cost));
                }
            }
        }

        System.out.println(totalCost);
    }
}
