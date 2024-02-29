import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static int[] sangeun, festival;
    static int[][] conveni;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            sangeun = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            conveni = new int[n][2];
            visited = new boolean[n];
            for (int j = 0; j < n; j++) {
                conveni[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            festival = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (bfs()) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    private static boolean bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(sangeun);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (Math.abs(current[0] - festival[0]) + Math.abs(current[1] - festival[1]) <= 1000) {
                return true;
            }

            for (int j = 0; j < n; j++) {
                if (!visited[j] && Math.abs(current[0] - conveni[j][0]) + Math.abs(current[1] - conveni[j][1]) <= 1000) {
                    visited[j] = true;
                    queue.add(conveni[j]);
                }
            }
        }

        return false;
    }
}