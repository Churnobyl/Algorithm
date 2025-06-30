import java.io.*;
import java.util.*;

import static java.nio.file.Files.move;

public class Main {
    static int R, C, M;
    static int[][] map;
    static int[] speed, direction, size;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static Map<Integer, int[]> sharks = new HashMap<>();
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        speed = new int[M + 1];
        direction = new int[M + 1];
        size = new int[M + 1];

        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r - 1][c - 1] = i;
            speed[i] = s;
            direction[i] = d - 1;
            size[i] = z;
            sharks.put(i, new int[] {r, c});
        }

        // 낚시왕 이동
        for (int i = 0; i < C; i++) {
            fishing(i);
            moveAllSharks();
        }

        System.out.println(answer);
    }

    private static void moveAllSharks() {
        int[][] newBoard = new int[R][C];
        Map<Integer, int[]> newSharks = new HashMap<>();

        for (Map.Entry<Integer, int[]> entry : sharks.entrySet()) {
            int sharkNum = entry.getKey();
            int[] position = entry.getValue();
            int y = position[0] - 1;
            int x = position[1] - 1;
            int s = speed[sharkNum];
            int d = direction[sharkNum];
            int z = size[sharkNum];

            int ny = y;
            int nx = x;

            int dist = (d == 0 || d == 1) ? s % (2 * (R - 1)) : s % (2 * (C - 1));

            while (dist-- > 0) {
                ny += dy[d];
                nx += dx[d];

                if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
                    // 방향 반전
                    if (d == 0) d = 1;
                    else if (d == 1) d = 0;
                    else if (d == 2) d = 3;
                    else if (d == 3) d = 2;

                    ny += dy[d] * 2;
                    nx += dx[d] * 2;
                }
            }

            direction[sharkNum] = d;

            if (newBoard[ny][nx] == 0) {
                newBoard[ny][nx] = sharkNum;
                newSharks.put(sharkNum, new int[]{ny + 1, nx + 1});
            } else {
                int existing = newBoard[ny][nx];
                if (size[existing] < z) {
                    newBoard[ny][nx] = sharkNum;
                    newSharks.remove(existing);
                    newSharks.put(sharkNum, new int[]{ny + 1, nx + 1});
                }
            }
        }

        map = newBoard;
        sharks = newSharks;
    }

    private static void fishing(int x) {
        for (int i = 0; i < R; i++) {
            if (map[i][x] > 0) {
                int sharkNum = map[i][x];
                answer += size[sharkNum];
                sharks.remove(sharkNum);
                map[i][x] = 0;
                return;
            }
        }
    }
}