import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static double[][] stars;
	static double[][] edges;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		stars = new double[n][2];
		edges = new double[n * (n - 1) / 2][3];
		p = new int[n];
		
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}

		int count = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i][0] = Double.parseDouble(st.nextToken());
			stars[i][1] = Double.parseDouble(st.nextToken());

			for (int j = 0; j < i; j++) {
				double length = Math
						.sqrt(Math.pow(stars[j][0] - stars[i][0], 2) + Math.pow(stars[j][1] - stars[i][1], 2));
				edges[count][0] = j;
				edges[count][1] = i;
				edges[count][2] = length;

				count++;
			}
		}
		
		Arrays.sort(edges, new Comparator<double[]>() {

			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o1[2], o2[2]);
			}
		});
		
		double total = 0;
		count = 0;
		
		for (int i = 0; i < n * (n - 1) / 2; i++) {
			double[] next = edges[i];
			
			if (union((int) next[0], (int) next[1])) {
				total += next[2];
				count++;
			}
			
			if (count == n - 1) break;
		}
		
		System.out.printf("%.2f", total);
	}

	private static int find(int x) {
		if (x == p[x]) return x;
		return p[x] = find(p[x]);
	}
	
	private static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x == y) return false;
		
		p[y] = x;
		return true;
	}
}