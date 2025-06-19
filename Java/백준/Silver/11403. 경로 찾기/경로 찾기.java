import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] edges, answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        edges = new boolean[N][N];
        answer = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                edges[i][j] = st.nextToken().equals("1");
            }
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            bfs(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j] ? 1 : 0).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int next = queue.poll();

            for (int i = 0; i < N; i++) {
                if (edges[next][i] && !visited[i]) {
                    visited[i] = true;
                    answer[node][i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
