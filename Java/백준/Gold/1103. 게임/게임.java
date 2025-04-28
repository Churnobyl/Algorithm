import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static boolean hasCycle = false;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = dfs(0, 0);

        System.out.println(hasCycle ? -1 : answer);
    }

    static int dfs(int y, int x) {
        if (y < 0 || x < 0 || y >= n || x >= m || map[y][x] == 'H') {
            return 0;
        }

        if (hasCycle) return 0;

        if (visited[y][x]) {
            hasCycle = true;
            return 0;
        }

        if (dp[y][x] != 0) {
            return dp[y][x];
        }

        visited[y][x] = true;

        int move = map[y][x] - '0';
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i] * move;
            int nx = x + dx[i] * move;
            dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
        }

        visited[y][x] = false;

        return dp[y][x];
    }
}
