import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, maxValue, drawingCount;
	static int[][] map;
	static boolean[][] visited;

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					visited[i][j] = true;
					maxValue = Math.max(maxValue, dfs(i, j) + 1);
					drawingCount++;
				}
			}
		}
		
		System.out.println(drawingCount);
		System.out.println(maxValue);
	}
	
	private static int dfs(int y, int x) {
		int t = 0;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (0 <= ny && ny < n && 0 <= nx && nx < m && !visited[ny][nx] && map[ny][nx] == 1) {
				visited[ny][nx] = true;
				t += 1 + dfs(ny, nx);
				
			}
		}
		
		return t;
	}
}