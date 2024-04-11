import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		System.out.println(find(N));
	}

	private static long find(int N) {
		if (N <= 10) return N;
		
		Queue<Long> queue = new LinkedList<>();
		
		for (int i = 1; i < 10; i++) {
			queue.add((long)i);
		}
		
		int count = 9;
		
		while (!queue.isEmpty()) {
			long next = queue.poll();
			long lastDigit = next % 10;
			
			for (int i = 0; i < lastDigit; i++) {
				long nextNum = next * 10 + i;
				count++;
				
				queue.add(nextNum);
				
				if (count == N) return nextNum;
			}
		}
		
		return -1;
	}

	
}
