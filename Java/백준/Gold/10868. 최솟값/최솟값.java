import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] segTree;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int size = (1 << (h + 1));
        segTree = new int[size];

        for (int i = 0; i < N; i++) {
            segTree[(1 << h) + i] = Integer.parseInt(br.readLine());
        }

        for (int i = (1 << h) - 1; i >= 1; i--) {
            segTree[i] = Math.min(segTree[i * 2], segTree[i * 2 + 1]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(minQuery(1, 1, (1 << h), a, b)).append("\n");
        }

        System.out.println(sb
        );
    }

    private static int minQuery(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return Integer.MAX_VALUE;

        if ((s == e) || (l <= s && e <= r)) {
            return segTree[node];
        }

        int mid = (s + e) / 2;
        int lMin = minQuery(node * 2, s, mid, l , r);
        int rMin = minQuery(node * 2 + 1, mid + 1, e, l , r);

        return Math.min(lMin, rMin);
    }
}