import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] dp;
	static int dy[] = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int dx[] = {-1, 1, -2, 2, -2, 2, -1, 1};
	static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
        	N = Integer.parseInt(br.readLine());
        	dp = new int[N][N];
        	
        	for (int j = 0; j < N; j++) {
				Arrays.fill(dp[j], Integer.MAX_VALUE);
			}
        	        	
        	int[] sp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	int[] ep = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	
        	dp[sp[0]][sp[1]] = 0;
        	
        	queue.add(new int[] {sp[0], sp[1]});
        	
        	while (!queue.isEmpty()) {
        		int[] next = queue.poll();
        		
        		int y = next[0];
        		int x = next[1];
        		
        		if (y == ep[0] && x == ep[1]) {
        			continue;
        		}
        		
        		for (int j = 0; j < 8; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];
					
					if (0 <= ny && ny < N && 0 <= nx && nx < N) {
						if (dp[ny][nx] > dp[y][x] + 1) {
							dp[ny][nx] = dp[y][x] + 1;
							queue.add(new int[] {ny, nx});
						}
					}
				}
        	}
        	
        	sb.append(dp[ep[0]][ep[1]] + "\n");
		}
        
        System.out.println(sb);
        
    }
}