import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static Queue<int[]> jewelQ = new PriorityQueue<>(new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			if (Integer.compare(o1[0], o2[0]) == 0) {
				return Integer.compare(o2[1], o1[1]);
			}
			
			return Integer.compare(o1[0], o2[0]);
		}
	});
	static Queue<int[]> candiQ = new PriorityQueue<>(new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			return Integer.compare(o2[1], o1[1]);
		}
	});
	
	static Integer[] bags;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bags = new Integer[K];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			jewelQ.add(new int[] {weight, value});
		}
		
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bags);
		
		long total = 0;
		
		for (int i = 0; i < K; i++) {
			while (!jewelQ.isEmpty() && bags[i] >= jewelQ.peek()[0]) {
				candiQ.add(jewelQ.poll());
			}
			
			if (!candiQ.isEmpty()) {
				total += candiQ.poll()[1];
			}
		}
		
		System.out.println(total);
	}
}