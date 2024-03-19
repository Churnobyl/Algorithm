import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int e, cost;

	public Edge(int e, int cost) {
		super();
		this.e = e;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.e - o.e;
	}
}

public class Main {
	static int N, E, v1, v2;
	static List<Edge>[] edges;
	static int[] costs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		
		edges = new ArrayList[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[a].add(new Edge(b, c));
			edges[b].add(new Edge(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
				
		int cache1 = 0;
		int cache2 = 0;
		
		int cache = 0;
		
		boolean check1 = false;
		boolean check2 = false;
		
		if (!((cache = dijkstra(1, v1)) == Integer.MAX_VALUE)) {
			cache1 += cache;
			if (!((cache = dijkstra(v2, N)) == Integer.MAX_VALUE)) {
				cache1 += cache;
				check1 = true;
			}
		}
		
		if (!((cache = dijkstra(1, v2)) == Integer.MAX_VALUE)) {
			cache2 += cache;
			if (!((cache = dijkstra(v1, N)) == Integer.MAX_VALUE)) {
				cache2 += cache;
				check2 = true;
			}
		}
		
		cache1 = dijkstra(1, v1) + dijkstra(v2, N);
		cache2 = dijkstra(1, v2) + dijkstra(v1, N);
		
		if (!((cache = dijkstra(v1, v2)) == Integer.MAX_VALUE)) {
			if (check1 && check2) {
				System.out.println(Math.min(cache1, cache2) + cache);
			} else {
				System.out.println(-1);
			}
		} else {
			System.out.println(-1);
		}
	}
	
	private static int dijkstra(int start, int end) {
		Queue<Edge> pq = new PriorityQueue<>();
		costs = new int[N + 1];
		Arrays.fill(costs, Integer.MAX_VALUE);
		pq.add(new Edge(start, 0));
		costs[start] = 0;
		
		while (!pq.isEmpty()) {
			Edge data = pq.poll();
			
			for (Edge edge : edges[data.e]) {
				if (costs[edge.e] > costs[data.e] + edge.cost) {
					costs[edge.e] = costs[data.e] + edge.cost;
					
					if (edge.e == end) continue;
					
					pq.add(new Edge(edge.e, costs[edge.e]));
				}
			}
		}
		
		return costs[end];
	}
}