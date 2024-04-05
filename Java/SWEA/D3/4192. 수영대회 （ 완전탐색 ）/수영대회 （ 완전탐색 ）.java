import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static int[] s, e;
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] dp;
    static boolean[][] map;
    
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
         
        for (int i = 1; i <= T; i++) {
        	N = Integer.parseInt(br.readLine());
        	queue.clear();
        	map = new boolean[N][N];
        	dp = new int[N][N];
        	
        	for (int j = 0; j < N; j++) {
				Arrays.fill(dp[j], Integer.MAX_VALUE);
			}
        	
        	for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < N; j2++) {
					map[j][j2] = st.nextToken().equals("1") ? false : true;
				}
			}
        	
        	st = new StringTokenizer(br.readLine());
        	
        	s = new int[2];
        	
        	s[0] = Integer.parseInt(st.nextToken());
        	s[1] = Integer.parseInt(st.nextToken());
        	
        	queue.add(new int[] {s[0], s[1]});
        	dp[s[0]][s[1]] = 0;
        	
        	e = new int[2];
        	
        	st = new StringTokenizer(br.readLine());
        	
        	e[0] = Integer.parseInt(st.nextToken());
        	e[1] = Integer.parseInt(st.nextToken());
        	
        	while (!queue.isEmpty()) {
        		int[] next = queue.poll();
        		
        		int y = next[0];
        		int x = next[1];
        		
        		for (int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];
					
					if (0 <= ny && ny < N && 0 <= nx && nx < N && map[ny][nx]) {
						if (dp[y][x] + 1 < dp[ny][nx]) {
							dp[ny][nx] = dp[y][x] + 1;
							queue.add(new int[] {ny, nx});
						}
					}
				}
        		
        	}
            
            // 출력부
            sb.append("#").append(i).append(" ");

            if (dp[e[0]][e[1]] == Integer.MAX_VALUE) sb.append("-1");
            else sb.append(dp[e[0]][e[1]]);

            sb.append("\n");
        }
 
        System.out.print(sb.toString());
    }
}