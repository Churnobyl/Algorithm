import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, K, max;
	static int[] words;
	static int bit = 532741, allBit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new int[N];

		if (K < 5) {
			System.out.println(0);
			return;
		}
		
		K -= 5;
		
		int count = 0;

		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			
			for (int j = 0; j < data.length(); j++) {
				if ((allBit & (1 << (data.charAt(j) - 'a'))) == 0 && (bit & (1 << (data.charAt(j) - 'a'))) == 0) {
					count++;
					allBit |= (1 << (data.charAt(j) - 'a'));										
				}
				words[i] |= (1 << (data.charAt(j) - 'a'));
			}
		}
		
		if (count < K) {
			System.out.println(N);
			return;
		}

		recursion(0);
		System.out.println(max);
	}

	private static void recursion(int idx) {
		if (K == 0) {
			int cache = 0;
			for (int word : words) {
				if ((bit | word) == bit) {
					cache++;
				}
			}

			max = Math.max(max, cache);
			return;
		}

		if (idx > 26)
			return;

		if ((allBit & (1 << idx)) > 0 && (bit & (1 << idx)) == 0) {
			K--;
			bit |= (1 << idx);
			recursion(idx + 1);
			K++;
			bit &= ~(1 << idx);
		}
		
		recursion(idx + 1);
	}
}