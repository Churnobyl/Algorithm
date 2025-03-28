import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer, int[]> minMax = new HashMap<>();
    static int[] p;
    static int[][] edges;
    static int setNumber = 1;
    static int rootNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        p = new int[N + 1];
        edges = new int[N + 1][2];

        // set edges
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            edges[node][0] = left;
            edges[node][1] = right;
            if (left != -1) {
                p[left] = node;
            }

            if (right != -1) {
                p[right] = node;
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (p[i] == 0) {
                rootNode = i;
                break;
            }
        }

        inDegree(rootNode, 1);

        int answer = 0;
        int check = Integer.MIN_VALUE;

        for (Map.Entry<Integer, int[]> entry : minMax.entrySet()) {
            int[] arr = entry.getValue();
            int diff = arr[1] - arr[0] + 1;

            if (diff > check) {
                answer = entry.getKey();
                check = diff;
            }
        }

        System.out.println(answer + " " + check);
    }

    private static void inDegree(int node, int depth) {
        if (node == -1) return;

        inDegree(edges[node][0], depth + 1);

        minMax.putIfAbsent(depth, new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE});

        int[] arr = minMax.get(depth);

        arr[0] = Math.min(arr[0], setNumber);
        arr[1] = Math.max(arr[1], setNumber);

        setNumber++;

        inDegree(edges[node][1], depth + 1);
    }
}
