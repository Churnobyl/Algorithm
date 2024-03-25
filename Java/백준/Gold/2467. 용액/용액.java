import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, lowDiff = Integer.MAX_VALUE;
	static int[] candidates;
	static int[] solutions;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		candidates = new int[2];
		solutions = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}

		int s = 0;
		int e = solutions.length - 1;

		while (s < e) {
			int diff = solutions[s] + solutions[e];

			if (Math.abs(diff) < lowDiff) {
				lowDiff = Math.abs(diff);
				candidates[0] = solutions[s];
				candidates[1] = solutions[e];
			}

			if (diff > 0) {
				e--;
			} else if (diff < 0) {
				s++;
			} else {
				break;
			}
		}

		System.out.println(candidates[0] + " " + candidates[1]);
	}
}
