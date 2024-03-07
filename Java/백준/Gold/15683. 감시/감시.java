import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, zeroCount, maxValue = Integer.MIN_VALUE, cacheCount = 0;
	static int[][] map;
	static int[][][] dp;
	static List<int[]> cctvData = new LinkedList<>();
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) zeroCount++;
				if (map[i][j] > 0 && map[i][j] < 6) {
					cctvData.add(new int[] {map[i][j], i, j});
				}
			}
		}
		
		dp = new int[N][M][cctvData.size() + 1];
		
		recursion(0);
		System.out.println(zeroCount - maxValue);
	}
	
	private static void recursion(int idx) {
		if (idx == cctvData.size()) {
			maxValue = Math.max(maxValue, cacheCount);
			return;
		}
		
		int[] cctv = cctvData.get(idx);
		
		for (int k = 0; k < 4; k++) {
			switch (cctv[0]) {
			case 1:
				cacheCount += find(cctv[1], cctv[2], idx, k);
				recursion(idx + 1);
				break;
			case 2:
				if (k > 1) continue;
				cacheCount += find(cctv[1], cctv[2], idx, k);
				cacheCount += find(cctv[1], cctv[2], idx, k + 2);
				recursion(idx + 1);
				break;
			case 3:
				cacheCount += find(cctv[1], cctv[2], idx, k);
				cacheCount += find(cctv[1], cctv[2], idx, (k + 1) % 4);
				recursion(idx + 1);
				break;
			case 4:
				cacheCount += find(cctv[1], cctv[2], idx, k);
				cacheCount += find(cctv[1], cctv[2], idx, (k + 1) % 4);
				cacheCount += find(cctv[1], cctv[2], idx, (k + 2) % 4);
				recursion(idx + 1);
				break;
			case 5:
				for (int i = 0; i < 4; i++) {
					cacheCount += find(cctv[1], cctv[2], idx, i);
				}
				recursion(idx + 1);
				break;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (dp[i][j][idx + 1] == 1 && map[i][j] == 0) {
						dp[i][j][idx + 1] = 0;
						dp[i][j][0]--;
						
						if (dp[i][j][0] == 0) {
							cacheCount--;							
						}
						
					}
				}
			}
		}
		
		
	}
	
	private static int find(int y, int x, int idx, int direction) {
		dp[y][x][idx + 1] = 1;
		
		int cache = 0;
		if (map[y][x] == 0) {
			if (dp[y][x][0] == 0)
				cache++;
			dp[y][x][0]++;
		}
		
		int ny = y + dy[direction];
		int nx = x + dx[direction];
		
		if (0 <= ny && ny < N && 0 <= nx && nx < M && map[ny][nx] != 6) {
			cache += find(ny, nx, idx, direction);
		}

		return cache;
	}
}       