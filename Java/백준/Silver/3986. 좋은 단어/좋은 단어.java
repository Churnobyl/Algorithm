import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            stack.clear();

            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);

                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }

            if (stack.isEmpty()) cnt++;
        }

        System.out.println(cnt);
    }
}
