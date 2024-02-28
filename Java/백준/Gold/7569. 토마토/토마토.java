import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, H;
	static int[][][] box;
	static int[][][] visited;
	static int unripenTomatos = 0, maxDays = 0;
	static Queue<int[]> queue = new LinkedList<>();

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dz = { 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		box = new int[H][N][M]; // 높이, 세로, 가로
		visited = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < M; j2++) {
					box[i][j][j2] = Integer.parseInt(st.nextToken());
					visited[i][j][j2] = Integer.MAX_VALUE;
					if (box[i][j][j2] == 0)
						unripenTomatos++;
					if (box[i][j][j2] == 1) {
						queue.add(new int[] { i, j, j2 });
						visited[i][j][j2] = 0;
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] nxt = queue.poll();
			int z = nxt[0];
			int y = nxt[1];
			int x = nxt[2];

			maxDays = Math.max(maxDays, visited[z][y][x]);

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 3; j++) {
					int nz = z + dz[j];
					int ny = y;
					int nx = x;

					if (j == 0) {
						ny += dy[i];
						nx += dx[i];
					}

					if (0 <= nz && nz < H && 0 <= ny && ny < N && 0 <= nx && nx < M) {
						if (box[nz][ny][nx] == 0) {
							if (visited[nz][ny][nx] == Integer.MAX_VALUE) {
								unripenTomatos--;
								visited[nz][ny][nx] = visited[z][y][x] + 1;
								queue.add(new int[] { nz, ny, nx, visited[z][y][x] + 1 });
							} else if (visited[nz][ny][nx] != 0 && visited[z][y][x] + 1 < visited[nz][ny][nx]) {
								visited[nz][ny][nx] = visited[z][y][x] + 1;
								queue.add(new int[] { nz, ny, nx, visited[z][y][x] + 1 });
							}

						}
					}
				}
			}
		}

		if (unripenTomatos > 0) {
			System.out.println(-1);
		} else {
			System.out.println(maxDays);
		}
	}
}