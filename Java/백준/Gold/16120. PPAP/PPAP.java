import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String line = sc.next();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == 'A') {
                stack.push(-1);
                continue;
            }

            if (!stack.isEmpty() && stack.peek() > 0) {
                stack.push(stack.pop() + 1);
            } else if (!stack.isEmpty() && stack.peek() == -1) {
                stack.pop();
                if (!stack.isEmpty() && stack.peek() > 1) {
                    Integer pop = stack.pop();
                    stack.push(pop - 1);
                } else {
                    stack.push(-1);
                    stack.push(1);
                }
            } else if (stack.isEmpty()) {
                stack.push(1);
            }
        }

        if (stack.size() == 1 && stack.peek() == 1) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}