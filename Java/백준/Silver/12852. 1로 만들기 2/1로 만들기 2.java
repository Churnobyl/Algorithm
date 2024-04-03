import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class Main {
	static int N;
	static int[] dp, prev;
	static Queue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		prev = new int[N + 1];

		Arrays.fill(dp, Integer.MAX_VALUE);
		
		pq.add(N);
		dp[N] = 0;
		
		while (!pq.isEmpty()) {
			int x = pq.poll();
			
			if (x == 1) continue;
			
			if (x % 3 == 0 && dp[x / 3] > dp[x] + 1) {
				dp[x / 3] = dp[x] + 1;
				prev[x / 3] = x;
				pq.add(x / 3);
			}
			
			if (x % 2 == 0 && dp[x / 2] > dp[x] + 1) {
				dp[x / 2] = dp[x] + 1;
				prev[x / 2] = x;
				pq.add(x / 2);
			}
			
			if (dp[x - 1] > dp[x] + 1) {
				dp[x - 1] = dp[x] + 1;
				prev[x - 1] = x;
				pq.add(x - 1);
			}
		}
		
		System.out.println(dp[1]);
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 1; i != N; i = prev[i]) {
			stack.add(i);
		}
		
		stack.add(N);
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}