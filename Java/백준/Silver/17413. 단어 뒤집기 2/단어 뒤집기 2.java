import java.io.*;
import java.util.*;

public class Main {
    static Stack<Character> stack = new Stack<>();
    static boolean isArrowOpen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case '<':
                    consumeStack(sb);
                    sb.append("<");
                    isArrowOpen = true;
                    break;
                case '>':
                    sb.append(">");
                    isArrowOpen = false;
                    break;
                case ' ':
                    if (isArrowOpen) {
                        sb.append(' ');
                        continue;
                    }

                    consumeStack(sb);

                    sb.append(' ');
                    break;
                default:
                    if (isArrowOpen) {
                        sb.append(c);
                        continue;
                    }

                    stack.push(c);
                    break;
            }

        }

        consumeStack(sb);
        System.out.println(sb);
    }

    public static void consumeStack(StringBuilder sb) {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
