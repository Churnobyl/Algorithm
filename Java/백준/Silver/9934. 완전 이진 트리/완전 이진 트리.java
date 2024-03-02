import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int K;
	static int[] arr;
	static StringBuilder[] sbs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		sbs = new StringBuilder[K];
		for (int i = 0; i < K; i++) {
			sbs[i] = new StringBuilder();
		}
		
		inorder(1, 1, st);
		
		for (int i = 0; i < K; i++) {
			System.out.println(sbs[i]);
		}
	}
	
	private static void inorder(int n, int depth, StringTokenizer st) {
		if (n > Math.pow(2, K) - 1) return;
		
		inorder(n * 2, depth + 1, st);
		sbs[depth - 1].append(st.nextToken() + " ");
		inorder(n * 2 + 1, depth + 1, st);
	}
}