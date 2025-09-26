import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[] arr;
    static List<int[]>[] edges;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        edges = new List[n + 1];

        for (int i = 1; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            edges[a].add(new int[] {b, l});
            edges[b].add(new int[] {a, l});
        }

        for (int i = 1; i < n + 1; i++) {
            findProbability(i);
        }

        System.out.println(answer);
    }

    private static void findProbability(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> queue = new ArrayDeque<>();
        dist[start] = 0;
        queue.add(new int[] {start, 0});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int currentDist = current[1];

            if (currentDist > dist[node]) continue;

            for (int[] edge : edges[node]) {
                int next = edge[0];
                int edgeLength = edge[1];
                int newDist = currentDist + edgeLength;
                
                if (newDist <= m && newDist < dist[next]) {
                    dist[next] = newDist;
                    queue.add(new int[] {next, newDist});
                }
            }
        }
        int itemCnt = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) {
                itemCnt += arr[i];
            }
        }

        answer = Math.max(answer, itemCnt);
    }
}