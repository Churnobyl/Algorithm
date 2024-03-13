import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int aIdx = 0;
		int bIdx = 0;
		
		while (aIdx < N && bIdx < M) {
			if (A[aIdx] > B[bIdx]) {
				sb.append(B[bIdx] + " ");
				bIdx++;
			} else {
				sb.append(A[aIdx] + " ");
				aIdx++;				
			}
		}
		
		if (aIdx < N) {
			while (aIdx < N) {
				sb.append(A[aIdx] + " ");
				aIdx++;
			}
		} else if (bIdx < M) {
			while (bIdx < M) {
				sb.append(B[bIdx] + " ");
				bIdx++;
			}
		}
		
		System.out.println(sb);
	}
}