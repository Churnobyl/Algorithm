import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, max;
	static int[][] map;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] == 0) {
					max = Math.max(recursion(i, j), max);
				}
			}
		}

		System.out.println(max);
	}

	private static int recursion(int y, int x) {
		if (dp[y][x] != 0)
			return dp[y][x];

		dp[y][x] = 1;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (0 <= ny && ny < n && 0 <= nx && nx < n) {
				if (map[y][x] < map[ny][nx]) {
					dp[y][x] = Math.max(recursion(ny, nx) + 1, dp[y][x]);
				}
			}
		}

		return dp[y][x];
	}
}