import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static List<Integer>[] edges;
    static boolean[] cut;
    static int[] visitedOrder;
    static int num = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new List[V + 1];
        visitedOrder = new int[V + 1];
        cut = new boolean[V + 1];

        for (int i = 1; i < V + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a].add(b);
            edges[b].add(a);
        }

        for (int i = 1; i < V + 1; i++) {
            if (visitedOrder[i] == 0) { // 아직 방문 안한 노드
                dfs(i, true);
            }
        }

        StringBuilder sb = new StringBuilder();
        int ans = 0;

        for (int i = 1; i < V + 1; i++) {
            if (cut[i]) {
                ans++;
            }
        }

        sb.append(ans).append("\n");

        for (int i = 1; i < V + 1; i++) {
            if (cut[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static int dfs(int node, boolean isRootNode) {
        visitedOrder[node] = num++;
        int result = visitedOrder[node];
        int child = 0;

        for (Integer edge : edges[node]) {
            if (visitedOrder[edge] == 0)  {
                child++;
                int rowOrder = dfs(edge, false);

                if (!isRootNode && rowOrder >= visitedOrder[node]) {
                    cut[node] = true;
                }

                result = Math.min(result, rowOrder);
            } else {
                result = Math.min(result, visitedOrder[edge]);
            }
        }

        if (isRootNode && child > 1) {
            cut[node] = true;
        }

        return result;
    }
}
