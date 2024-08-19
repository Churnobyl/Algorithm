import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, M;
	static int[] map;
	static int[] accum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = line[0];
		M = line[1];
		
		map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		accum = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			int[] d = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int a = d[0] - 1;
			int b = d[1] - 1;
			int k = d[2];
			
			accum[a] += k;
			
			if (b + 1 <= N)
				accum[b + 1] -= k;
		}
		
		int curr = 0;
		
		for (int i = 0; i < N; i++) {
			curr += accum[i];
			
			sb.append(map[i] + curr).append(" ");
		}
		
		System.out.println(sb);
	}
}
