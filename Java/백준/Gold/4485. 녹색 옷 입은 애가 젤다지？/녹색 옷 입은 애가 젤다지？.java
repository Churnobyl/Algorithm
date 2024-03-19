import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int[][] map, costs;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = 1;
		
		while (true) {
			N = Integer.parseInt(br.readLine());
			
			if (N == 0) break;
			
			map = new int[N][N];
			costs = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i == 0 && j == 0) continue;
					costs[i][j] = Integer.MAX_VALUE;
				}
			}
			
			costs[0][0] = map[0][0];
			
			Queue<int[]> queue = new LinkedList<>();
			
			queue.add(new int[] {0, 0});
			
			while (!queue.isEmpty()) {
				int[] nxt = queue.poll();
				int y = nxt[0];
				int x = nxt[1];
				
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					
					if (0 <= ny && ny < N && 0 <= nx && nx < N) {
						if (costs[y][x] + map[ny][nx] < costs[ny][nx]) {
							costs[ny][nx] = costs[y][x] + map[ny][nx];
							queue.add(new int[] {ny, nx});
						}
					}
				}
			}
			
			sb.append("Problem " + t + ": " + costs[N - 1][N - 1] + "\n");		
			t++;
		}
		System.out.println(sb);
	}
}