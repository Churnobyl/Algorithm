import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int maxCandies = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    maxCandies = Math.max(maxCandies, getMaxCandies());
                    swap(i, j, i, j + 1);
                }
                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    maxCandies = Math.max(maxCandies, getMaxCandies());
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(maxCandies);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    private static int getMaxCandies() {
        int maxCandies = 1;

        for (int i = 0; i < N; i++) {
            int rowCount = 1;
            int colCount = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    rowCount++;
                } else {
                    maxCandies = Math.max(maxCandies, rowCount);
                    rowCount = 1;
                }
                if (board[j][i] == board[j - 1][i]) {
                    colCount++;
                } else {
                    maxCandies = Math.max(maxCandies, colCount);
                    colCount = 1;
                }
            }
            maxCandies = Math.max(maxCandies, rowCount);
            maxCandies = Math.max(maxCandies, colCount);
        }

        return maxCandies;
    }
}
