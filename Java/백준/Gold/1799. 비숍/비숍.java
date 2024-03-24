import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] maxValue = {0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[2][2*N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0, 0);
        recursion(0, 0, 1);

        System.out.println(maxValue[0] + maxValue[1]);
    }

    static void recursion(int count, int row, int color) {
        if (row >= N) {
            maxValue[color] = Math.max(maxValue[color], count);
            return;
        }

        for (int col = 0; col < N; col++) {
            if ((row + col) % 2 != color || board[row][col] == 0) continue;

            if (!visited[0][row + col] && !visited[1][row - col + N]) {
                visited[0][row + col] = visited[1][row - col + N] = true;
                recursion(count + 1, row + (col + 1) / N, color);
                visited[0][row + col] = visited[1][row - col + N] = false;
            }
        }

        recursion(count, row + 1, color);
    }
}