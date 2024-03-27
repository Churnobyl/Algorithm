import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] planets, edges;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		edges = new int[3 * (N - 1)][3];
		planets = new int[N][4];
		p = new int[N];
		
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			planets[i][0] = Integer.parseInt(st.nextToken());
			planets[i][1] = Integer.parseInt(st.nextToken());
			planets[i][2] = Integer.parseInt(st.nextToken());
			planets[i][3] = count++; 
		}
		
		count = 0;
		
		for (int i = 0; i < 3; i++) {
			final int idx = i;
			Arrays.sort(planets, (a, b) -> Integer.compare(a[idx], b[idx]));
			
			for (int j = 0; j < N - 1; j++) {
				edges[count][0] = planets[j][3];
				edges[count][1] = planets[j + 1][3];
				edges[count][2] = Math.abs(planets[j][i] - planets[j + 1][i]);
				count++;
			}
		}
		
		Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
		
		long total = 0;
		count = 0;
		
		for (int i = 0; i < 3 * (N - 1); i++) {
			int[] next = edges[i];
			
			if (union(next[0], next[1])) {
				total += next[2];
				count++;
			}
			
			if (count == N - 1) break;
		}
		
		System.out.println(total);
	}

	private static int find(int x) {
		if (x == p[x]) return x;
		return p[x] = find(p[x]);
	}
	
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) return false;
		
		p[y] = x;
		return true;
	}
}