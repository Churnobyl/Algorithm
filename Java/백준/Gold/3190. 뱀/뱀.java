import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] map;
    static Deque<int[]> deque = new ArrayDeque<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int time;
    static int dir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r - 1][c - 1] = 2;
        }

        deque.add(new int[] {0, 0});
        map[0][0] = 1;

        int L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int C = st.nextToken().equals("D") ? 1 : -1;

            while (time < X) {
                if (!move()) {
                    System.out.println(time + 1);
                    return;
                }
                time++;
            }

            dir = (dir + 4 + C) % 4;
        }

        while (move()) {
            time++;
        }

        System.out.println(time + 1);
    }

    private static boolean move() {
        int[] head = deque.peekLast();

        int ny = head[0] + dy[dir];
        int nx = head[1] + dx[dir];

        if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == 1) return false;

        if (map[ny][nx] != 2) {
            int[] tail = deque.pollFirst();
            map[tail[0]][tail[1]] = 0;
        }


        deque.add(new int[] {ny, nx});
        map[ny][nx] = 1;

        return true;
    }
}
