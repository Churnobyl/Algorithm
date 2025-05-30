import java.io.*;
import java.util.*;

public class Main {
    static char[][] map = new char[5][5];
    static int answer = 0;
    static int[] selected = new int[7];
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();

            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        combination(0, 0, 0);
        System.out.println(answer);
    }

    private static void combination(int count, int start, int sCount) {
        if (count == 7) {
            if (sCount >= 4 && isConnected()) {
                answer++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            selected[count] = i;
            int y = i / 5;
            int x = i % 5;
            combination(count + 1, i + 1, sCount + (map[y][x] == 'S' ? 1 : 0));
        }
    }

    private static boolean isConnected() {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[7];
        visited[0] = true;
        queue.add(selected[0]);
        int count = 1;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            int y = curr / 5;
            int x = curr % 5;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                int next = ny * 5 + nx;

                if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;

                for (int j = 0; j < 7; j++) {
                    if (!visited[j] && selected[j] == next) {
                        visited[j] = true;
                        queue.add(next);
                        count++;
                    }
                }
            }
        }

        return count == 7;
    }
}
