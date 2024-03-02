import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, swapCount;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		swapCount = Integer.parseInt(br.readLine());

		for (int i = 0; i < N && swapCount > 0; i++) {
			int findMax = i;
			
			for (int j = i; j <= i + swapCount && j < N; j++) {
				if (arr[j] > arr[findMax]) {
					findMax = j;
				}
			}
			
			for (int j = findMax; j > i; j--) {
				swap(j, j - 1);
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void swap(int x, int y) {
		int cache = arr[x];
		arr[x] = arr[y];
		arr[y] = cache;
		swapCount--;
	}
}