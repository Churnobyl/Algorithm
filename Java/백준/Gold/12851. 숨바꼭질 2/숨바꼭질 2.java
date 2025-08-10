import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100_000;
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        int[] dist = new int[MAX + 1];
        int[] cnt  = new int[MAX + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[N] = 0;
        cnt[N]  = 1;
        q.add(N);

        int minTime = -1;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (minTime != -1 && dist[x] > minTime) break;

            int[] moves = {x - 1, x + 1, x * 2};
            for (int nx : moves) {
                if (nx < 0 || nx > MAX) continue;

                if (dist[nx] == -1) {
                    dist[nx] = dist[x] + 1;
                    cnt[nx]  = cnt[x];
                    q.add(nx);
                }

                else if (dist[nx] == dist[x] + 1) {
                    cnt[nx] += cnt[x];
                }

                if (nx == K) {
                    if (minTime == -1) minTime = dist[nx];
                }
            }
        }

        System.out.println(dist[K]);
        System.out.println(cnt[K]);
    }
}
