import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main 
{
	static int N, M;
	static int[][] doughnut;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static boolean[][] visited;
	
    public static void main( String[] args ) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        
        doughnut = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
			doughnut[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
        
        int count = 0;
        
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (doughnut[i][j] == 0 && !visited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}
        
        System.out.println(count);
    }
    
    private static void bfs(int y, int x) {
    	Stack<int[]> stack = new Stack<>();
    	stack.push(new int[] {y, x});
    	
    	while (!stack.isEmpty()) {
    		int[] cnt = stack.pop();
    		y = cnt[0];
    		x = cnt[1];
    		
    		if (visited[y][x]) continue;
    		visited[y][x] = true;
    		
    		for (int i = 0; i < 4; i++) {
    			int ny = (y + dy[i] + N) % N;
    			int nx = (x + dx[i] + M) % M;
    			
    			if (doughnut[ny][nx] == 0 && !visited[ny][nx]) {
    				stack.push(new int[] {ny, nx});
    			}
			}
    	}
    }
}