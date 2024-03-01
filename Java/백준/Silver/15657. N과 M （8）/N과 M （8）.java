import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] savedArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        savedArr = new int[M];
        
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        
        Arrays.sort(arr);
        
        dfs(0);
        System.out.println(sb);
    }
    
    private static void dfs(int depth) {
    	if (depth == M) {
    		for (int i = 0; i < M; i++) {
				sb.append(savedArr[i] + " ");
			}
    		sb.append("\n");
    		return;
    	}
    	
    	for (int i = 0; i < N; i++) {
    		if (depth == 0) {
    			savedArr[depth++] = arr[i];
    			dfs(depth);
    			depth--;
    		} else if (savedArr[depth - 1] <= arr[i]) {
    			savedArr[depth++] = arr[i];
    			dfs(depth);
    			depth--;    			
    		} 
		}
    }
}