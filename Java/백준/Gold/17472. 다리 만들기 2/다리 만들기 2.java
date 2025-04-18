import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] cache;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> edges = new ArrayList<>();
    static Queue<int[]>[] startQueue = new Queue[7];
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int territoryNum = 1;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cache = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cache[i][j] = st.nextToken().equals("1");
            }
        }

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && cache[i][j]) {
                    visited[i][j] = true;
                    map[i][j] = territoryNum;
                    findTerritory(i, j);
                    territoryNum++;
                }
            }
        }

        for (int i = 1; i < territoryNum; i++) {
            Queue<int[]> queue = startQueue[i];
            if (queue == null) continue;

            while (!queue.isEmpty()) {
                int[] nxt = queue.poll();
                int y = nxt[0];
                int x = nxt[1];
                int dir = nxt[2];

                int startTerritory = map[y][x];
                int cnt = 0;
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                while (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (map[ny][nx] != 0) {
                        if (cnt >= 2 && map[ny][nx] != startTerritory) {
                            edges.add(new int[]{startTerritory, map[ny][nx], cnt});
                        }
                        break;
                    }
                    cnt++;
                    ny += dy[dir];
                    nx += dx[dir];
                }
            }
        }

        edges.sort(Comparator.comparingInt(o -> o[2]));

        initParent();

        int answer = 0;
        int edgeCount = 0;

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            if (find(a) != find(b)) {
                union(a, b);
                answer += cost;
                edgeCount++;
            }
        }

        if (edgeCount == territoryNum - 2) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    private static void findTerritory(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                if (!cache[ny][nx]) {
                    if (startQueue[territoryNum] == null) {
                        startQueue[territoryNum] = new ArrayDeque<>();
                    }
                    startQueue[territoryNum].add(new int[]{y, x, i});
                } else if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    map[ny][nx] = territoryNum;
                    findTerritory(ny, nx);
                }
            }
        }
    }

    private static void initParent() {
        parent = new int[territoryNum];
        for (int i = 1; i < territoryNum; i++) {
            parent[i] = i;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }
}
