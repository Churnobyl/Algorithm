import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		if (N < 2) {
			System.out.println(-1);
			return;
		}

		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;
		dp[2] = 1;

		for (int i = 4; i < N + 1; i++) {
			if (dp[i - 2] != Integer.MAX_VALUE)
				dp[i] = dp[i - 2] + 1;
			if (i >= 5 && dp[i - 5] != Integer.MAX_VALUE)
				dp[i] = Math.min(dp[i - 5] + 1, dp[i]);
		}
		if (dp[N] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[N]);
	}
}