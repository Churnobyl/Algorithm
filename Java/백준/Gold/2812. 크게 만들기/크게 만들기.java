import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static String result;
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		String line = br.readLine();
		
		for (int i = 0; i < N; i++) {
			char data = line.charAt(i);
			
			if (stack.isEmpty()) {
				stack.push(data);
				continue;
			}
			
			while (!stack.isEmpty() && stack.peek() < data && N - i > N - K - stack.size()) {
				stack.pop();
			}
			
			stack.push(data);
		}
		
		while (stack.size() != N - K) {
			stack.pop();
		}
		
		for (Object s : stack.toArray()) {
			System.out.print(s);
		}
	}
}
