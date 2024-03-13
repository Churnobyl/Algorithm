import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R, count = 1;
	static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];
        order = new int[N + 1];
        Arrays.fill(order, -1);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
            list[b].add(a);
		}
		
		for (int i = 1; i <= N; i++) {
            Collections.sort(list[i], Collections.reverseOrder());
        }
		
		dfs(R, 0);
		
		for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
	}

	
	public static void dfs(int node, int depth) {
        visited[node] = true;
        order[node] = depth;
        for (int next : list[node]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
    }
}