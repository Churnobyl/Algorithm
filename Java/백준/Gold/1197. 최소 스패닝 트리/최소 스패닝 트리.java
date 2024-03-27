import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static int[][] edges;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edges = new int[E][3];
		p = new int[V + 1];
		
		for (int i = 1; i < V + 1; i++) {
			p[i] = i;
		}

		for (int i = 0; i < E; i++) {
			edges[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		int total = 0;
		int count = 0;
		
		for (int i = 0; i < E; i++) {
			int[] next = edges[i];
			
			if (union(next[0], next[1])) {
				total += next[2];
				count++;
			}
			
			if (count == V - 1) break;
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