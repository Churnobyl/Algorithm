import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] lightOn, visited;
    static List<int[]>[][] switches;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lightOn = new boolean[N][N];
        visited = new boolean[N][N];
        switches = new ArrayList[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                switches[i][j] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            switches[y][x].add(new int[]{b, a});
        }

        lightOn[0][0] = true;
        visited[0][0] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});

        int answer = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for (int[] s : switches[y][x]) {
                int ny = s[0];
                int nx = s[1];

                if (!lightOn[ny][nx]) {
                    lightOn[ny][nx] = true;
                    answer++;

                    for (int d = 0; d < 4; d++) {
                        int ay = ny + dy[d];
                        int ax = nx + dx[d];

                        if (0 <= ay && ay < N && 0 <= ax && ax < N && visited[ay][ax]) {
                            visited[ny][nx] = true;
                            q.add(new int[]{ny, nx});
                            break;
                        }
                    }
                }
            }

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (0 <= ny && ny < N && 0 <= nx && nx < N && lightOn[ny][nx] && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }

        System.out.println(answer);
    }
}
