import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || i == k || j == k) continue;
                    if (cost[i][j] > cost[i][k] + cost[k][j]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                boolean necessary = true;
                for (int k = 0; k < N; k++) {
                    if (k == i || k == j) continue;
                    if (cost[i][j] == cost[i][k] + cost[k][j]) {
                        necessary = false;
                        break;
                    }
                }
                if (necessary) answer += cost[i][j];
            }
        }
        System.out.println(answer);
    }
}
