import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] stars;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		stars = new char[N][N];
		
		recursion(0, 0, N);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (stars[i][j] == '\0') sb.append(" ");
				else sb.append('*');
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void recursion(int r, int c, int n) {
		if (n == 1) return;
		
		for (int i = r; i < r + n; i += n / 3) {
			for (int j = c; j < c + n; j += n / 3) {
				if (!(i == r + (n / 3) && j == c + (n / 3))) {
					if (n == 3)
						stars[i][j] = '*';
					else
						recursion(i, j, n / 3);
				}
				
			}
		}
	}
}
