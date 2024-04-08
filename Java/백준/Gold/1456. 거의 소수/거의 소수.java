import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static long A, B;
	static boolean[] primeNumbers;
	static Set<Long> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		int length = (int)Math.sqrt(B) + 1;
		
		primeNumbers = new boolean[length + 1];
		
		Arrays.fill(primeNumbers, true);
		
		primeNumbers[0] = primeNumbers[1] = false;
		
		for (int i = 2; i < (int)Math.sqrt(length) + 1; i++) {
			for (int j = i * i; j < length + 1; j += i) {
				primeNumbers[j] = false;
			}
		}
		
		int count = 0;
		
		for (int i = 2; i < length + 1; i++) {
			if (primeNumbers[i]) {
				long cache = (long)i;
				
				while (cache <= B / i && cache * (long)i <= B) {
					cache *= (long)i;
					if (cache < A) continue;
					if (!set.contains(cache)) {
						count++;
						set.add(cache);
					}
				}
			}
		}
		
		System.out.println(count);
	}
}
