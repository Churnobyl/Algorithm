import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long[] arr, ans;
	static long minValue = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new long[N];
		ans = new long[3];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N - 2; i++) {
			int l = i + 1;
			int r = N - 1;
			
			while (l < r) {
				long sum = arr[i] + arr[l] + arr[r];
				
				if (Math.abs(sum) < Math.abs(minValue)) {
					minValue = sum;
					ans = new long[] {arr[i], arr[l], arr[r]};
				}
				
				if (sum < 0) l += 1;
				else if (sum > 0) r -= 1;
				else break;
			}
		}
		
		
		for (int i = 0; i < 3; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}