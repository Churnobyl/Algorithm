import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static Queue<int[]> waterQ = new ArrayDeque<>();
    static Queue<int[]> nextWaterQ = new ArrayDeque<>();
    static Queue<int[]> swanQ = new ArrayDeque<>();
    static Queue<int[]> nextSwanQ = new ArrayDeque<>();
    static boolean[][] visited;
    static int[] swan1, swan2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        int swanCnt = 0;
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] != 'X') waterQ.add(new int[]{i, j});
                if (map[i][j] == 'L') {
                    if (swanCnt == 0) swan1 = new int[]{i, j};
                    else swan2 = new int[]{i, j};
                    swanCnt++;
                }
            }
        }

        visited = new boolean[R][C];
        swanQ.add(swan1);
        visited[swan1[0]][swan1[1]] = true;

        int t = 0;
        while (true) {
            if (meet()) break;
            melt();
            t++;
        }
        System.out.println(t);
    }

    static boolean meet() {
        while (!swanQ.isEmpty()) {
            int[] now = swanQ.poll();
            int y = now[0], x = now[1];
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                if (visited[ny][nx]) continue;

                visited[ny][nx] = true;
                if (map[ny][nx] == 'L') return true;
                if (map[ny][nx] == '.') swanQ.add(new int[]{ny, nx});
                else if (map[ny][nx] == 'X') nextSwanQ.add(new int[]{ny, nx});
            }
        }
        Queue<int[]> temp = swanQ;
        swanQ = nextSwanQ;
        nextSwanQ = temp;
        return false;
    }

    static void melt() {
        while (!waterQ.isEmpty()) {
            int[] now = waterQ.poll();
            int y = now[0], x = now[1];
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                if (map[ny][nx] == 'X') {
                    map[ny][nx] = '.'; // 녹임
                    nextWaterQ.add(new int[]{ny, nx});
                }
            }
        }
        Queue<int[]> temp = waterQ;
        waterQ = nextWaterQ;
        nextWaterQ = temp;
    }
}
