import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;
    static boolean[] visited;
    static List<Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];

        dp = new int[N + 1][2];
        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a].add(b);
            edges[b].add(a);
        }

        visited = new boolean[N + 1];
        visited[1] = true;
        visited = new boolean[N + 1];
        visited[1] = true;
        dfs(1, true);
        dfs(1, false);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static int dfs(int node, boolean isEarlyAdaptor) {
        if (dp[node][isEarlyAdaptor ? 1 : 0] >= 0) {
            return dp[node][isEarlyAdaptor ? 1 : 0];
        }

        int cnt = isEarlyAdaptor ? 1 : 0;

        List<Integer> edge = edges[node];

        for (Integer child : edge) {
            if (!visited[child]) {
                visited[child] = true;
                if (isEarlyAdaptor) {
                    cnt += Math.min(dfs(child, true), dfs(child, false));
                } else {
                    cnt += dfs(child, true);
                }
                visited[child] = false;
            }
        }

        dp[node][isEarlyAdaptor ? 1 : 0] = cnt;
        return cnt;
    }
}
