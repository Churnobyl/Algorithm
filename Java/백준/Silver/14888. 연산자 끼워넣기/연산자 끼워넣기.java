import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE, now;
	static int[] arr, operators;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		operators = new int[4];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		
		now += arr[0];
		recursion(1);
		
		System.out.println(maxValue);
		System.out.println(minValue);
	}
	
	private static void recursion(int depth) {
		if (depth == N) {
			maxValue = Math.max(maxValue, now);
			minValue = Math.min(minValue, now);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (operators[i] != 0) {
				switch (i) {
				case 0:
					now += arr[depth];
					operators[0]--;
					recursion(depth + 1);
					now -= arr[depth];
					operators[0]++;
					break;
				case 1:
					now -= arr[depth];
					operators[1]--;
					recursion(depth + 1);
					now += arr[depth];
					operators[1]++;
					break;
				case 2:
					now *= arr[depth];
					operators[2]--;
					recursion(depth + 1);
					now /= arr[depth];
					operators[2]++;
					break;
				case 3:
					int origin = now;
					now /= arr[depth];
					operators[3]--;
					recursion(depth + 1);
					now = origin;
					operators[3]++;
					break;
				}
			}
		}
	}
}
