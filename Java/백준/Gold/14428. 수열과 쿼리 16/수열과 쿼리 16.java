import java.io.*;
import java.util.*;

public class Main {
    static int N, h, len;
    static int[] segTree;
    static int[] minIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        h = (int) Math.ceil(Math.log(N) / Math.log(2));
        len = (1 << (h + 1));

        segTree = new int[len];
        Arrays.fill(segTree, Integer.MAX_VALUE);
        minIdx = new int[len];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            segTree[(1 << h) + i] = Integer.parseInt(st.nextToken());
            minIdx[(1 << h) + i] = i;
        }

        initSegTree();

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int com = Integer.parseInt(st.nextToken());

            switch (com) {
                case 1:
                    update(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    int result = query(1, 0, (1 << h) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
                    sb.append(result + 1).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    private static int query(int node, int l, int r, int i, int j) {
        if (r < i || l > j) return -1;
        if (i <= l && r <= j) return minIdx[node];

        int mid = (l + r) / 2;

        int left = query(node * 2, l, mid, i, j);
        int right = query(node * 2 + 1, mid + 1, r, i, j);

        if (left == -1) return right;
        if (right == -1) return left;

        int[] result = new int[2];

        if (segTree[(1 << h) + left] == segTree[(1 << h) + right]) {
            return Math.min(left, right);
        }

        return segTree[(1 << h) + left] < segTree[(1 << h) + right] ? left : right;
    }

    private static void update(int i, int v) {
        int idx = (1 << h) + i;
        segTree[idx] = v;

        idx /= 2;

        while (idx > 0) {
            _update(idx);
            idx /= 2;
        }
    }

    private static void initSegTree() {
        for (int i = (1 << h) - 1; i > 0; i--) {
            _update(i);
        }
    }

    private static void _update(int idx) {
        int left = idx * 2;
        int right = idx * 2 + 1;

        int lIdx = minIdx[left];
        int rIdx = minIdx[right];

        if (segTree[left] == segTree[right]) {
            minIdx[idx] = Math.min(lIdx, rIdx);
            segTree[idx] = segTree[left];
        } else if (segTree[left] < segTree[right]) {
            minIdx[idx] = lIdx;
            segTree[idx] = segTree[left];
        } else {
            minIdx[idx] = rIdx;
            segTree[idx] = segTree[right];
        }
    }
}
