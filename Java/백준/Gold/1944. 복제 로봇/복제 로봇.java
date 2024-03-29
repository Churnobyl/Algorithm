import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] p;
	static int[][] map;
	static int[][][] dp;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static boolean[] robotTouchCheck;
	static Map<String, int[]> edgeSet = new HashMap<>();
	static int[][] edges;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N - 2][N - 2];
		dp = new int[N - 2][N - 2][M + 2];
		p = new int[M + 2];
		robotTouchCheck = new boolean[M + 2];
		
		for (int i = 0; i < M + 2; i++) {
			p[i] = i;
		}
		
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < N - 2; j++) {
				Arrays.fill(dp[i][j], Integer.MAX_VALUE);
			}
		}
		
		int keyCount = 2;
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			if (i == 0 || i == N - 1) continue;
			
			for (int j = 0; j < N; j++) {
				if (j == 0 || j == N - 1) continue;
				char data = line.charAt(j);
				
				if (data == '1') map[i - 1][j - 1] = -1;
				else if (data == '0') map[i - 1][j - 1] = 0;
				else if (data == 'S') {
					map[i - 1][j - 1] = 1;
					dp[i - 1][j - 1][1] = 0;
					queue.add(new int[] {i - 1, j - 1, 1});
				}
				else if (data == 'K') {
					map[i - 1][j - 1] = keyCount++;
					dp[i - 1][j - 1][map[i - 1][j - 1]] = 0;
				}
			}
		}
		
		while (!queue.isEmpty()) {
			int[] next = queue.poll(); 
			int y = next[0];
			int x = next[1];
			int id = next[2];
			
			if (map[y][x] > 0 && id != map[y][x]) {
				int first = 0;
				int last = 0;
				
				if (id > map[y][x]) {
					first = map[y][x];
					last = id;
				} else {
					first = id;
					last = map[y][x];					
				}
				
				String key = first + "-" + last;
				if (!edgeSet.containsKey(key)) {
					
					if (first == 1) robotTouchCheck[last] = true;
					else if (robotTouchCheck[first]) robotTouchCheck[last] = true;
					else if (robotTouchCheck[last]) robotTouchCheck[first] = true;
					edgeSet.put(key, new int[] {first, last, dp[y][x][id]});
					queue.add(new int[] {y, x, map[y][x]});
				}
				
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (0 <= ny && ny < N - 2 && 0 <= nx && nx < N - 2 && map[ny][nx] >= 0) {
					if (dp[y][x][id] + 1 < dp[ny][nx][id]) {
						dp[ny][nx][id] = dp[y][x][id] + 1;
						queue.add(new int[] {ny, nx, id});
					}
				}
			}
		}
		
		if (edgeSet.size() == 0) {
			System.out.println(-1);
			return;
		}
		
		edges = new int[edgeSet.size()][3];
		edgeSet.values().toArray(edges);
		
		Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
		
		int total = 0;
		int count = 0;
		
		for (int i = 0; i < edges.length; i++) {
			int[] d = edges[i];
			
			if (union(d[0], d[1])) {
				total += d[2];
				count++;
			}
			
			if (count == M) break;
		}
		
		if (count != M) System.out.println(-1);
		else System.out.println(total);
	}

	private static int find(int x) {
		if (p[x] == x)
			return x;
		return p[x] = find(p[x]);
	}

	private static boolean union(int x, int y) {
		if (!robotTouchCheck[x] && !robotTouchCheck[y]) return false;
		
		x = find(x);
		y = find(y);

		if (x == y)
			return false;

		p[y] = x;
		return true;
	}
}
