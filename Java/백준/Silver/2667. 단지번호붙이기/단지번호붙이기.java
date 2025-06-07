import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] map, visited;
    static List<Integer> answerList = new ArrayList<>();
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) == '1';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j]) {
                    bfs(i,j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(answerList.size()).append("\n");
        Collections.sort(answerList);

        for (Integer a : answerList) {
            sb.append(a).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();

        visited[i][j] = true;
        queue.add(new int[] {i, j});

        int cnt = 1;

        while (!queue.isEmpty()) {
            int[] nxt = queue.poll();
            int y = nxt[0];
            int x = nxt[1];

            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];

                if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx] && map[ny][nx]) {
                    visited[ny][nx] = true;
                    cnt++;
                    queue.add(new int[] {ny, nx});
                }
            }
        }

        answerList.add(cnt);
    }
}
