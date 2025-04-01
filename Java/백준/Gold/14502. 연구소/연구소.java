import java.io.*;
import java.util.*;

public class Main {
    static int N, M, cleared;
    static int[][] map;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static List<int[]> virus = new ArrayList<>();
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) cleared++;
                else if (map[i][j] == 2) virus.add(new int[] {i, j});
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int wall) {
        if (wall == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void spreadVirus() {
        int remainder = cleared;

        int[][] copiedMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            copiedMap[i] = map[i].clone();
        }

        Queue<int[]> queue = new ArrayDeque<>(virus);

        while (!queue.isEmpty()) {
            int[] nxt = queue.poll();
            int y = nxt[0];
            int x = nxt[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < M && copiedMap[ny][nx] == 0) {
                    copiedMap[ny][nx] = 2;
                    remainder--;
                    queue.add(new int[] {ny, nx});
                }
            }
        }

        answer = Math.max(answer, remainder - 3);
    }
}
