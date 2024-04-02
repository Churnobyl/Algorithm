import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] degree;
	static int[] result;
	static List<Integer>[] edges;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		degree = new int[N + 1];
		result = new int[N + 1];
		
		edges = new ArrayList[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			edges[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int pre = Integer.parseInt(st.nextToken());
			int post = Integer.parseInt(st.nextToken());
			
			edges[pre].add(post);
			degree[post]++;
		}
		
		for (int i = 1; i < N + 1; i++) {
			if (degree[i] == 0) {
				result[i] = 1;
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int e = queue.poll();
			
			for (int data : edges[e]) {
				degree[data]--;
				
				if (degree[data] == 0) {
					result[data] = result[e] + 1;
					queue.add(data);
				}
			}
		}
		
		for (int i = 1; i < N + 1; i++) {
			System.out.print(result[i] + " ");
		}
	}

}