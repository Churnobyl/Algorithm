import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, L, head, data;
	static Deque<int[]> deque = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		head = 0;

		for (int i = 0; i < N; i++) {
			data = Integer.parseInt(st.nextToken());
			
			while (!deque.isEmpty() && deque.peekLast()[1] > data) { // 새로운 값이 더 크면 팝
				deque.pollLast();
			}
			
			deque.add(new int[] {i, data});
			
			if (i - deque.peekFirst()[0] == L) {
				deque.pollFirst();
			}
			sb.append(deque.peekFirst()[1] + " ");
		}

		bw.append(sb);
		bw.flush();
		bw.close();
	}
}