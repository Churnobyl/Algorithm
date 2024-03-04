import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static Queue<Integer> queue = new LinkedList<>();
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[100_001];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[N] = 0;
		queue.add(N);
		
		int result = Integer.MAX_VALUE;
		
		while (!queue.isEmpty()) {
			int subin = queue.poll();
			
			if (subin == K) {
				result = Math.min(result, dp[K]);
			}
			
			if (subin < K && subin * 2 < 100_001 && dp[subin] < dp[subin * 2]) {
				dp[subin * 2] = dp[subin];
				queue.add(subin * 2);
			}
			
			if (subin + 1 < 100_001 && dp[subin] + 1 < dp[subin + 1]) {
				dp[subin + 1] = dp[subin] + 1;
				queue.add(subin + 1);
			}
			if (subin - 1 >= 0 && dp[subin] + 1 < dp[subin - 1]) {
				dp[subin - 1] = dp[subin] + 1;
				queue.add(subin - 1);
			}
		}
		
		System.out.println(result);
	}

}