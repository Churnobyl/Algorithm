import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<long[]> stack = new Stack<>();
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        StringBuilder sb = new StringBuilder();

        while (!(line = br.readLine()).equals("0")) {
            answer = 0;
            stack.clear();
            StringTokenizer st = new StringTokenizer(line);

            int N = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                stacking(Long.parseLong(st.nextToken()));
            }

            popAllStack();
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static void popAllStack() {
        int cnt = 0;

        while (!stack.isEmpty()) {
            long[] top = stack.pop();
            answer = Math.max(answer, top[0] * (top[1] + cnt));
            cnt += (int) top[1];
        }
    }

    private static void stacking(long num) {
        if (num == 0) {
            popAllStack();
            return;
        }

        if (stack.isEmpty()) {
            stack.add(new long[] {num, 1});
            return;
        }

        if (stack.peek()[0] < num) {
            stack.add(new long[] {num, 1});
        } else if (stack.peek()[0] == num) {
            long[] top = stack.peek();
            top[1]++;
        } else {
            int cnt = 0;

            while (!stack.isEmpty() && stack.peek()[0] > num) {
                long[] top = stack.pop();
                answer = Math.max(answer, top[0] * (top[1] + cnt));
                cnt += (int) top[1];
            }

            if (stack.isEmpty()) {
                stack.add(new long[] {num, cnt + 1});
            } else if (stack.peek()[0] == num) {
                long[] top = stack.peek();
                top[1] += (cnt + 1);
            } else if (stack.peek()[0] < num) {
                stack.add(new long[] {num, cnt + 1});
            }
        }
    }
}
