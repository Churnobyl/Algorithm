import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, normal, greenRed;
	static char[][] drawing;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		drawing = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				drawing[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					normal++;
					greenRed++;
					dfs(i, j, drawing[i][j]);
					
					while (!queue.isEmpty()) {
						int[] data = queue.poll();
						if (!visited[data[0]][data[1]]) {
							dfs(data[0], data[1], (char) data[2]);
							normal++;
						}
					}
				}
			}
		}

		System.out.println(normal + " " + greenRed);
	}

	private static void dfs(int y, int x, char state) {
		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) {
				if (drawing[ny][nx] == state) {
					dfs(ny, nx, state);
				} else if (drawing[y][x] != 'B' && (drawing[ny][nx] == 'R' || drawing[ny][nx] == 'G')) {
					queue.add(new int[] {ny, nx, drawing[ny][nx]});
				}
			}
		}
	}
}