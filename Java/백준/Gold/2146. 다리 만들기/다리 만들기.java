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

        for (int[] boundary : boundaries) {
            createBridge(boundary);
        }

        System.out.println(min);
    }

    private static void createBridge(int[] boundary) {
        int num = boundary[2];
        boolean[][] visited = new boolean[N][N];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {boundary[0], boundary[1], 0});
        visited[boundary[0]][boundary[1]] = true;

        while (!queue.isEmpty()) {
            int[] nxt = queue.poll();
            int y = nxt[0];
            int x = nxt[1];
            int dist = nxt[2];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    if (map[ny][nx] > 0) {
                        if (map[ny][nx] != num) {
                            min = Math.min(min, dist);
                            return;
                        }
                    } else {
                        queue.add(new int[] {ny, nx, dist + 1});
                    }
                }
            }
        }
    }

    private static void findAreaBfs(int y, int x, int num) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        map[y][x] = num;

        while (!queue.isEmpty()) {
            int[] nxt = queue.poll();

            boolean isBoundary = false;

            for (int i = 0; i < 4; i++) {
                int ny = nxt[0] + dy[i];
                int nx = nxt[1] + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        if (oriMap[ny][nx]) {
                            map[ny][nx] = num;
                            queue.add(new int[]{ny, nx});
                        }
                    }

                    if (!oriMap[ny][nx]) {
                        isBoundary = true;
                    }
                }
            }

            if (isBoundary) {
                boundaries.add(new int[]{nxt[0], nxt[1], num});
            }
        }
    }
}
