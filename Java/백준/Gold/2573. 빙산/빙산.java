import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, years;
	static int[][][] map;
	static int mapFlag = 0;
	static boolean[][] visited;
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M][2];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
				map[i][j][1] = map[i][j][0];
			}
		}
		
		boolean allMeltedFlag = false;
		
		loop1:
		while (true) {			
			visited = new boolean[N][M];
			int count = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j][mapFlag] > 0 && map[i][j][(mapFlag + 1) % 2] > 0 && !visited[i][j]) {
						if (count > 0) break loop1;
						count++;
						visited[i][j] = true;
						dfs(i, j);
					}
				}
			}

			if (count == 0) {
				allMeltedFlag = true;
				break;
			}
			
			years++;
			mapFlag = (mapFlag + 1) % 2;
		}
		
		if (allMeltedFlag) {
			System.out.println(0);
		} else {
			System.out.println(years);
		}
	}
	
	private static void dfs(int y, int x) {
		int oceanCount = 0;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (0 <= ny && ny < N && 0 <= nx && nx < M) {
				if (map[ny][nx][mapFlag] == -1) {
					map[ny][nx][(mapFlag + 1) % 2] = 0;
				}
				if (map[ny][nx][mapFlag] < 1) oceanCount++;
				
				if (!visited[ny][nx] && map[ny][nx][mapFlag] > 0) {
					visited[ny][nx] = true;
					dfs(ny, nx);
				}
			}
		}
		
		if (map[y][x][mapFlag] - oceanCount > 0) {
			map[y][x][(mapFlag + 1) % 2] = map[y][x][mapFlag] - oceanCount;
		} else {
			map[y][x][(mapFlag + 1) % 2] = -1;
		}
	}

}