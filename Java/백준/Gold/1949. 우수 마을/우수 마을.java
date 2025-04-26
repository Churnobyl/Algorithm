import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] population;
    static List<Integer>[] edges;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        setting();
        run();
    }

    private static void run() {
        dfs(0);
        System.out.println(Math.max(dp[0][0], dp[0][1]));
    }

    private static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0;
        dp[node][1] = population[node];

        for (int next : edges[node]) {
            if (!visited[next]) {
                dfs(next);

                dp[node][0] += Math.max(dp[next][0], dp[next][1]);
                dp[node][1] += dp[next][0];
            }
        }
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        population = new int[N];
        edges = new ArrayList[N];
        visited = new boolean[N];
        dp = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            edges[a].add(b);
            edges[b].add(a);
        }
    }
}
