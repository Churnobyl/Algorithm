import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static Queue<Integer[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[10];
			
			queue.clear();
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				int data = Integer.parseInt(st.nextToken());
				queue.add(new Integer[] {j, data});
				arr[data]++;
			}
			
			int t = 1;
			int o = 9;
			
			while (0 < o) {
				if (arr[o] != 0) {
					while (!queue.isEmpty() && queue.peek()[1] != o) {
						queue.add(queue.poll());
					}
					
					Integer[] d = queue.poll();
					
					if (d[0] == M) {
						System.out.println(t);
						break;
					}
					
					arr[o]--;
					t++;
				}
				if (arr[o] == 0) {
					o--;					
				}
			}
		}
	}
}