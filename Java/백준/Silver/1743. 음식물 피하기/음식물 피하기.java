import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static int answer;
    static boolean[][] map;
    static boolean[][] visited;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            map[y][x] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[] {y, x});
        visited[y][x] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] nxt = q.poll();
            int y1 = nxt[0];
            int x1 = nxt[1];

            for (int i = 0; i < 4; i++) {
                int ny = y1 + dy[i];
                int nx = x1 + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (!visited[ny][nx] && map[ny][nx]) {
                        visited[ny][nx] = true;
                        cnt++;
                        q.add(new int[] {ny, nx});
                    }
                }
            }
        }

        answer = Math.max(answer, cnt);
    }
}
