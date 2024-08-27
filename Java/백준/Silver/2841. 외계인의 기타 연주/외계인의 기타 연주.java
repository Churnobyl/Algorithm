import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N, P, result;
    static Map<Integer, Stack<Integer>> stackMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int pret = Integer.parseInt(st.nextToken());

            if (!stackMap.containsKey(line)) {
                stackMap.computeIfAbsent(line, k -> new Stack<>()).add(pret);
                result++;
            } else {
                Stack<Integer> thatPrets = stackMap.get(line);

                while (!thatPrets.isEmpty() && thatPrets.peek() > pret) {
                    thatPrets.pop();
                    result++;
                }

                if (thatPrets.isEmpty() || thatPrets.peek() != pret) {
                    result++;
                    thatPrets.add(pret);
                }
            }
        }

        System.out.println(result);
    }
}
