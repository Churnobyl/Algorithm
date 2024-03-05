import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, S, total;
	static int[] arr;
	static Set<String> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        
        dfs(0, 0, "");
        
        System.out.println(set.size());
    }
    
    private static void dfs(int now, int depth, String data) {
    	if (now == S && !data.equals("")) set.add(data);
    	if (depth >= N) return;
    	
    	dfs(now + arr[depth], depth + 1, data + "," + depth);
    	dfs(now, depth + 1, data);
    }
}