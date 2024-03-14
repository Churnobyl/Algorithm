import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int row = 0, count, bombCount;
	static char[][] map;
	static Stack<int[]> stack = new Stack<>();
	
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[13][6];
		
		for (int i = 0; i < 12; i++) {
			String line = br.readLine();
			
			if (line.equals("......")) continue;
			
			for (int j = 0; j < 6; j++) {
				map[row][j] = line.charAt(j);
			}
			row++;
		}
		
		while (true) {
			boolean a = findAndBomb();
			if (!a) {
				break;
			} else count++;
			gravity();
		}
		
		System.out.println(count);
	}
	
	private static boolean findAndBomb() {
		boolean[][] visited = new boolean[row][6];
		boolean isis = false;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < 6; j++) {
				if (!visited[i][j] && map[i][j] != '.') {
					bombCount = 1;
					if (dfs(i, j, visited)) {
						while (!stack.isEmpty()) {
							int[] a = stack.pop();
							map[a[0]][a[1]] = '.';
						}
						isis = true;
					} else {
						stack.clear();
					}
				}
			}
		}
		
		return isis;
	}
		
	private static boolean dfs(int y, int x, boolean[][] visited) {
		visited[y][x] = true;
		stack.add(new int[] {y, x});
		
		boolean haveOther = false;
		boolean isPop = false;
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (0 <= ny && ny < row && 0 <= nx && nx < 6) {
				if (!visited[ny][nx] && map[y][x] == map[ny][nx]) {
					haveOther = true;
					bombCount++;
					
					if (dfs(ny, nx, visited)) {
						isPop = true;
					}
				}
			}
		}
		
		if (isPop) {
			return true;
		}
		
		if (!haveOther && bombCount >= 4) {
			return true;
		}
		
		return false;
	}
	
	private static void gravity() {
		for (int j = 0; j < 6; j++) {
			int i = row;

			while (i >= 0) {
				if (map[i][j] == '.') {
					int t = i - 1;
					
					while (t >= 0 && map[t][j] == '.') {
						t--;
					}
					
					if (t >= 0 && map[t][j] != '.') {
						map[i][j] = map[t][j];
						map[t][j] = '.';
					}
				} 
				
				i--;
			}
		}
	}
}