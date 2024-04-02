import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 2];
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int wage = Integer.parseInt(st.nextToken());
			
			if (i + day < N + 2) {
				int max = 0;
				for (int j = 0; j <= i; j++) {
					max = Math.max(max, dp[j]);
				}
				
				if (dp[i + day] < max + wage) {
					dp[i + day] = max + wage;
				}
			}
		}
		
		int maxValue = 0;
		
		for (int i = 0; i < N + 2; i++) {
			maxValue = Math.max(maxValue, dp[i]);
		}
		
		System.out.println(maxValue);
	}

}