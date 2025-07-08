import java.io.*;
import java.util.*;

public class Main {
    static class Union {
        int total;
        List<int[]> country = new ArrayList<>();
    }

    static int N, L, R, cnt;
    static int[][] map;
    static boolean[][] visited;
    static List<Union> unions = new ArrayList<>();
    static boolean noUnion;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (!noUnion) {
            makeUnion();
            moveAlongUnions();
            if (noUnion) break;
            
            cnt++;
            unions.clear();
        }

        System.out.println(cnt);
    }

    private static void moveAlongUnions() {
        boolean haveMovedUnion = false;

        for (Union union : unions) {
            if (union.country.size() > 1) {
                haveMovedUnion = true;
                int avg = union.total / union.country.size();

                for (int[] country : union.country) {
                    map[country[0]][country[1]] = avg;
                }
            }
        }

        if (!haveMovedUnion) noUnion = true;
    }

    private static void makeUnion() {
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    Union union = new Union();
                    bfs(i, j, union);
                }
            }
        }
    }

    private static void bfs(int y, int x, Union union) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[] {y, x});
        union.country.add(new int[] {y, x});
        union.total = map[y][x];
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            int currPop = map[next[0]][next[1]];

            for (int i = 0; i < 4; i++) {
                int ny = next[0] + dy[i];
                int nx = next[1] + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) {
                    if (Math.abs(currPop - map[ny][nx]) >= L && Math.abs(currPop - map[ny][nx]) <= R) {
                        union.country.add(new int[] {ny, nx});
                        visited[ny][nx] = true;
                        union.total += map[ny][nx];
                        queue.add(new int[] {ny, nx});
                    }
                }
            }
        }

        unions.add(union);
    }
}
