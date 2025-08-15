import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static List<int[]> boundaries = new ArrayList<>();
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static boolean[][] oriMap, visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        oriMap = new boolean[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                oriMap[i][j] = st.nextToken().equals("1");
            }
        }

        visited = new boolean[N][N];
        int num = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && oriMap[i][j]) {
                    findAreaBfs(i, j, num++);
                }
            }
        }

        int[][] dist = new int[N][N];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int[] b : boundaries) {
            q.offer(new int[]{b[0], b[1], b[2]});
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1], land = cur[2];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d], nx = x + dx[d];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

                if (map[ny][nx] == 0) {
                    map[ny][nx] = land;
                    dist[ny][nx] = dist[y][x] + 1;
                    q.offer(new int[]{ny, nx, land});
                }
                else if (map[ny][nx] != land) {
                    min = Math.min(min, dist[y][x] + dist[ny][nx]);
                }
            }
        }

        System.out.println(min);
    }

    private static void findAreaBfs(int y, int x, int num) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;
        map[y][x] = num;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0], cx = cur[1];
            boolean isBoundary = false;

            for (int d = 0; d < 4; d++) {
                int ny = cy + dy[d], nx = cx + dx[d];
                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

                if (oriMap[ny][nx]) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        map[ny][nx] = num;
                        queue.add(new int[]{ny, nx});
                    }
                } else {
                    isBoundary = true;
                }
            }

            if (isBoundary) boundaries.add(new int[]{cy, cx, num});
        }
    }
}
