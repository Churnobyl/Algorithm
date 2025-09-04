import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] B = new int[M][K];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                int data = 0;
                for (int k = 0; k < M; k++) {
                    data += A[i][k] * B[k][j];
                }

                sb.append(data).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
