import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] degree;
	static Queue<Integer> queue = new PriorityQueue<>();
	static List<Integer>[] edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		degree = new int[N + 1];
		edges = new ArrayList[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			edges[s].add(e);
			degree[e]++;
		}
		
		for (int i = 1; i < N + 1; i++) {
			if (degree[i] == 0) queue.add(i);
		}
		
		while (!queue.isEmpty()) {
			int next = queue.poll();
			
			sb.append(next + " ");
			
			for (int e : edges[next]) {
				degree[e]--;
				
				if (degree[e] == 0) {
					queue.add(e);
				}
			}
		}
		
		System.out.println(sb);
	}
}
