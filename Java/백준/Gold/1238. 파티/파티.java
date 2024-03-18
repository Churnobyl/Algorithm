import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int e, cost;

	public Edge(int e, int cost) {
		this.e = e;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

public class Main {
	static int N, M, X, maxValue;
	static ArrayList<Edge>[] info;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		info = new ArrayList[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			info[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			info[s].add(new Edge(e, cost));
		}
		
		for (int i = 1; i < N + 1; i++) {
			if (i == X) continue;
			
			int cache = 0;
			cache += dijkstra(i, X);
			cache += dijkstra(X, i);
			
			maxValue = Math.max(cache, maxValue);
		}
		
		System.out.println(maxValue);
	}
	
	private static int dijkstra(int start, int end) {
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		Queue<Edge> queue = new PriorityQueue<>();
		queue.add(new Edge(start, 0));
		dp[start] = 0;
		
		while (!queue.isEmpty()) {
			Edge curr = queue.poll();
			if (info[curr.e].size() == 0) continue;
			
			for (Edge nxt : info[curr.e]) {
				if (dp[nxt.e] > dp[curr.e] + nxt.cost) {
					dp[nxt.e] = dp[curr.e] + nxt.cost;
					queue.add(new Edge(nxt.e, dp[nxt.e]));
				}
			}
		}
		
		return dp[end];
	}
}