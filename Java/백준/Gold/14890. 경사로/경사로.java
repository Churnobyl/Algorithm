import java.io.*;
import java.util.*;

public class Main {
    static int N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (canPass(map[i])) {
                answer++;
            }
        }

        for (int j = 0; j < N; j++) {
            int[] col = new int[N];
            for (int i = 0; i < N; i++) {
                col[i] = map[i][j];
            }
            if (canPass(col)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean canPass(int[] path) {
        boolean[] used = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = path[i] - path[i + 1];
            
            if (diff == 0) {
                continue;
            }

            if (Math.abs(diff) > 1) {
                return false;
            }

            if (diff == 1) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || path[j] != path[i + 1] || used[j]) {
                        return false;
                    }
                    used[j] = true;
                }
            }
            else if (diff == -1) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || path[j] != path[i] || used[j]) {
                        return false;
                    }
                    used[j] = true;
                }
            }
        }

        return true;
    }
}