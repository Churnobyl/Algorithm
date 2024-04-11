import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N + 1][K + 1];
		
		for (int i = 0; i < N + 1; i++) {
			dp[i][0] = 1;
			
			if (i < K + 1)
				dp[i][i] = 1;
		}
		
		System.out.println(recursion(N, K));
	}

	private static int recursion(int n, int k) {
		if (k == 0 || k == n) return dp[n][k];
		if (dp[n][k] != 0) return dp[n][k];
		
		dp[n][k] = (recursion(n - 1, k - 1) + recursion(n - 1, k)) % 10_007;
		
		return dp[n][k];
	}
}
