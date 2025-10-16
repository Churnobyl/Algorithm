import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] map  = new char[N][M];

        int y = 0;
        int x = 0;

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                map[i][j] = line[j];

                if (map[i][j] == 'I') {
                    y = i;
                    x = j;
                }
            }
        }

        boolean[][] visited = new boolean[N][M];

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[] {y, x});
        visited[y][x] = true;
        int result = 0;

        while (!q.isEmpty()) {
            int[] nxt = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = nxt[0] + dy[i];
                int nx = nxt[1] + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (!visited[ny][nx] && map[ny][nx] != 'X') {
                        visited[ny][nx] = true;
                        if (map[ny][nx] == 'P') result++;
                        q.add(new int[] {ny, nx});
                    }
                }
            }
        }

        System.out.println(result == 0 ? "TT" : result);
    }
}
