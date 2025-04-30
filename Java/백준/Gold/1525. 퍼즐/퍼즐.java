import java.io.*;
import java.util.*;

public class Main {
    static class State {
        int[][] map;
        int y;
        int x;
        int count;

        public State(int[][] map, int y, int x, int count) {
            this.map = map;
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    static Set<String> cache = new HashSet<>();
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static String answer = "123456780";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[3][3];
        int y = 0;
        int x = 0;

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    y = i;
                    x = j;
                }
            }
        }

        String firstString = makeCache(map);
        if (firstString.equals(answer)) {
            System.out.println(0);
            return;
        }

        Queue<State> queue = new ArrayDeque<>();

        queue.add(new State(map, y, x, 0));

        boolean haveAnswer = false;

        loop1:
        while (!queue.isEmpty()) {
            State nextState = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = nextState.y + dy[i];
                int nx = nextState.x + dx[i];

                if (0 <= ny && ny < 3 && 0 <= nx && nx < 3) {
                    int[][] newMap = makeMap(nextState.map, nextState.y, nextState.x, ny, nx);
                    String s = makeCache(newMap);

                    if (!cache.contains(s)) {
                        if (s.equals(answer)) {
                            haveAnswer = true;
                            System.out.println(nextState.count + 1);
                            break loop1;
                        } else {
                            cache.add(s);
                            queue.add(new State(newMap, ny, nx, nextState.count + 1));
                        }
                    }
                }
            }
        }

        if (!haveAnswer) {
            System.out.println(-1);
        }
    }

    private static String makeCache(int[][] newMap) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(newMap[i][j]);
            }
        }

        return sb.toString();
    }

    private static int[][] makeMap(int[][] map, int y, int x, int ny, int nx) {
        int[][] newMap = new int[3][3];

        for (int i = 0; i < 3; i++) {
            newMap[i] = map[i].clone();
        }

        int cache = newMap[y][x];
        newMap[y][x] = newMap[ny][nx];
        newMap[ny][nx] = cache;

        return newMap;
    }
}
