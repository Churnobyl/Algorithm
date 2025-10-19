import java.io.*;
import java.util.*;

public class Main {
    static int N, M, start, end;
    static long[] earn, dist;
    static List<int[]> edges = new ArrayList<>();
    static final long INF = Long.MIN_VALUE;

    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new int[]{s, e, cost});
        }

        earn = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) earn[i] = Long.parseLong(st.nextToken());

        dist = new long[N];
        Arrays.fill(dist, INF);
        dist[start] = earn[start];

        for (int i = 0; i < N - 1; i++) {
            for (int[] edge : edges) {
                int s = edge[0], e = edge[1];
                long cost = edge[2];
                if (dist[s] == INF) continue;
                if (dist[e] < dist[s] - cost + earn[e])
                    dist[e] = dist[s] - cost + earn[e];
            }
        }

        boolean[] cycle = new boolean[N];
        for (int[] edge : edges) {
            int s = edge[0], e = edge[1];
            long cost = edge[2];
            if (dist[s] == INF) continue;
            if (dist[e] < dist[s] - cost + earn[e]) {
                cycle[s] = true;
                cycle[e] = true;
            }
        }

        // cycle 노드에서 end까지 도달 가능?
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) graph.get(edge[0]).add(edge[1]);

        boolean infinite = false;
        for (int i = 0; i < N; i++) {
            if (cycle[i] && canReach(i, end, new boolean[N])) {
                infinite = true;
                break;
            }
        }

        if (infinite) System.out.println("Gee");
        else if (dist[end] == INF) System.out.println("gg");
        else System.out.println(dist[end]);
    }

    static boolean canReach(int start, int target, boolean[] visited) {
        if (start == target) return true;
        visited[start] = true;
        for (int nxt : graph.get(start)) {
            if (!visited[nxt] && canReach(nxt, target, visited)) return true;
        }
        return false;
    }
}
