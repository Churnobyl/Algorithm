import java.io.*;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int N;
    static String exp;
    static int[] operands;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        exp = br.readLine();
        operands = new int[N];

        for (int i = 0; i < N; i++) {
            operands[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char next = exp.charAt(i);

            if ('A' <= next && next <= 'Z') {
                stack.add((double) operands[next - 'A']);
            } else {
                double b = stack.pop();
                double a = stack.pop();
                double result = 0;

                switch (next) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                }

                stack.add(result);
            }

        }
        System.out.printf("%.2f", stack.pop());
    }
}