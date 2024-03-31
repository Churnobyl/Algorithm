import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static boolean[][] map;
	static int[][][] dp;
	static Queue<int[]> queue = new LinkedList<>();

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];
		dp = new int[N][M][K + 1];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(dp[i][j], Integer.MAX_VALUE);
			}
		}

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				char d = line.charAt(j);
				if (d == '1')
					map[i][j] = false;
				else
					map[i][j] = true;
			}
		}

		queue.add(new int[] { 0, 0, 0, 1 });
		dp[0][0][0] = 1;

		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			int y = next[0];
			int x = next[1];
			int hammers = next[2];
			int day = next[3];

			if (y == N - 1 && x == M - 1) {
				break;
			}

			boolean stateChanging = false;

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
					if (map[ny][nx]) { // 갈 수 있는 길
						if (stateChanging) { // 대기중인 애들 때문에 수정됐을 경우
							if (dp[y][x][hammers] < dp[ny][nx][hammers]) {
								dp[ny][nx][hammers] = dp[y][x][hammers];
								queue.add(new int[] { ny, nx, hammers, day % 2 + 1 });
							}
						} else {
							if (dp[y][x][hammers] + 1 < dp[ny][nx][hammers]) {
								dp[ny][nx][hammers] = dp[y][x][hammers] + 1;
								queue.add(new int[] { ny, nx, hammers, day % 2 + 1 });
							}
						}

					} else { // 벽
						if (day == 1) { // 낮
							if (stateChanging) {
								if (hammers < K && dp[y][x][hammers] < dp[ny][nx][hammers + 1]) {
									dp[ny][nx][hammers + 1] = dp[y][x][hammers];
									queue.add(new int[] { ny, nx, hammers + 1, day % 2 + 1 });
								}
							} else {
								if (hammers < K && dp[y][x][hammers] + 1 < dp[ny][nx][hammers + 1]) {
									dp[ny][nx][hammers + 1] = dp[y][x][hammers] + 1;
									queue.add(new int[] { ny, nx, hammers + 1, day % 2 + 1 });
								}
							}
						} else { // 밤
							if (stateChanging) {
								queue.add(new int[] { y, x, hammers, day % 2 + 1 });
							} else {
								dp[y][x][hammers]++;
								stateChanging = true;
								queue.add(new int[] { y, x, hammers, day % 2 + 1 });
							}
						}
					}
				}
			}
		}

		int minValue = Integer.MAX_VALUE;

		for (int i = 0; i < K + 1; i++) {
			minValue = Math.min(minValue, dp[N - 1][M - 1][i]);
		}

		if (minValue == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minValue);
	}
}