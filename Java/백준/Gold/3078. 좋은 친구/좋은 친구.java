import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, now;
	static long total;
	static long[] lengths = new long[21];
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String student = br.readLine();
			int len = student.length();
			
			if (now > K) {
				lengths[queue.poll()]--;
				now--;
			}
			
			total += lengths[len];
			queue.add(len);
			lengths[len]++;
			now++;
		}
		
		System.out.println(total);
	}
}