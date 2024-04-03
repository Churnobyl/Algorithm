import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int e, dist;

	public Edge(int e, int dist) {
		super();
		this.e = e;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(dist, o.dist);
	}
}

public class Main {
	static int n, m, start, end;
	static int[] dp;
	static int[] prev;
	static boolean[] visited;
	static Queue<Edge> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		List<ArrayList<Edge>> nodes = new ArrayList<>();
		dp = new int[n + 1];
		prev = new int[n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 0; i < n + 1; i++) {
			prev[i] = -1;
		}
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for (int i = 0; i < n + 1; i++) {
			nodes.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			nodes.get(s).add(new Edge(e, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dp[start] = 0;
		prev[start] = start;
		
		pq.add(new Edge(start, 0));
		
		while (!pq.isEmpty()) {
			Edge next = pq.poll();
			
			if (visited[next.e]) continue;
			
			visited[next.e] = true;
			
			for (Edge edge : nodes.get(next.e)) {
				if (!visited[edge.e] && dp[next.e] + edge.dist < dp[edge.e]) {
					dp[edge.e] = dp[next.e] + edge.dist;
					prev[edge.e] = next.e;
					pq.add(new Edge(edge.e, dp[edge.e]));
				}
			}
		}
		
		System.out.println(dp[end]);
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = end; i != start; i = prev[i]) {
			stack.push(i);
		}
		
		stack.push(start);
		
		System.out.println(stack.size());
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}