import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int rod = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= rod) {
                stack.pop();
            }

            stack.add(rod);
        }

        System.out.println(stack.size());
    }

}
