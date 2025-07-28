import java.io.*;
import java.util.*;

public class Main {
    static class Dice {
        int[] curr = new int[2];
        int[] arr = new int[] {0, 0, 0, 0, 0, 0};
        int[][] rotationRule = {
                {2, 3, 1, 4},
                {0, 0, 4, -1},
                {3, -2, 0, 0},
                {-3, 2, 0, 0},
                {0, 0, -4, 1},
                {-2, -3, -1, -4}
        };

        int[] dy = {0, 0, -1, 1};
        int[] dx = {1, -1, 0, 0};

        public boolean canMove(int dir, int N, int M) {
            int ny = curr[0] + dy[dir];
            int nx = curr[1] + dx[dir];
            if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                curr[0] = ny;
                curr[1] = nx;
                return true;
            }

            return false;
        }

        public void rotate(int dir) {
            int[] newArr = new int[6];

            for (int i = 0; i < 6; i++) {
                newArr[i + rotationRule[i][dir]] = arr[i];
            }

            arr = newArr;
        }

        public void copy(int[][] map) {
            if (map[curr[0]][curr[1]] == 0) {
                map[curr[0]][curr[1]] = arr[5];
            } else {
                arr[5] = map[curr[0]][curr[1]];
                map[curr[0]][curr[1]] = 0;
            }
        }

        public int printTopNum() {
            return arr[0];
        }
    }

    static int N, M, x, y, K;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice();
        dice.curr[0] = x;
        dice.curr[1] = y;

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken()) - 1;

            if (dice.canMove(dir, N, M)) {
                dice.rotate(dir);
                dice.copy(map);
                sb.append(dice.printTopNum()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
