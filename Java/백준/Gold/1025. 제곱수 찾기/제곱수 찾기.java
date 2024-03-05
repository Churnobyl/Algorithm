import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static long maxValue = -1;
	static String[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		data = new String[N];

		for (int i = 0; i < N; i++) {
			data[i] = br.readLine();
		}

		findMax();
		System.out.println(maxValue);
	}

	private static void findMax() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				iterating(i, j);
			}
		}
	}

	private static void iterating(int y, int x) {
		for (int i = -N; i < N; i++) {
			for (int j = -M; j < M; j++) {
				if (i == 0 && j == 0)
					continue;

				long num = 0;
				int ny = y, nx = x;
				while (ny >= 0 && ny < N && nx >= 0 && nx < M) {
					num = num * 10 + (data[ny].charAt(nx) - '0');

					if (isPerfectSquare(num)) {
                        maxValue = Math.max(num, maxValue);
                    }
					ny += i;
					nx += j;
				}
			}
		}
	}
	
	private static boolean isPerfectSquare(long num) {
        if (num < 0) return false;
        long sqrt = (long) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}