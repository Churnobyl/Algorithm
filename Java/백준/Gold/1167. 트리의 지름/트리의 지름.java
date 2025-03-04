import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V;
    static boolean[] visited;
    static ArrayList<int[]>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());

        edges = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int vertex = Integer.parseInt(st.nextToken());

            while (true) {
                int data = Integer.parseInt(st.nextToken());

                if (data == -1) break;

                int length = Integer.parseInt(st.nextToken());

                if (edges[vertex] == null) {
                    edges[vertex] = new ArrayList<>();
                }
                edges[vertex].add(new int[]{data, length});

                if (edges[data] == null) {
                    edges[data] = new ArrayList<>();
                }
                edges[data].add(new int[]{vertex, length});
            }
        }

        visited[1] = true;
        int[] findX = findFinalEdge(1, 0);
        visited = new boolean[V + 1];
        visited[findX[0]] = true;
        int[] answer = findFinalEdge(findX[0], 0);

        System.out.println(answer[1]);
    }

    private static int[] findFinalEdge(int vertex, int len) {
        boolean canGo = false;

        int[] result = new int[2];

        for (int[] edge : edges[vertex]) {
            if (!visited[edge[0]]) {
                canGo = true;

                visited[edge[0]] = true;
                int[] candidate = findFinalEdge(edge[0], len + edge[1]);

                if (result[1] < candidate[1]) {
                    result[0] = candidate[0];
                    result[1] = candidate[1];
                }
            }
        }

        if (!canGo) return new int[] {vertex, len};

        return result;
    }
}
