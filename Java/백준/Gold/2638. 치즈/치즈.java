import java.io.*;
import java.util.*;

public class Main {
    static int N, M, rest;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int[][] map, source;
    static boolean isAir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        source = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                source[i][j] = Integer.parseInt(st.nextToken());
                if (source[i][j] == 1) rest++;
            }
        }

        map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    bfs(source[i][j], i, j, visited);
                    if (source[i][j] == 0 && !isAir) {
                        isAir = true;
                    }
                }
            }
        }

        int cnt = 0;

        while (rest != 0) {
            cnt++;
            melting();

        }

        System.out.println(cnt);
    }

    private static void melting() {
        int[][] newMap = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;

                if (map[i][j] == 1) {
                    boolean canMelt = false;
                    List<int[]> hole = new ArrayList<>();
                    int inTheAir = 0;

                    for (int k = 0; k < 4; k++) {
                        int ky = i + dy[k];
                        int kx = j + dx[k];

                        if (0 <= ky && ky < N && 0 <= kx && kx < M) {
                            if (map[ky][kx] == 0) {
                                inTheAir++;
                                if (inTheAir >= 2) canMelt = true;
                            }
                            if (map[ky][kx] == -1) {
                                hole.add(new int[] {ky, kx});
                            }
                        }
                    }

                    if (!canMelt) {
                        newMap[i][j] = 1;
                    } else {
                        rest--;
                        breakHole(hole, newMap, visited);
                    }
                } else if (map[i][j] == -1) {
                    newMap[i][j] = -1;
                }
            }
        }

        map = newMap;
    }

    private static void breakHole(List<int[]> hole, int[][] newMap, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        for (int[] h : hole) {
            if (!visited[h[0]][h[1]]) {
                q.add(new int[]{h[0], h[1]});
                visited[h[0]][h[1]] = true;
                newMap[h[0]][h[1]] = 0;
            }
        }

        while (!q.isEmpty()) {
            int[] nxt = q.poll();
            int y = nxt[0];
            int x = nxt[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < M && map[ny][nx] == -1 && !visited[ny][nx]) {
                    q.add(new int[] {ny, nx});
                    visited[ny][nx] = true;
                    newMap[ny][nx] = 0;
                }
            }
        }
    }

    private static void bfs(int num, int y, int x, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {y, x});
        visited[y][x] = true;

        if (num == 0) {
            if (isAir) map[y][x] = -1;
        } else if (num == 1) map[y][x] = 1;


        while (!q.isEmpty()) {
            int[] nxt = q.poll();
            int oy = nxt[0];
            int ox = nxt[1];

            for (int i = 0; i < 4; i++) {
                int ny = oy + dy[i];
                int nx = ox + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (!visited[ny][nx] && source[ny][nx] == num) {
                        visited[ny][nx] = true;
                        q.add(new int[] {ny, nx});

                        if (num == 0) {
                            if (isAir) map[ny][nx] = -1;
                        } else if (num == 1) map[ny][nx] = 1;
                    }
                }
            }
        }
    }
}