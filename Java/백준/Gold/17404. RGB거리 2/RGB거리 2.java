import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] rgb;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		rgb = new int[N][3];
		dp = new int[N][3][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
				if (i == 0) {
					for (int j2 = 0; j2 < 3; j2++) {
						if (j2 != j) {
							dp[i][j][j2] = rgb[i][j];
						} else {
							dp[i][j][j2] = Integer.MAX_VALUE;
						}
					}
				}
			}
		}

		for (int j = 1; j < N; j++) {
			for (int i = 0; i < 3; i++) {
				for (int k = 0; k < 3; k++) {
					dp[j][i][k] += rgb[j][i] + Math.min(dp[j - 1][(2 + i) % 3][k], dp[j - 1][(i + 1) % 3][k]);
				}
			}
		}

		int minValue = Integer.MAX_VALUE;

		for (int j = 0; j < 3; j++) {
			minValue = Math.min(dp[N - 1][j][j], minValue);
		}
		System.out.println(minValue);
	}
}
