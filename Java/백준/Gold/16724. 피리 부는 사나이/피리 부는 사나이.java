import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static char[][] map;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        map = new char[N][M];
        parent = new int[N * M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N * M; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int idx = i * M + j;
                if (map[i][j] == 'U') union(idx, idx - M);
                else if (map[i][j] == 'D') union(idx, idx + M);
                else if (map[i][j] == 'L') union(idx, idx - 1);
                else if (map[i][j] == 'R') union(idx, idx + 1);
            }
        }

        int count = 0;
        for (int i = 0; i < N * M; i++) {
            if (find(i) == i) count++;
        }

        System.out.println(count);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }
}