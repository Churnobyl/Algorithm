import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        p = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            p[i] = i;
        }

        StringTokenizer st;

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j < N + 1; j++) {
                boolean isConnected = st.nextToken().equals("1");
                if (i == j) continue;
                if (!isConnected) continue;

                union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        boolean isAllUnion = true;
        int parent = -1;

        for (int i = 0; i < M; i++) {
            int nextCity = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                parent = find(nextCity);
                continue;
            }

            if (parent != find(nextCity)) {
                isAllUnion = false;
                break;
            }
        }

        if (isAllUnion) System.out.println("YES");
        else System.out.println("NO");
    }

    public static boolean union(int x, int y) {
        x = find(p[x]);
        y = find(p[y]);

        if (x == y) return false;
        p[y] = x;
        return true;
    }

    public static int find(int x) {
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
    }
}