import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] energy, ans;
    static List<int[]>[] edges;
    static boolean[] visited;
    static List<Integer> stackDist = new ArrayList<>();
    static List<Integer> stackNode = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        energy = new int[n + 1];
        ans = new int[n + 1];
        edges = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            energy[i] = Integer.parseInt(br.readLine());
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[a].add(new int[]{b, c});
            edges[b].add(new int[]{a, c});
        }

        dfs(1, 0);

        for (int i = 1; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }

    static void dfs(int node, int dist) {
        visited[node] = true;

        stackDist.add(dist);
        stackNode.add(node);

        int remainEnergy = energy[node];
        int idx = binarySearch(remainEnergy);
        ans[node] = stackNode.get(idx);

        for (int[] next : edges[node]) {
            if (!visited[next[0]]) {
                dfs(next[0], dist + next[1]);
            }
        }

        stackDist.remove(stackDist.size() - 1);
        stackNode.remove(stackNode.size() - 1);
    }

    static int binarySearch(int remainEnergy) {
        int l = 0, r = stackDist.size() - 1, res = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (stackDist.get(stackDist.size() - 1) - stackDist.get(mid) <= remainEnergy) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return stackNode.get(res) == 1 ? res : res;
    }
}
