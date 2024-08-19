import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, Q;
	static int[] arr;
	static int[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] a =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		N = a[0];
		Q = a[1];
		
		arr = new int[N];
		check = new int[N + 1];
		
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	
		
		for (int i = 0; i < Q; i++) {
			int[] b =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int s = b[0] - 1;
			int e = b[1] - 1;
			
			check[s] ^= 1;
			
			if (e + 1 < N) check[e + 1] ^= 1;
		}
		
		int ans = 0;
		int xor = 0;
		
		for (int i = 0; i < N; i++) {
			xor ^= check[i];
			
			if (xor == 1) {
				ans ^= arr[i];
			}
		}
		
		System.out.println(ans);
	}
}
