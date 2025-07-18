import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] A;
    static int[] topPurifier, bottomPurifier;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        A = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());

                if (A[i][j] == -1) {
                    if (topPurifier == null) {
                        topPurifier = new int[]{i, j};
                    } else {
                        bottomPurifier = new int[]{i, j};
                    }
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spreadDust();
            runAirPurifier();
        }

        System.out.println(countDusts());
    }

    private static void runAirPurifier() {
        runTopAP();
        runBottomAP();
    }

    private static void runBottomAP() {
        int[] a = new int[]{2, 1, 0, 3};

        int beforeY = bottomPurifier[0];
        int beforeX = bottomPurifier[1];

        for (int k = 0; k < 4; k++) {
            int i = a[k];
            int ny = beforeY + dy[i];
            int nx = beforeX + dx[i];

            while (bottomPurifier[0] <= ny && ny < R && 0 <= nx && nx < C) {
                move(beforeY, beforeX, ny, nx);

                beforeY = ny;
                beforeX = nx;
                ny += dy[i];
                nx += dx[i];
            }
        }
    }

    private static void runTopAP() {
        int beforeY = topPurifier[0];
        int beforeX = topPurifier[1];

        for (int i = 0; i < 4; i++) {
            int ny = beforeY + dy[i];
            int nx = beforeX + dx[i];

            while (0 <= ny && ny <= topPurifier[0] && 0 <= nx && nx < C) {
                move(beforeY, beforeX, ny, nx);

                beforeY = ny;
                beforeX = nx;
                ny += dy[i];
                nx += dx[i];
            }
        }
    }

    private static void move(int beforeY, int beforeX, int ny, int nx) {
        if (A[beforeY][beforeX] == -1) {
            A[ny][nx] = 0;
            return;
        }

        if (A[ny][nx] == -1) {
            A[beforeY][beforeX] = 0;
            return;
        }

        A[beforeY][beforeX] = A[ny][nx];
    }

    private static void spreadDust() {
        int[][] newA = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] == -1) {
                    newA[i][j] = -1;
                    continue;
                }

                if (A[i][j] != 0 && A[i][j] != -1) {
                    spread(i, j, newA);
                }

            }
        }

        A = newA;
    }

    private static void spread(int y, int x, int[][] newA) {
        int eachAmount = A[y][x] / 5;
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0 <= ny && ny < R && 0 <= nx && nx < C && A[ny][nx] != -1) {
                newA[ny][nx] += eachAmount;
                cnt++;
            }
        }

        newA[y][x] += A[y][x] - eachAmount * cnt;
    }

    private static int countDusts() {
        int dusts = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] != -1) dusts += A[i][j];
            }
        }
        return dusts;
    }
}
