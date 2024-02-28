import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int N;
	static long M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}

		int[][] a = arrSquare(arr, M);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {				
				bw.append(String.format("%d ", a[i][j]));
			}
			bw.append("\n");
		}
		
		bw.flush();
		bw.close();
	}

	private static int[][] arrSquare(int[][] t, long n) {
		if (n == 1) return t;
		
		int[][] result = arrSquare(t, n / 2);
		int[][] a = sq(result, result);
		
		if (n % 2 == 1)
			return sq(a, arr);
		else
			return a;
	}

	private static int[][] sq(int[][] arr1, int[][] arr2) {
		int[][] result = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {					
					result[i][j] += arr1[i][j2] * arr2[j2][j];
				}
				result[i][j] %= 1000;
			}
		}
		
		return result;
	}
}