import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][][] map = new int[4][4][2];
        Map<Integer, int[]> positions = new TreeMap<>();

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                map[i][j][0] = num;
                map[i][j][1] = dir;
                positions.put(num, new int[]{i, j});
            }
        }

        int firstFishNum = map[0][0][0];
        int direction = map[0][0][1];

        map[0][0][0] = -1; // 상어
        positions.remove(firstFishNum);

        dfs(map, positions, 0, 0, firstFishNum, direction);

        System.out.println(answer);
    }

    private static void dfs(int[][][] map, Map<Integer, int[]> positions, int y, int x, int point, int direction) {
        moveFish(map, positions);

        boolean canMove = false;
        for (int step = 1; step <= 3; step++) {
            int ny = y + dy[direction] * step;
            int nx = x + dx[direction] * step;

            if (ny < 0 || ny >= 4 || nx < 0 || nx >= 4) break;
            if (map[ny][nx][0] <= 0) continue;

            canMove = true;
            int[][][] newMap = copyMap(map);
            Map<Integer, int[]> newPositions = copyPositions(positions);

            int fishNum = newMap[ny][nx][0];
            int newDir = newMap[ny][nx][1];

            newMap[y][x][0] = 0; // 빈칸
            newMap[ny][nx][0] = -1; // 상어
            newPositions.remove(fishNum);

            dfs(newMap, newPositions, ny, nx, point + fishNum, newDir);
        }

        if (!canMove) answer = Math.max(answer, point);
    }

    private static void moveFish(int[][][] map, Map<Integer, int[]> positions) {
        for (int fishNum = 1; fishNum <= 16; fishNum++) {
            if (!positions.containsKey(fishNum)) continue;

            int[] pos = positions.get(fishNum);
            int y = pos[0], x = pos[1];
            int dir = map[y][x][1];

            for (int i = 0; i < 8; i++) {
                int nd = (dir + i) % 8;
                int ny = y + dy[nd];
                int nx = x + dx[nd];

                if (ny < 0 || ny >= 4 || nx < 0 || nx >= 4) continue;
                if (map[ny][nx][0] == -1) continue;

                if (map[ny][nx][0] == 0) {
                    map[ny][nx][0] = map[y][x][0];
                    map[ny][nx][1] = nd;
                    map[y][x][0] = 0;

                    positions.put(fishNum, new int[]{ny, nx});
                } else {
                    int swapNum = map[ny][nx][0];
                    int swapDir = map[ny][nx][1];

                    map[ny][nx][0] = map[y][x][0];
                    map[ny][nx][1] = nd;
                    map[y][x][0] = swapNum;
                    map[y][x][1] = swapDir;

                    positions.put(fishNum, new int[]{ny, nx});
                    positions.put(swapNum, new int[]{y, x});
                }
                break;
            }
        }
    }

    private static int[][][] copyMap(int[][][] map) {
        int[][][] newMap = new int[4][4][2];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                newMap[i][j][0] = map[i][j][0];
                newMap[i][j][1] = map[i][j][1];
            }
        return newMap;
    }

    private static Map<Integer, int[]> copyPositions(Map<Integer, int[]> original) {
        Map<Integer, int[]> copy = new TreeMap<>();
        for (Map.Entry<Integer, int[]> entry : original.entrySet()) {
            copy.put(entry.getKey(), new int[]{entry.getValue()[0], entry.getValue()[1]});
        }
        return copy;
    }
}
