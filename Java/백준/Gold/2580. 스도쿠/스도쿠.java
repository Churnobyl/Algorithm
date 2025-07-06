import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[9][9];
    static boolean[][] rows = new boolean[9][10];
    static boolean[][] cols = new boolean[9][10];
    static boolean[][][] square = new boolean[3][3][10];
    static List<int[]> blanks = new ArrayList<>();
    static boolean solved = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 0) {
                    blanks.add(new int[]{i, j});
                } else {
                    rows[i][num] = true;
                    cols[j][num] = true;
                    square[i/3][j/3][num] = true;
                }
            }
        }
        dfs(0);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (solved) return;
        if (depth == blanks.size()) {
            solved = true;
            return;
        }

        int[] pos = blanks.get(depth);
        int r = pos[0], c = pos[1];
        for (int num = 1; num <= 9; num++) {
            if (!rows[r][num] && !cols[c][num] && !square[r/3][c/3][num]) {
                map[r][c] = num;
                rows[r][num] = cols[c][num] = square[r/3][c/3][num] = true;

                dfs(depth + 1);

                if (solved) return;
                
                map[r][c] = 0;
                rows[r][num] = cols[c][num] = square[r/3][c/3][num] = false;
            }
        }
    }
}
