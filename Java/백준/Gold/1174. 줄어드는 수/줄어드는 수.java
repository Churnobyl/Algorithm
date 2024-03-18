import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		System.out.println(find(N));
	}
	
	private static long find(int N) {
		if (N <= 10) return N - 1;
		
		Queue<Long> queue = new LinkedList<>();
		
		for (int i = 0; i < 10; i++) {
			queue.add((long) i);
		}
		
		int count = 10;
		long num = 0;
		
		while (!queue.isEmpty()) {
			num = queue.poll();
			long lastDigit = num % 10;
			
			for (int i = 0; i < lastDigit; i++) {
				long newNum = num * 10 + i;
				queue.add(newNum);
				count++;
				
				if (count == N) return newNum;
			}
		}
		
		return -1;
	}
}