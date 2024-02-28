import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] map;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static boolean[] alphabet = new boolean[26];
	static int maxValue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		alphabet[map[0][0] - 'A'] = true;
		visited[0][0] = true;
		dfs(0, 0, 0);
		System.out.println(maxValue + 1);
	}
	
	private static void dfs(int y, int x, int count) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (0 <= ny && ny < R && 0 <= nx && nx < C && !visited[ny][nx] && !alphabet[map[ny][nx] - 'A']) {
				alphabet[map[ny][nx] - 'A'] = true;
				visited[ny][nx] = true;
				dfs(ny, nx, count + 1);
				maxValue = Math.max(maxValue, count + 1);
				
				alphabet[map[ny][nx] - 'A'] = false;
				visited[ny][nx] = false;
			}
		}
	}
}