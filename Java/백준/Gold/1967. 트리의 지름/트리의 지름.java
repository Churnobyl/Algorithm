import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<int[]>[] edges;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        edges = new List[n + 1];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (edges[p] == null) edges[p] = new ArrayList<>();
            edges[p].add(new int[]{c, cost});
        }

        int a = dfs(1, 0);
        answer = Math.max(answer, a);
        System.out.println(answer);
    }

    private static int dfs(int parent, int cost) {
        List<int[]> edge = edges[parent];

        if (edge == null) return cost;

        List<Integer> result = new ArrayList<>();

        for (int[] e : edge) {
            result.add(dfs(e[0], e[1]));
        }

        Collections.sort(result, Collections.reverseOrder());

        if (result.size() > 1) {
            answer = Math.max(answer, result.get(0) + result.get(1));
        }

        return cost + result.get(0);
    }
}
