import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] data;
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				data[i][j] = line.charAt(j) - '0';
			}
		}
		
		System.out.println(recursion(0, 0, N));
	}
	
	private static String recursion(int r, int c, int edge) {
		int check = data[r][c];
		
		String result = "(";
		
		for (int i = r; i < r + edge; i++) {
			for (int j = c; j < c + edge; j++) {
				if (check != data[i][j]) {
					for (int j2 = r; j2 < r + edge; j2 += edge / 2) {
						for (int k = c; k < c + edge; k += edge / 2) {
							result += recursion(j2, k, edge / 2);
						}
					}
					
					return result + ")";
				}
			}
		}
		
		return String.valueOf(check);
	}
}