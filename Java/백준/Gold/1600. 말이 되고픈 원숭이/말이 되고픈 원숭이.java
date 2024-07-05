import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K, H, W;
    static boolean[][] map;
    static int[][][] dp;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int[] dy2 = {-2,-2, -1, -1, 1, 1, 2, 2};
    static int[] dx2 = {-1, 1, -2, 2, 2, -2, 1, -1};

    public static void main(String[] args) throws IOException {
        init();
        run();
    }

    private static void run() {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {0, 0, 0});

        while (!queue.isEmpty()) {
            int[] nxt = queue.poll();

            int y = nxt[0];
            int x = nxt[1];
            int step = nxt[2];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (0 <= ny && ny < H && 0 <= nx && nx < W && !map[ny][nx]) {
                    if ( dp[y][x][step] + 1 < dp[ny][nx][step]) {
                        dp[ny][nx][step] = dp[y][x][step] + 1;
                        queue.add(new int[] {ny, nx, step});
                    }
                }
            }

            for (int i = 0; i < 8; i++) {
                int ny = y + dy2[i];
                int nx = x + dx2[i];

                if (0 <= ny && ny < H && 0 <= nx && nx < W && !map[ny][nx]) {
                    if (step < K && dp[y][x][step] + 1 < dp[ny][nx][step + 1]) {
                        dp[ny][nx][step + 1] = dp[y][x][step] + 1;
                        queue.add(new int[] {ny, nx, step + 1});
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < K + 1; i++) {
            if (dp[H - 1][W - 1][i] < result) {
                result = dp[H - 1][W - 1][i];
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new boolean[H][W];
        dp = new int[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            String[] d = br.readLine().split(" ");
            for (int j = 0; j < W; j++) {
                if (d[j].equals("1")) map[i][j] = true;

                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        Arrays.fill(dp[0][0], 0);

    }
}