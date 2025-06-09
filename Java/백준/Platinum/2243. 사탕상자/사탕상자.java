import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1_000_001;
    static int h;
    static int len;
    static int[] segTree;

    public static void main(String[] args) throws IOException {
        setSegTree();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int B = 0;

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());

            switch (A) {
                case 1:
                    B = Integer.parseInt(st.nextToken());
                    sb.append(takeOutCandy(1, B)).append("\n");
                    break;
                case 2:
                    B = Integer.parseInt(st.nextToken());
                    int C = Integer.parseInt(st.nextToken());
                    putCandy(B, C);
                    break;
            }

        }
        System.out.println(sb);
    }

    private static int takeOutCandy(int node, int B) {
        if (node >= (1 << h)) {
            putCandy(node - (1 << h), -1);
            return node - (1 << h);
        }

        if (segTree[node * 2] >= B) {
            return takeOutCandy(node * 2, B);
        } else {
            return takeOutCandy(node * 2 + 1, B - segTree[node * 2]);
        }
    }

    private static void putCandy(int B, int C) {
        int idx = (1 << h) + B;

        while (idx > 0) {
            segTree[idx] += C;
            idx >>= 1;
        }
    }

    private static void setSegTree() {
        h = (int) Math.ceil(Math.log(MAX) / Math.log(2));
        len = (1 << (h + 1)) + 1;
        segTree = new int[len];
    }
}
