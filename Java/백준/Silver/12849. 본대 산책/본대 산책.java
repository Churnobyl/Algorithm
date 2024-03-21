import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int D = Integer.parseInt(br.readLine());

		long[][] arr = new long[8][8];

		arr[0][1] = arr[0][2] = arr[2][0] = arr[1][2] = arr[1][3] = arr[2][3] = arr[2][4] = arr[3][5] = arr[3][4] = arr[4][5] = arr[4][6] = arr[5][7] = arr[6][7] = 1L;

		for (int i = 0; i < 8; i++) {
			for (int j = i; j < 8; j++) {
				arr[j][i] = arr[i][j];
			}
		}

		System.out.println(divide(arr, D)[0][0]);
	}

	private static long[][] divide(long[][] arr, int N) {
		if (N == 1)
			return arr;

		long[][] newArr = divide(arr, N / 2);

		if (N % 2 == 0) {
			return square(newArr, newArr);
		} else {
			return square(square(newArr, newArr), arr);
		}
	}

	private static long[][] square(long[][] arr, long[][] arr2) {
		long[][] newArr = new long[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					newArr[i][j] = (newArr[i][j] + (arr[i][k] * arr2[k][j]) % 1_000_000_007L) % 1_000_000_007L;
				}
			}
		}
		
		return newArr;
	}
}