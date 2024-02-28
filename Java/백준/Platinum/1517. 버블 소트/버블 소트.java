import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static long total;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		N = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		divide(arr);
		System.out.println(total);
	}
	
	private static int[] divide(int[] arr) {
		if (arr.length < 2)
			return arr;

		int mid = arr.length / 2;
		int[] left = divide(Arrays.copyOfRange(arr, 0, mid));
		int[] right = divide(Arrays.copyOfRange(arr, mid, arr.length));
		
		return sort(left, right);
	}
	
	private static int[] sort(int[] left, int[] right) {
		int i = 0, j = 0, k = 0;
		
		int[] newArr = new int[left.length + right.length];
		
		while (i < left.length && j < right.length) {
			if (left[i] > right[j]) {
				newArr[k] = right[j];
				total += left.length + j - k;
				j++;
				
			} else {
				newArr[k] = left[i];
				i++;
			}
			k++;
		}
		
		if (i == left.length) {
			for (int l = j; l < right.length; l++) {
				newArr[k] = right[l];
				k++;
			}
		} else if (j == right.length) {
			for (int l = i; l < left.length; l++) {
				newArr[k] = left[l];
				k++;
			}
		}
		
		return newArr;
	}
}