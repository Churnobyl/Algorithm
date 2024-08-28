import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] segTree;
    static int h;
    static int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int size = (1 << (h + 1));
        segTree = new long[size];

        for (int i = 0; i < N; i++) {
            segTree[(1 << h) + i] = Integer.parseInt(br.readLine());
        }

        for (int i = N; i < (1 << h); i++) {
            segTree[(1 << h) + i] = 1;
        }

        for (int i = (1 << h) - 1; i >= 1; i--) {
            segTree[i] = (segTree[i * 2] * segTree[i * 2 + 1]) % MOD;
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int idx = (1 << h) + b - 1;
                update(idx, c);
            } else if (a == 2) {
                sb.append(query(1, 1, (1 << h), b, c)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static long query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 1;

        if ((s == e) || (l <= s && e <= r)) {
            return segTree[node];
        }

        int mid = (s + e) / 2;
        long lMulti = query(node * 2, s, mid, l , r);
        long rMulti = query(node * 2 + 1, mid + 1, e, l , r);

        return (lMulti * rMulti) % MOD;
    }

    private static void update(int node, long newValue) {
        boolean wasZero = segTree[node] == 0;
        segTree[node] = newValue;

        node /= 2;

        while (node > 0) {
            long lMulti = segTree[node * 2];
            long rMulti = segTree[node * 2 + 1];

            segTree[node] = (lMulti * rMulti) % MOD;

            if (wasZero && (lMulti != 0 || rMulti != 0)) {
                recalculate(node);
            }

            node /= 2;
        }

    }

    private static void recalculate(int node) {
        while (node > 0) {
            segTree[node] = (segTree[node * 2] * segTree[node * 2 + 1]) % MOD;
            node /= 2;
        }
    }
}