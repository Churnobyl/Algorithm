import java.io.*;
import java.util.*;

public class Main {
    static int N, M, W;
    static int[][] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            edges = new int[2 * M + W][3];
            int idx = 0;

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges[idx++] = new int[]{S, E, T};
                edges[idx++] = new int[]{E, S, T};
            }

            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges[idx++] = new int[]{S, E, -T};
            }

            int[] dist = new int[N + 1];

            for (int j = 0; j < N - 1; j++) {
                for (int k = 0; k < 2 * M + W; k++) {
                    int[] edge = edges[k];
                    int s = edge[0];
                    int e = edge[1];
                    int w = edge[2];

                    if (dist[s] != Integer.MAX_VALUE) {
                        dist[e] = Math.min(dist[e], dist[s] + w);
                    }
                }
            }

            boolean isCycle = false;

            for (int j = 0; j < 2 * M + W; j++) {
                int[] edge = edges[j];
                int s = edge[0];
                int e = edge[1];
                int w = edge[2];
                if (dist[s] != Integer.MAX_VALUE && dist[e] > dist[s] + w) {
                    isCycle = true;
                    break;
                }
            }

            sb.append(isCycle ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}
