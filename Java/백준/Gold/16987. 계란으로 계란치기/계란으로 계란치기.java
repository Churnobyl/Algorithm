import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, count, maxCount;
	static int[][] eggs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		eggs = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}
		
		recursion(0);
		System.out.println(maxCount);
	}
	
	private static void recursion(int idx) {
		if (idx == N) {
			maxCount = Math.max(maxCount, count);
			return;
		}

		if (eggs[idx][0] <= 0) {
			recursion(idx + 1);
		} else {
			boolean doBrake = false;
			
			for (int i = 0; i < N; i++) {
				if (i == idx || eggs[i][0] <= 0) continue;
				
				doBrake = true;
				
				int cache = 0;
				
				eggs[idx][0] -= eggs[i][1];
				
				if (eggs[idx][0] <= 0) cache++;
				
				eggs[i][0] -= eggs[idx][1];
				
				if (eggs[i][0] <= 0) cache++;
				
				count += cache;
								
				recursion(idx + 1);
				
				count -= cache;
				eggs[idx][0] += eggs[i][1];
				eggs[i][0] += eggs[idx][1];
			}
			
			if (!doBrake) {
				recursion(idx + 1);
			}
		}
	}
}