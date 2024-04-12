import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R, C, e0, e1;
	static char[][] map;
	static int[][] flood, dp;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		flood = new int[R][C];
		dp = new int[R][C];

		for (int i = 0; i < R; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < R; i++) {
			Arrays.fill(flood[i], -1);
		}

		List<int[]> f = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			String line = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '*') {
					flood[i][j] = 0;
					f.add(new int[] { i, j });
				} else if (map[i][j] == 'D') {
					flood[i][j] = Integer.MAX_VALUE;
					e0 = i;
					e1 = j;
				} else if (map[i][j] == 'S') {
					queue.add(new int[] { i, j });
					dp[i][j] = 0;
				}
			}
		}

		flooding(f);

		while (!queue.isEmpty()) {
			int[] next = queue.poll();

			int y = next[0];
			int x = next[1];

			if (map[y][x] == 'D')
				continue;

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (0 <= ny && ny < R && 0 <= nx && nx < C && map[ny][nx] != 'X') {
					if (dp[y][x] + 1 < dp[ny][nx] && (dp[y][x] + 1 < flood[ny][nx] || flood[ny][nx] == -1)) {
						dp[ny][nx] = dp[y][x] + 1;
						queue.add(new int[] { ny, nx });
					}
				}
			}
		}
		
		if (dp[e0][e1] == Integer.MAX_VALUE)
			System.out.println("KAKTUS");
		else
			System.out.println(dp[e0][e1]);

	}

	private static void flooding(List<int[]> f) {
		Queue<int[]> fQueue = new LinkedList<>();
		fQueue.addAll(f);

		while (!fQueue.isEmpty()) {
			int[] next = fQueue.poll();

			int y = next[0];
			int x = next[1];

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (0 <= ny && ny < R && 0 <= nx && nx < C && map[ny][nx] != 'X' && map[ny][nx] != 'D') {
					if (flood[ny][nx] < 0) {
						flood[ny][nx] = flood[y][x] + 1;
						fQueue.add(new int[] { ny, nx });
					}
				}
			}
		}
	}
}
