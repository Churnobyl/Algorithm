import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, total;
	static int[] picked;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			picked = new int[n + 1];
			visited = new boolean[n + 1][2];
			total = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				picked[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 1; j < n + 1; j++) {
				if (!visited[j][0]) {
					dfs(j);
				}
			}

			System.out.println(n - total);
		}
	}

	private static void dfs(int x) {
		visited[x][0] = true;
		int nxt = picked[x];
		
		if (!visited[nxt][0]) {
			dfs(nxt);
		} else if (!visited[nxt][1]) {
			total++;
			for (int i = nxt; i != x ; i = picked[i]) {
				total++;
			}
		}
		
		visited[x][1] = true;
	}

}