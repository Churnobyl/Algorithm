import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main {
	static int N, total;
	static int[][] wires;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		wires = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			wires[i] = new int[] {A, B};
		}
		
		int max = 0;
		int[] lis = new int[N];
		
		Arrays.sort(wires, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		Arrays.fill(lis, 1);
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (wires[j][1] < wires[i][1]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
					if (max < lis[i]) {
						max = lis[i];
					}
				}
			}
		}
		
		System.out.println(N - max);
	}
}