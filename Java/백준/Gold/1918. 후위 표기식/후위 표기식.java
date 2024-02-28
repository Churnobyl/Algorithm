import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String text = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < text.length(); i++) {
			char d = text.charAt(i);
			
			if (d == '*' || d == '/') {
				while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
					bw.append(stack.pop());
				}
				
				stack.push(d);
			} else if (d == '+' || d == '-') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					bw.append(stack.pop());
				}
				
				stack.push(d);
			} else if (d == '(') {
				stack.push(d);
			} else if (d == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					bw.append(stack.pop());
				}
				
				if (!stack.isEmpty()) stack.pop();
			} else {
				bw.append(d);
			}
		}
		
		while (!stack.isEmpty())
			bw.append(stack.pop());
			
		bw.flush();
		bw.close();
	}
}