import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, count;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs(N, 1, 2, 3);
		System.out.println(count);
		System.out.println(sb);
	}
	
	private static void dfs(int N, int from, int via, int to) {
		count++;
		if (N == 1) sb.append(from + " " + to + "\n");
		else {
			dfs(N - 1, from, to, via);
			sb.append(from + " " + to + "\n");
			dfs(N - 1, via, from, to);
		}
	}
}