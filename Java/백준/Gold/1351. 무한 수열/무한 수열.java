import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static long N, P, Q;
	static Map<Long, Long> data = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		data.put(0L, 1L);
		
		System.out.println(recursion(N));
	}
	
	private static long recursion(long n) {
		if (data.containsKey(n)) return data.get(n);
		
		long a = recursion(n / P);
		
		if (!data.containsKey(n/ P)) data.put(n / P, a);
		
		long b = recursion(n / Q);
		
		if (!data.containsKey(n/ Q)) data.put(n / Q, b);
		
		return a + b;
	}
}