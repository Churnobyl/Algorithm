import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, maxBlock;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				maxBlock = Math.max(maxBlock, board[i][j]);
			}
		}

		recursion(0, board);
		System.out.println(maxBlock);
	}

	private static void recursion(int count, int[][] board) {
		if (count == 5)
			return;

		for (int i = 0; i < 4; i++) {
			int[][] cache = new int[N][N];

			for (int j = 0; j < N; j++) {
				cache[j] = board[j].clone();
			}

			if (move(cache)) {
				recursion(count + 1, cache);
			}

			if (i == 3)
				break;

			board = rotate(board);

		}
	}

	private static boolean move(int[][] board) {
		boolean isMoved = false;

		for (int j = 0; j < N; j++) {
			int i = 0;

			while (i < N) {
				if (board[i][j] == 0) {
					int t = i + 1;
					while (t < N && board[t][j] == 0) {
						t++;
					}

					if (t < N) {
						board[i][j] = board[t][j];
						board[t][j] = 0;
						isMoved = true;
					}
				}

				if (board[i][j] != 0) {
					int t = i + 1;

					while (t < N && board[t][j] == 0) {
						t++;
					}

					if (t < N && board[t][j] == board[i][j]) {
						board[i][j] = board[i][j] * 2;
						if (maxBlock < board[i][j]) {
							maxBlock = board[i][j];
						}
						board[t][j] = 0;
						isMoved = true;
					}
				}

				i++;
			}
		}
		return isMoved;
	}

	private static int[][] rotate(int[][] board) {
		int[][] newArr = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newArr[i][N - j - 1] = board[j][i];
			}
		}

		return newArr;
	}
}