import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, max;
	static int[][] map;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] == 0) {
					max = Math.max(recursion(i, j, 1), max);
				}
			}
		}

		System.out.println(max);
	}

	private static int recursion(int y, int x, int count) {
		boolean isEnd = true;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (0 <= ny && ny < n && 0 <= nx && nx < n) {
				if (map[y][x] < map[ny][nx]) {
					if (dp[ny][nx] != 0) {
						dp[y][x] = Math.max(dp[y][x], dp[ny][nx] + 1);
					} else {
						dp[y][x] = Math.max(recursion(ny, nx, count + 1) + 1, dp[y][x]);						
					}
					isEnd = false;
				}
			}
		}

		if (isEnd) {
			dp[y][x] = 1;
			return 1;
		}

		return dp[y][x];
	}
}