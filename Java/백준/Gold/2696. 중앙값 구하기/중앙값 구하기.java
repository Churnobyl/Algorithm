import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o2, o1);
        }
    });
    static PriorityQueue<Integer> minQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            maxQueue.clear();
            minQueue.clear();

            int M = Integer.parseInt(br.readLine());

            StringTokenizer st = null;
            sb.append(M / 2 + 1).append("\n");

            for (int j = 0; j < M; j++) {
                if (j % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                
                int n = Integer.parseInt(st.nextToken());

                if (maxQueue.isEmpty()) {
                    maxQueue.add(n);
                } else if (maxQueue.size() > minQueue.size()) {
                    minQueue.add(n);
                } else {
                    maxQueue.add(n);
                }

                if (!minQueue.isEmpty() && maxQueue.peek() > minQueue.peek()) {
                    int cache = maxQueue.poll();
                    maxQueue.add(minQueue.poll());
                    minQueue.add(cache);
                }

                if (j % 2 == 0) {
                    sb.append(maxQueue.peek()).append(" ");
                }

                if (j % 20 == 19) {
                    sb.append("\n");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
