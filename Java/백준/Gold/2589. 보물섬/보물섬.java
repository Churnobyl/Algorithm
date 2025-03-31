import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer;
    static boolean[][] map;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = (line.charAt(j) == 'L');
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int y, int x) {
        boolean[][] visited = new boolean[N][M];

        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[] {y, x, 0});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] nxt = queue.poll();

            boolean canMove = false;

            for (int i = 0; i < 4; i++) {
                int ny = nxt[0] + dy[i];
                int nx = nxt[1] + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < M && map[ny][nx] && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new int[] {ny, nx, nxt[2] + 1});
                    canMove = true;
                }
            }

            if (!canMove) {
                answer = Math.max(answer, nxt[2]);
            }
        }
    }
}
