import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, G, R, maxFlowers;
	static int[][] map;
	static List<int[]> canImpl = new ArrayList<>();
	static List<int[]> planting = new LinkedList<>();
	static Queue<int[]> queue = new LinkedList<>();
	static boolean[] visited;

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					canImpl.add(new int[] { i, j });
				}
			}
		}

		visited = new boolean[canImpl.size()];

		recursion(0, 0, 0);
		System.out.println(maxFlowers);
	}

	private static void recursion(int idx, int g, int r) {
		if (g >= G && r >= R) {
			find();
			return;
		}
		
		if (idx >= canImpl.size()) return;

		int[] data = canImpl.get(idx);

		if (g < G) {
			planting.add(new int[] { data[0], data[1], 0, 0 });
			visited[idx] = true;
			recursion(idx + 1, g + 1, r);
			visited[idx] = false;
			planting.remove(planting.size() - 1);
		}

		if (r < R) {
			planting.add(new int[] { data[0], data[1], 1, 0 });
			visited[idx] = true;
			recursion(idx + 1, g, r + 1);
			visited[idx] = false;
			planting.remove(planting.size() - 1);
		}
		
		recursion(idx + 1, g, r);
	}

	private static void find() {
		queue.clear();
		queue.addAll(planting);
		int[][][] visited = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(visited[i][j], Integer.MIN_VALUE);
			}
		}

		for (int i = 0; i < planting.size(); i++) {
			int[] d = planting.get(i);
			visited[d[0]][d[1]][d[2]] = 0;
		}

		int flowers = 0;

		while (!queue.isEmpty()) {
			int[] nxt = queue.poll();

			int y = nxt[0];
			int x = nxt[1];
			int isGR = nxt[2];
			int t = nxt[3];
			
			if (visited[y][x][0] == 10000) continue;

			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (0 <= ny && ny < N && 0 <= nx && nx < M && map[ny][nx] != 0) {
					if (isGR == 0) {
						if (visited[ny][nx][1] == t + 1) {
							visited[ny][nx][0] = visited[ny][nx][1] = 10000;
							flowers++;
						} else if (visited[ny][nx][0] < 0 && visited[ny][nx][1] < 0) {
							visited[ny][nx][0] = t + 1;
							queue.add(new int[] { ny, nx, isGR, t + 1 });
						}
					} else if (isGR == 1) {
						if (visited[ny][nx][0] == t + 1) {
							visited[ny][nx][0] = visited[ny][nx][1] = 10000;
							flowers++;
						} else if (visited[ny][nx][0] < 0 && visited[ny][nx][1] < 0) {
							visited[ny][nx][1] = t + 1;
							queue.add(new int[] { ny, nx, isGR, t + 1 });
						}
					}
				}
			}

			maxFlowers = Math.max(maxFlowers, flowers);
		}
	}
}
