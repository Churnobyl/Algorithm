import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static int n;
	static int[] dp;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i < n + 1; i++) {
			dp[i] = (dp[i - 1] % 10_007 + dp[i - 2] % 10_007) % 10_007;
		}
        
        System.out.println(dp[n]);
    }
}