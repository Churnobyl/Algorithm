import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int m, n;
	static int[][] students, degree, result;
	static int[][] visited;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		students = new int[2][];
		degree = new int[2][];
		result = new int[2][];
		visited = new int[2][];
		students[0] = new int[m + 1];
		students[1] = new int[n + 1];
		visited[0] = new int[m + 1];
		visited[1] = new int[n + 1];
		degree[0] = new int[m + 1];
		degree[1] = new int[n + 1];
		result[0] = new int[m + 1];
		result[1] = new int[n + 1];

		Arrays.fill(result[0], -1);
		Arrays.fill(result[1], -1);

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < m + 1; i++) {
			students[0][i] = Integer.parseInt(st.nextToken());
			degree[1][students[0][i]]++;
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < n + 1; i++) {
			students[1][i] = Integer.parseInt(st.nextToken());
			degree[0][students[1][i]]++;
		}

		// 겨냥 당하고 있지 않은 애들 투입
		for (int i = 1; i < m + 1; i++) {
			if (degree[0][i] == 0) {
				result[0][i] = 1;
				queue.add(new int[] { 0, i });
			}
		}

		for (int i = 1; i < n + 1; i++) {
			if (degree[1][i] == 0) {
				result[1][i] = 1;
				queue.add(new int[] { 1, i });
			}
		}

		while (!queue.isEmpty()) {
			int[] next = queue.poll();
			dfs(next[0], next[1]);
		}
		
		for (int i = 1; i < m + 1; i++) {
			if (visited[0][i] != 2) {
				result[0][i] = 1;
				dfs(0, i);
			}
		}
		
		for (int i = 1; i < n + 1; i++) {
			if (visited[1][i] != 2) {
				result[1][i] = 1;
				dfs(1, i);
			}
		}
		
		for (int i = 1; i < m + 1; i++) {
			System.out.print(result[0][i]);
		}
		System.out.println();
		for (int i = 1; i < n + 1; i++) {
			System.out.print(result[1][i]);
		}
	}

	private static void dfs(int row, int idx) {
		visited[row][idx] = 1;

		if (result[row][idx] == 1) { // 활을 든 경우
			if (visited[(row + 1) % 2][students[row][idx]] == 1) {
				visited[row][idx] = 2;
				return;
			} else if (visited[(row + 1) % 2][students[row][idx]] == 0) {
				result[(row + 1) % 2][students[row][idx]] = 0;
				dfs((row + 1) % 2, students[row][idx]);
			}
		} else if (result[row][idx] == 0) { // 방패를 든 경우
			if (visited[(row + 1) % 2][students[row][idx]] == 1) {
				visited[row][idx] = 2;;
				return;
			} else if (visited[(row + 1) % 2][students[row][idx]] == 0) {
				degree[(row + 1) % 2][students[row][idx]]--;
				if (degree[(row + 1) % 2][students[row][idx]] == 0) {
					result[(row + 1) % 2][students[row][idx]] = 1;
					dfs((row + 1) % 2, students[row][idx]);
				}
			}
		}

		visited[row][idx] = 2;
	}
}
