import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] weight;
    static ArrayList<Integer>[] tree;
    static int[][] dp;
    static boolean[] visited;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        weight = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        dfs(1);

        int maxVal = Math.max(dp[1][0], dp[1][1]);
        System.out.println(maxVal);

        answer.clear();
        Arrays.fill(visited, false);
        tracking(1, false);

        Collections.sort(answer);
        for (int v : answer) System.out.print(v + " ");
    }

    static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0; // node 미포함
        dp[node][1] = weight[node]; // node 포함

        for (int next : tree[node]) {
            if (!visited[next]) {
                dfs(next);
                dp[node][0] += Math.max(dp[next][0], dp[next][1]);
                dp[node][1] += dp[next][0];
            }
        }
    }

    static void tracking(int node, boolean included) {
        visited[node] = true;

        if (!included && dp[node][1] > dp[node][0]) {
            answer.add(node);
            for (int next : tree[node]) {
                if (!visited[next]) tracking(next, true);
            }
        } else {
            for (int next : tree[node]) {
                if (!visited[next]) tracking(next, false);
            }
        }
    }
}
