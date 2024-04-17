import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static Queue<Integer> minusPq = new PriorityQueue<>();
	static Queue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
	static int zeros, total, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num > 0)
				plusPq.add(num);
			else if (num < 0)
				minusPq.add(num);
			else
				zeros++;
		}

		int cache = 1001;

		while (!plusPq.isEmpty()) {
			int num = plusPq.poll();

			if (num == 1) {
				total++;
				continue;
			}

			if (cache == 1001) {
				cache = num;
			} else {
				total += cache * num;
				cache = 1001;
			}
		}

		if (cache != 1001)
			total += cache;

		cache = -1001;

		while (!minusPq.isEmpty()) {
			int num = minusPq.poll();

			if (cache == -1001) {
				cache = num;
			} else {
				total += cache * num;
				cache = -1001;
			}
		}

		if (cache != -1001) {
			if (zeros == 0) {
				total += cache;
			}			
		}
		
		System.out.println(total);
	}
}
