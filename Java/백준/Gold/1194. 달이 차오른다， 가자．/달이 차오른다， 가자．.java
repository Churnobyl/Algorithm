import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static Queue<int[]> queue = new LinkedList<>();
	static char[][] map;
	static int[][][] dp;
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		dp = new int[N][M][64];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '0') queue.add(new int[] {i, j, 0, 0});
			}
		}
		
		boolean flag = false;
		
		while (!queue.isEmpty()) {
			int[] data = queue.poll();
			int y = data[0];
			int x = data[1];
			int keys = data[2];
			
			if (map[y][x] == '1') {
				flag = true;
				System.out.println(dp[y][x][keys]);
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (0 <= ny && ny < N && 0 <= nx && nx < M && map[ny][nx] != '#') {
					if ('A' <= map[ny][nx] && map[ny][nx] <= 'F') { // 문
						if ((keys & (1 << (map[ny][nx] - 'A'))) > 0 && (dp[ny][nx][keys] == 0 || dp[y][x][keys] + 1 < dp[ny][nx][keys])) {
							dp[ny][nx][keys] = dp[y][x][keys] + 1;
							queue.add(new int[] {ny, nx, keys});
						}
					} else if ('a' <= map[ny][nx] && map[ny][nx] <= 'f') { // 열쇠
						int candidateKey = (1 << (map[ny][nx] - 'a')) | keys; // 키 추가
						
						if (dp[ny][nx][candidateKey] == 0) {
							dp[ny][nx][candidateKey] = dp[y][x][keys] + 1;
							queue.add(new int[] {ny, nx, candidateKey});
						}
						
					} else {
						if (dp[ny][nx][keys] == 0 || dp[y][x][keys] + 1 < dp[ny][nx][keys]) {
							dp[ny][nx][keys] = dp[y][x][keys] + 1;
							queue.add(new int[] {ny, nx, keys});
						}
					}
				}
			}
		}
		
		if (!flag) System.out.println(-1);
	}
}