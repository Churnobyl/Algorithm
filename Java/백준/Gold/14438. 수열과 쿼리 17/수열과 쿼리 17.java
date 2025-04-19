import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] segTree;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        h = (int)Math.ceil(Math.log(N) / Math.log(2));
        segTree = new int[(1 << (h + 1))];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            segTree[(1 << h) + i] = Integer.parseInt(st.nextToken());
        }

        initSegTree();

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int com = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (com) {
                case 1:
                    setValue(a, b);
                    break;
                case 2:
                    sb.append(query(1, 0, (1 << h) - 1, a - 1, b - 1)).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    private static int query(int node, int l, int r, int s, int e) {
        if (r < s || l > e) return Integer.MAX_VALUE;
        if (s <= l && r <= e) return segTree[node];

        int mid = (l + r) / 2;

        int leftQuery = query(node * 2, l, mid, s, e);
        int rightQuery = query(node * 2 + 1, mid + 1, r, s, e);

        return Math.min(leftQuery, rightQuery);
    }

    private static void setValue(int i, int v) {
        int idx = (1 << h) + i - 1;

        segTree[idx] = v;

        while (idx >= 1) {
            idx /= 2;
            findAndSetMinimumValue(idx);
        }
    }

    private static void initSegTree() {
        for (int i = (1 << h) - 1; i > 0; i--) {
            findAndSetMinimumValue(i);
        }
    }

    private static void findAndSetMinimumValue(int i) {
        if (segTree[i * 2] == 0) segTree[i] = segTree[i * 2 + 1];
        else if (segTree[i * 2 + 1] == 0) segTree[i] = segTree[i * 2];
        else segTree[i] = Math.min(segTree[i * 2], segTree[i * 2 + 1]);
    }
}
