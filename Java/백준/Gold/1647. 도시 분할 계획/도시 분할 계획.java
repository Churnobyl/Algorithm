import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] edges;
	static int[] p;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        edges = new int[M][3];
        p = new int[N + 1];
        
        for (int i = 1; i < N + 1; i++) {
			p[i] = i;
		}
        
        for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
        
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        
        int maxValue = 0;
        int total = 0;
        int count = 0;
        
        for (int i = 0; i < M; i++) {
			int[] edge = edges[i];
			if (union(edge[0], edge[1])) {
				total += edge[2];
				maxValue = Math.max(maxValue, edge[2]);
				count++;
			}
			
			if (count == N - 1) break;
		}
        
        System.out.println(total - maxValue);
        
    }
    
    private static int find(int x) {
    	if (p[x] == x) return x;
    	return p[x] = find(p[x]);
    }
    
    private static boolean union(int x, int y) {
    	x = find(x);
    	y = find(y);
    	
    	if (x == y) return false;
    	
    	p[y] = x;
    	
    	return true;
    }
}
