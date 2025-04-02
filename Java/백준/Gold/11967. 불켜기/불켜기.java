import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer;
    static boolean[][] map;
    static boolean[][] visited;
    static Map<Integer, List<Integer>> switches = new HashMap<>();
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][N];
        visited = new boolean[N][N];
        map[0][0] = true;
        visited[0][0] = true;
        answer = 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            switches.computeIfAbsent(y * 100 + x, k -> new ArrayList<>()).add(b * 100 + a);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(0);

        while (!queue.isEmpty()) {
            int nxt = queue.poll();

            int nxtY = nxt / 100;
            int nxtX = nxt % 100;

            List<Integer> nextSwitches = switches.get(nxt);


            if (nextSwitches != null) {
                boolean isSwitched = false;

                for (Integer nextSwitch : nextSwitches) {
                    int y = nextSwitch / 100;
                    int x = nextSwitch % 100;

                    if (!map[y][x]) {
                        isSwitched = true;
                        answer++;
                        map[y][x] = true;
                    }
                }

                if (isSwitched) {
                    visited = new boolean[N][N];
                    visited[nxtY][nxtX] = true;
                }
            }


            for (int i = 0; i < 4; i++) {
                int ny = nxtY + dy[i];
                int nx = nxtX + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < N && map[ny][nx] && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(ny * 100 + nx);
                }
            }
        }

        System.out.println(answer);
    }
}
