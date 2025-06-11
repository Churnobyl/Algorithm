import java.io.*;
import java.util.*;

public class Main {
    static int n, d, ans;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a > b) {
                int cache = a;
                a = b;
                b = cache;
            }

            arr[i] = new int[]{a, b};
        }

        d = Integer.parseInt(br.readLine());

        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            int[] state = arr[i];

            if (state[1] - state[0] <= d) {
                while (!pq.isEmpty() && state[1] - pq.peek()[0] > d) {
                    pq.poll();
                }

                pq.add(state);
            }

            ans = Math.max(ans, pq.size());
        }

        System.out.println(ans);
    }
}
