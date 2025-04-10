import java.io.*;
import java.util.*;

public class Main {
    static int n, sharkSize = 2, eatCount = 0, totalTime = 0;
    static int[][] map;
    static int[] sharkPos;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkPos = new int[]{i, j};
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            int[] fish = bfs();
            if (fish == null) break;
            
            sharkPos[0] = fish[0];
            sharkPos[1] = fish[1];
            totalTime += fish[2];
            eatCount++;
            map[fish[0]][fish[1]] = 0;

            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(totalTime);
    }

    static int[] bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        List<int[]> fishList = new ArrayList<>();

        queue.offer(new int[]{sharkPos[0], sharkPos[1], 0});
        visited[sharkPos[0]][sharkPos[1]] = true;
        int minDistance = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], dist = current[2];
            
            if (dist > minDistance) break;

            if (map[x][y] != 0 && map[x][y] < sharkSize) {
                fishList.add(new int[]{x, y, dist});
                minDistance = dist;
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny] || map[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
            }
        }

        if (fishList.isEmpty()) return null;
        
        fishList.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        return fishList.get(0);
    }
}
