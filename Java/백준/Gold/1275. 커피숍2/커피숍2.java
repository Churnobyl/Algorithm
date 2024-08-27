import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, Q;
    static int h;
    static long[] segTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        h = (int) Math.ceil(Math.log(N) / Math.log(2));
        segTree = new long[(1 << (h + 1)) + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            segTree[(1 << h) + i] = Long.parseLong(st.nextToken());
        }

        init();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (y < x) {
                int cache = x;
                x = y;
                y = cache;
            }

            System.out.println(query(1, 1, (1 << h), x, y));

            int idx = (1 << h) + (a - 1);
            long diff = b - segTree[idx];
            update(idx, diff);
        }
    }

    private static void init() {
        for (int i = (1 << h) - 1; i >= 1; i--) {
            segTree[i] = segTree[i * 2] + segTree[i * 2 + 1];
        }
    }

    private static long query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;

        if (l <= s && e <= r) {
            return segTree[node];
        }

        int mid = (s + e) / 2;
        long lsum = query(node * 2, s, mid, l, r);
        long rsum = query(node * 2 + 1, mid + 1, e, l, r);

        return lsum + rsum;
    }

    private static void update(int node, long diff) {
        while (node >= 1) {
            segTree[node] += diff;
            node /= 2;
        }
    }
}
