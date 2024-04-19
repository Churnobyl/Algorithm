import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] A, B;
	static int[] p;
	static int[] nA, nB;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		A = new int[n];
		B = new int[n];
		nA = new int[n];
		nB = new int[n];
		p = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		for (int i = 1; i < n + 1; i++) {
			if (i == n) {
				nA[i - 1] = 360_000 - Math.abs(A[0] - A[n - 1]);
				continue;
			}
			
			nA[i - 1] = A[i] - A[i - 1];
		}
		
		for (int i = 1; i < n + 1; i++) {
			if (i == n) {
				nB[i - 1] = 360_000 - Math.abs(B[0] - B[n - 1]);
				continue;
			}
			
			nB[i - 1] = B[i] - B[i - 1];
		}
		
		int[] dB = new int[n * 2];
		
		System.arraycopy(nB, 0, dB, 0, n);
		System.arraycopy(nB, 0, dB, n, n);
		
		int begin = 1;
		int matched = 0;
		
		while (begin + matched < n) {
			if (nA[begin + matched] == nA[matched]) {
				matched++;
				p[begin + matched - 1] = matched;
			} else {
				if (matched == 0) {
					begin++;
				} else {
					begin += matched - p[matched - 1];
					matched = p[matched - 1];
				}
			}
		}
		
		begin = 0;
		matched = 0;
		boolean isPossible = false;
		
		while (begin < 2 * n - n) {
			if (matched < n && dB[begin + matched] == nA[matched]) {
				matched++;
				
				if (matched == n) {
					isPossible = true;
					break;
				}
			} else {
				if (matched == 0) {
					begin++;
				} else {
					begin += matched - p[matched - 1];
					matched = p[matched - 1];
				}
			}
		}
		
		if (isPossible) System.out.println("possible");
		else System.out.println("impossible");
	}
}