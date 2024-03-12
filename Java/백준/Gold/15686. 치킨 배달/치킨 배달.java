import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, minValue = Integer.MAX_VALUE;
	static List<int[]> houses, chicken;
	static int[][] data;
	static int[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		houses = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				String data = st.nextToken();
				
				if (data.equals("1")) houses.add(new int[] {i, j});
				if (data.equals("2")) chicken.add(new int[] {i, j});
			}
		}
		
		data = new int[chicken.size()][houses.size()];
		check = new int[houses.size()];
		
		for (int i = 0; i < chicken.size(); i++) {
			int[] c = chicken.get(i);
			for (int j = 0; j < houses.size(); j++) {
				int[] h = houses.get(j);
				data[i][j] = Math.abs(c[0] - h[0]) + Math.abs(c[1] - h[1]);
			}
		}

		recursion(0, 0, 0);
		
		System.out.println(minValue);
	}
	
	private static void recursion(int total, int idx, int count) {
		
		if (count == M) {
			if (minValue > total) {
				minValue = total;
			}
			return;
		}
		
		if (idx >= chicken.size()) return;
		
		int cache = total;
		int[] cache2 = new int[houses.size()];
		
		for (int i = 0; i < houses.size(); i++) {
			if (check[i] == 0) {
				check[i] = data[idx][i];
				cache2[i] = -1;
				total += check[i];
			} else if (check[i] > data[idx][i]) {
				cache2[i] = check[i];
				total -= check[i] - data[idx][i];
				check[i] = data[idx][i];
			}
		}
		
		recursion(total, idx + 1, count + 1);
		total = cache;
		for (int i = 0; i < cache2.length; i++) {
			if (cache2[i] != 0) {
				if (cache2[i] == -1) {
					check[i] = 0;
				} else {
					check[i] = cache2[i];					
				}
			}
		}
		recursion(total, idx + 1, count);
	}
}
