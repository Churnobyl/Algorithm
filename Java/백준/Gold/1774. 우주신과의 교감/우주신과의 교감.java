import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] points;
	static int[] p;
	static Queue<double[]> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        p = new int[N + 1];
        points = new int[N + 1][2];
        edges = new PriorityQueue<>(new Comparator<double[]>() {

			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o1[2], o2[2]);
			}
		});
        
        for (int i = 0; i < N + 1; i++) {
			p[i] = i;
		}
        
        for (int i = 1; i < N + 1; i++) {
        	st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
			
			for (int j = 1; j < i; j++) {
				double len = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
				edges.add(new double[] {j, i, len});
			}
		}
        
        for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
        
        double total = 0;
        
        while (!edges.isEmpty()) {
        	double[] next = edges.poll();
        	
        	if (union((int)next[0], (int)next[1])) {
        		total += next[2];
        	}
        }
        
        System.out.printf("%.2f\n", total);
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