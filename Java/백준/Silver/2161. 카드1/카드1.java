import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while (queue.size() > 1) {
            sb.append(queue.poll()).append(" ");
            queue.add(queue.poll());
        }

        sb.append(queue.poll());
        System.out.println(sb);
    }
}
