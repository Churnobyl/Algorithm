import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int answer = Integer.MIN_VALUE;
        int total = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());

            if (queue.size() == K) {
                total -= queue.pollFirst();
            }

            queue.add(next);
            total += next;
            if (queue.size() == K) answer = Math.max(total, answer);
        }

        System.out.println(answer);
    }
}
