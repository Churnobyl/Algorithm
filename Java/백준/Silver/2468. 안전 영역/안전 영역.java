import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, safetyZone = Integer.MIN_VALUE, now;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(map[i][j], min);
				max = Math.max(map[i][j], max);
			}
		}
        
        for (int i = min - 1; i < max + 1; i++) {
        	visited = new boolean[N][N];
        	now = i;
        	int cache = 0;
        	
        	for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if (!visited[j][j2] && map[j][j2] > i) {
						dfs(j, j2);
						cache++;
					}
				}
			}
        	
        	safetyZone = Math.max(cache, safetyZone);
		}
        
        System.out.println(safetyZone);
    }
	
	private static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx] && map[ny][nx] > now) {
				dfs(ny, nx);
			}
		}
	}
}