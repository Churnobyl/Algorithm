import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] visited;
	static int[] arr;
	static int[] savedArr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		arr = new int[N];
		savedArr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		permutation(0);
		System.out.println(sb);
	}
	
	private static void permutation(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(savedArr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				savedArr[idx++] = arr[i];
				visited[i] = true;
				permutation(idx);
				idx--;
				visited[i] = false;
			}
		}
	}
}
