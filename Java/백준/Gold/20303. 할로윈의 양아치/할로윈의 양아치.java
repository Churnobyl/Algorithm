import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] candies;
    static List<Integer>[] edges;
    static List<int[]> taken = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candies = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
        }

        edges = new List[N + 1];

        for (int i = 1; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            if (visited[i]) continue;

            Queue<Integer> queue = new ArrayDeque<>();
            int cnt = 1;
            int sum = candies[i];
            visited[i] = true;
            queue.add(i);

            while (!queue.isEmpty()) {
                int next = queue.poll();

                List<Integer> e = edges[next];

                for (Integer n : e) {
                    if (visited[n]) continue;
                    cnt++;
                    sum += candies[n];
                    visited[n] = true;
                    queue.add(n);
                }
            }

            taken.add(new int[] {cnt, sum});
        }

        int[] dp = new int[K];

        for (int[] data : taken) {
            int friend = data[0];
            int candy = data[1];

            for (int i = K - 1; i >= 0; i--) {
                if (i - friend >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - friend] + candy);
                }
            }
        }

        System.out.println(dp[K - 1]);
    }
}