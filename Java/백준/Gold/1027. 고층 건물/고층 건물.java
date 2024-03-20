import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, maxValue;
	static int[] buildings;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		buildings = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			int cache = 0;

			// 왼쪽
			double maxSlope = 0;
			boolean sameSlope = false;
			for (int j = i - 1; j >= 0; j--) {
				double slope = (buildings[i] - buildings[j]) / (double) (i - j);
				if (j == i - 1) {
					cache++;
					maxSlope = slope;
					sameSlope = true;
					continue;
				}

				if (maxSlope > slope) {
					cache++;
					maxSlope = slope;
					sameSlope = false;
				}

			}

			sameSlope = false;
			// 오른쪽
			for (int j = i + 1; j < N; j++) {
				double slope = (buildings[i] - buildings[j]) / (double) (i - j);

				if (j == i + 1) {
					cache++;
					maxSlope = slope;
					sameSlope = true;
					continue;
				}

				if (maxSlope < slope) {
					cache++;
					maxSlope = slope;
					sameSlope = false;
				}

			}

			maxValue = Math.max(cache, maxValue);
		}

		System.out.println(maxValue);
	}
}