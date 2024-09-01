import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, h;
    static int[] maxSegTree;
    static int[] minSegTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int len = 1 << (h + 1);
        maxSegTree = new int[len];
        minSegTree = new int[len];

        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(br.readLine());
            maxSegTree[(1 << h) + i] = data;
            minSegTree[(1 << h) + i] = data;
        }

        for (int i = (1 << h) - 1; i > 0; i--) {
            maxSegTree[i] = Math.max(maxSegTree[i * 2], maxSegTree[i * 2 + 1]);
            minSegTree[i] = Math.min(minSegTree[i * 2], minSegTree[i * 2 + 1]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] result = query(1, 1, (1 << h), a, b);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }

        System.out.println(sb);
    }

    private static int[] query(int node, int s, int e, int l, int r) {
        if (r < s || e < l) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};

        if (l <= s && e <= r) {
            return new int[] {minSegTree[node], maxSegTree[node]};
        }

        int mid = (s + e) / 2;
        int[] lResult = query(node * 2, s, mid, l, r);
        int[] rResult = query(node * 2 + 1, mid + 1, e, l, r);

        return new int[] {Math.min(lResult[0], rResult[0]), Math.max(lResult[1], rResult[1])};
    }
}
