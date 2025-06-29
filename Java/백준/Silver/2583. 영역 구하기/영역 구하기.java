import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    static boolean[][] map;
    static List<Integer> result = new ArrayList<>();
    static boolean[][] visited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    map[k][j] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && !map[i][j]) {
                    bfs(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        Collections.sort(result);

        for (Integer i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[] {y, x});

        int cnt = 1;
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] nxt = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = nxt[0] + dy[i];
                int nx = nxt[1] + dx[i];

                if (0 <= ny && ny < M && 0 <= nx && nx < N && !visited[ny][nx] && !map[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new int[] {ny, nx});
                    cnt++;
                }
            }
        }

        result.add(cnt);
    }
}
