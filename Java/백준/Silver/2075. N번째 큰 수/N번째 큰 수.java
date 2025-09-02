import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o2[0], o1[0]);
        }
    });

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            pq.add(new int[] {graph[N - 1][i], i, N - 1});
        }

        for (int i = 1; i < N; i++) {
            int[] nxt = pq.poll();
            int idx = nxt[1];
            int depth = nxt[2];

            if (depth == 0) continue;
            pq.add(new int[] {graph[depth - 1][idx], idx, depth - 1});
        }

        System.out.println(pq.peek()[0]);
    }
}
