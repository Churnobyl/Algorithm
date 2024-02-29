import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, total;
	static int[] visited;
	static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dx = {0, 0, 1, -1, 1, -1, -1, 1};	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new int[N];
		Arrays.fill(visited, -1);
		
		btk(0);
		
		System.out.println(total);
	}
	
	private static void btk(int y) {
		for (int i = 0; i < N; i++) {
			if (visited[i] == -1 && isPossible(i, y)) {
				if (y == N - 1) total++;
				else {
					visited[i] = y;
					btk(y + 1);
					visited[i] = -1;
				}
			}
		}
	}
	
	private static boolean isPossible(int x, int y) {
		for (int i = 0; i < N; i++) {
			if (visited[i] != -1) {
				if (Math.abs(i - x) == Math.abs(visited[i] - y)) return false;
			}
		}
		return true;
	}
}