import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] dp;
	static int[] dy = { 1, 0 };
	static int[] dx = { 0, 1 };
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		dp[0][0] = map[0][0];
		queue.add(new int[] { 0, 0 });

		while (!queue.isEmpty()) {	
			int[] next = queue.poll();
			int y = next[0];
			int x = next[1];
			
			if (y == N - 1 && x == M - 1) continue;

			for (int i = 0; i < 2; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (0 <= ny && ny < N && 0 <= nx && nx < M) {
					if (dp[y][x] + map[ny][nx] > dp[ny][nx]) {
						dp[ny][nx] = dp[y][x] + map[ny][nx];
						queue.add(new int[] { ny, nx });						
					}
				}
			}
		}

		System.out.println(dp[N - 1][M - 1]);
	}
}