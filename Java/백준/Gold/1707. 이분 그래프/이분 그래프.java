import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static int[] visited;
    static List<Integer>[] edges;
    static boolean isBipartiteGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            edges = new List[V + 1];
            visited = new int[V + 1];
            isBipartiteGraph = true;

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                if (edges[u] == null) edges[u] = new ArrayList<>();
                if (edges[v] == null) edges[v] = new ArrayList<>();

                edges[u].add(v);
                edges[v].add(u);
            }


            for (int j = 1; j < V + 1; j++) {
                if (visited[j] == 0) {
                    bfs(j);
                }
            }

            if (isBipartiteGraph) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void bfs(int node) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {node, 1});
        visited[node] = 1;

        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int n = next[0];
            int order = next[1];

            List<Integer> edge = edges[n];

            if (edge == null) continue;

            for (Integer e : edge) {
                if (visited[e] > 0 && visited[e] == order) {
                    isBipartiteGraph = false;
                    break;
                }

                if (visited[e] == 0) {
                    visited[e] = order == 1 ? 2 : 1;
                    queue.add(new int[] {e, order == 1 ? 2 : 1});
                }
            }
        }
    }
}
