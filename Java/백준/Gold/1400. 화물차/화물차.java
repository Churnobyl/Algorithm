import java.io.*;
import java.util.*;

public class Main {
    static class Crosswalk {
        int id;
        boolean isVertical;
        int horizontalTime, verticalTime;

        public Crosswalk(int id, boolean isVertical, int horizontalTime, int verticalTime) {
            this.id = id;
            this.isVertical = isVertical;
            this.horizontalTime = horizontalTime;
            this.verticalTime = verticalTime;
        }
    }

    static class Node implements Comparable<Node> {
        int y, x;
        int time;

        public Node(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

    static int n, m;
    static char[][] map;
    static int[][] dp;
    static int[] start, end;
    static Crosswalk[] crosswalks;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        StringBuilder sb = new StringBuilder();

        while (!(line = br.readLine()).trim().equals("0 0")) {
            if (line.trim().isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            setting(br);
            sb.append(run()).append("\n");
        }

        System.out.print(sb);
    }

    private static String run() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start[0], start[1], 0));
        dp[start[0]][start[1]] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int y = node.y;
            int x = node.x;
            int time = node.time;

            if (dp[y][x] < time) continue;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (0 <= ny && ny < n && 0 <= nx && nx < m && map[ny][nx] != '.') {
                    if (map[ny][nx] == 'B') {
                        if (dp[ny][nx] > time + 1) {
                            dp[ny][nx] = time + 1;
                            pq.add(new Node(ny, nx, dp[ny][nx]));
                        }
                    } else if (map[ny][nx] == '#') {
                        if (dp[ny][nx] > time + 1) {
                            dp[ny][nx] = time + 1;
                            pq.add(new Node(ny, nx, dp[ny][nx]));
                        }
                    } else if ('0' <= map[ny][nx] && map[ny][nx] <= '9') {
                        int plus = addTime(map[ny][nx], time, i);

                        if (dp[ny][nx] > time + plus) {
                            dp[ny][nx] = time + plus;
                            pq.add(new Node(ny, nx, dp[ny][nx]));
                        }
                    }
                }
            }
        }

        return dp[end[0]][end[1]] == Integer.MAX_VALUE ? "impossible" : String.valueOf(dp[end[0]][end[1]]);
    }

    private static int addTime(char id, int currTime, int dir) {
        Crosswalk crosswalk = crosswalks[id - '0'];

        int totalTime = crosswalk.verticalTime + crosswalk.horizontalTime;
        int rest = currTime % totalTime;
        boolean wantNS = (dir == 0 || dir == 1);

        if (crosswalk.isVertical) {
            if (rest < crosswalk.verticalTime) {
                if (wantNS) return 1;
                else return crosswalk.verticalTime - rest + 1;
            } else {
                if (!wantNS) return 1;
                else return totalTime - rest + 1;
            }
        } else {
            if (rest < crosswalk.horizontalTime) {
                if (!wantNS) return 1;
                else return crosswalk.horizontalTime - rest + 1;
            } else {
                if (wantNS) return 1;
                else return totalTime - rest + 1;
            }
        }
    }

    public static void setting(BufferedReader br) throws IOException {
        map = new char[n][m];
        dp = new int[n][m];
        int maxCrossId = -1;

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'A') {
                    start = new int[]{i, j};
                } else if (map[i][j] == 'B') {
                    end = new int[]{i, j};
                } else if ('0' <= map[i][j] && map[i][j] <= '9') {
                    maxCrossId = Math.max(maxCrossId, map[i][j] - '0');
                }
            }
        }

        if (maxCrossId >= 0) {
            crosswalks = new Crosswalk[maxCrossId + 1];
            for (int i = 0; i <= maxCrossId; i++) {
                String line;
                while ((line = br.readLine()) != null && line.trim().isEmpty()) ;

                StringTokenizer st = new StringTokenizer(line);
                int id = Integer.parseInt(st.nextToken());
                boolean isVertical = st.nextToken().equals("|");
                int horizontalTime = Integer.parseInt(st.nextToken());
                int verticalTime = Integer.parseInt(st.nextToken());

                Crosswalk crosswalk = new Crosswalk(id, isVertical, horizontalTime, verticalTime);
                crosswalks[id] = crosswalk;
            }
        }
    }
}
