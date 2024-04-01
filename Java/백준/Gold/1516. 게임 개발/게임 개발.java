import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] degree, costs;
	static Queue<Integer> queue = new LinkedList<>();
	static List<Integer>[] edges;
	static int[] prev;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		degree = new int[N + 1];
		edges = new ArrayList[N + 1];
		prev = new int[N + 1];
		costs = new int[N + 1];
		result = new int[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			costs[i] = cost;
			
			int count = 0;
			
			int s = -1;
			while ((s = Integer.parseInt(st.nextToken())) != -1) {
				count++;
				edges[s].add(i);
				degree[i]++;
			}
			
			if (count == 0) {
				queue.add(i);
				continue;
			}
			
			
		}
		
		while (!queue.isEmpty()) {
			int next = queue.poll();
			result[next] = costs[next];
			
			for (int e : edges[next]) {
				degree[e]--;
				prev[e] = Math.max(prev[e], costs[next]);
				
				if (degree[e] == 0) {
					costs[e] += prev[e];
					queue.add(e);
				}
			}
		}
		
		for (int i = 1; i < N + 1; i++) {
			System.out.println(result[i]);
		}
	}
}
