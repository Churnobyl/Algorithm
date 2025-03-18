import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[10][10];
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Read the 10x10 board
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
    
    static void dfs(int row, int col, int count) {
        if (count >= ans) return;
        
        int r = -1, c = -1;
        boolean found = false;
        for (int i = row; i < 10; i++) {
            for (int j = (i == row ? col : 0); j < 10; j++) {
                if (board[i][j] == 1) {
                    r = i;
                    c = j;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        
        if (!found) {
            ans = Math.min(ans, count);
            return;
        }

        for (int size = 5; size >= 1; size--) {
            if (paper[size] > 0 && canPlace(r, c, size)) {
                setBoard(r, c, size, 0);
                paper[size]--;
                dfs(r, c, count + 1);
                setBoard(r, c, size, 1);
                paper[size]++;
            }
        }
    }
    
    static boolean canPlace(int r, int c, int size) {
        if (r + size > 10 || c + size > 10) return false;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (board[i][j] != 1) return false;
            }
        }
        return true;
    }
    
    static void setBoard(int r, int c, int size, int val) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                board[i][j] = val;
            }
        }
    }
}
