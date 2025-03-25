import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> map = new HashMap<>();
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.put(x, y);
        }

        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[] {1, 0});

        loop1:
        while (!queue.isEmpty()) {
            int[] nxt = queue.poll();
            int square = nxt[0];
            int cnt = nxt[1];

            for (int i = 1; i <= 6; i++) {
                int nextSquare = square + i;

                if (nextSquare == 100) {
                    System.out.println(cnt + 1);
                    break loop1;
                }

                if (map.containsKey(nextSquare)) {
                    int moved = map.get(nextSquare);

                    if (!visited[moved]) {
                        visited[moved] = true;
                        queue.add(new int[] {moved, cnt + 1});
                    }
                } else {
                    if (!visited[nextSquare]) {
                        visited[nextSquare] = true;
                        queue.add(new int[] {nextSquare, cnt + 1});
                    }
                }
            }
        }
    }
}
