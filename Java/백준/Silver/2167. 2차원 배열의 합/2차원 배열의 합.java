import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[][] accumArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        accumArr = new long[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                accumArr[i][j] = Long.parseLong(st.nextToken())
                        + (i > 0 ? accumArr[i - 1][j] : 0)
                        + (j > 0 ? accumArr[i][j - 1] : 0)
                        - (i > 0 && j > 0 ? accumArr[i - 1][j - 1] : 0);
            }
        }

        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            sb.append(get(a,b,c,d)).append("\n");
        }

        System.out.println(sb);
    }

    private static long get(int a, int b, int c, int d) {
        return accumArr[c][d]
                - (a - 1 >= 0 ? accumArr[a - 1][d] : 0)
                - (b - 1 >= 0 ? accumArr[c][b - 1] : 0)
                + (a - 1 >= 0 && b - 1 >= 0 ? accumArr[a - 1][b - 1] : 0);
    }
}
