import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dy = {-1 , 0, 1};
    static int[] dx = {1 , 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new boolean[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j) == 'x'; // x : 1, . : 0
            }
        }

        int count = 0;

        for (int i = 0; i < R; i++) {
            if (!map[i][0]) {
                if (dfs(i, 0)) count++;
            }
        }

        System.out.println(count);
    }

    private static boolean dfs(int y, int x) {
        if (x == C - 1) {
            visited[y][x] = true;
            return true;
        }

        visited[y][x] = true;

        boolean canEstablish = false;

        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0 <= ny && ny < R && 0 <= nx && nx < C && !map[ny][nx] && !visited[ny][nx]) {
                if (dfs(ny, nx)) {
                    canEstablish = true;
                    break;
                }
            }
        }

        if (canEstablish) {
            return true;
        } else {
            return false;
        }
    }
}
