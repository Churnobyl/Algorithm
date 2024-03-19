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
	static int N, M, end;
	static Map<Integer, Edge>[] edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		edges = new HashMap[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			edges[i] = new HashMap<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edges[s].put(e, new Edge(e,Math.min(edges[s].getOrDefault(e, new Edge(0, Integer.MAX_VALUE)).cost, cost)));
		}
		
		Queue<Edge> queue = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int[] costs = new int[N + 1];
		
		Arrays.fill(costs, Integer.MAX_VALUE);
		
		queue.add(new Edge(start, 0));
		costs[start] = 0;		
		
		while (!queue.isEmpty()) {
			Edge data = queue.poll();
			
			for (Edge edge : edges[data.e].values()) {
				if (costs[edge.e] > costs[data.e] + edge.cost) {
					costs[edge.e] = costs[data.e] + edge.cost;
					
					queue.add(new Edge(edge.e, costs[edge.e]));
				}
			}	
		}
		
		System.out.println(costs[end]);
	}
}