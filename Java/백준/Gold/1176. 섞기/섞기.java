import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static long total;
    static int[] students;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        students = new int[N];
        dp = new long[1 << N][N];
        
        for (int i = 0; i < N; i++) {
			students[i] = Integer.parseInt(br.readLine());
			for (int j = 0; j < (1 << N); j++) {
				dp[j][i] = -1;
			}
		}
        
        for (int i = 0; i < N; i++) {
        	total += dfs(1 << i, i);
		}
        System.out.println(total);
    }
    
    private static long dfs(int visited, int depth) {
    	if (visited == (1 << N) - 1) {
    		return 1;
    	}
    	
    	if (dp[visited][depth] != -1) return dp[visited][depth];
    	
    	dp[visited][depth] = 0;
    	for (int i = 0; i < N; i++) {
    		if ((visited & (1 << i)) == 0 && Math.abs(students[depth] - students[i]) > K) {
    			dp[visited][depth] += dfs(visited | (1 << i), i);
    		}
		}
    	
    	return dp[visited][depth];
    }
}