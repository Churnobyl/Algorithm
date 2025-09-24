import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static boolean[][] ladder;
    static int answer = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }

        for (int i = 0; i <= 3; i++) {
            if (dfs(1, 1, 0, i)) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
    
    static boolean dfs(int row, int col, int cnt, int target) {
        if (cnt == target) {
            return checkLadder();
        }

        if (cnt > target) return false;
        
        for (int i = row; i <= H; i++) {
            int startCol = (i == row) ? col : 1;
            for (int j = startCol; j < N; j++) {
                if (canPlace(i, j)) {
                    ladder[i][j] = true;
                    if (dfs(i, j + 2, cnt + 1, target)) {
                        return true;
                    }
                    ladder[i][j] = false;
                }
            }
        }

        return false;
    }
    
    static boolean canPlace(int row, int col) {
        if (ladder[row][col]) return false;
        if (col > 1 && ladder[row][col - 1]) return false;
        if (col < N - 1 && ladder[row][col + 1]) return false;
        return true;
    }
    
    static boolean checkLadder() {
        for (int start = 1; start <= N; start++) {
            int pos = start;

            for (int row = 1; row <= H; row++) {
                if (pos < N && ladder[row][pos]) {
                    pos++;
                }
                else if (pos > 1 && ladder[row][pos - 1]) {
                    pos--;
                }
            }
            if (pos != start) {
                return false;
            }
        }

        return true;
    }
}