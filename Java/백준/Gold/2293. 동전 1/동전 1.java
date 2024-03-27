import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
		}
        
        dp = new int[k + 1];
        
        dp[0] = 1;
        
        for (int i = 0; i < n; i++) {
			int value = arr[i];
			
			for (int j = value; j < k + 1; j++) {
				dp[j] += dp[j - value];
			}
		}
        
        System.out.println(dp[k]);
    }

}