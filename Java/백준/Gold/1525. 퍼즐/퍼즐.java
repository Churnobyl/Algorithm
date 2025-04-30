import java.io.*;
import java.util.*;

public class Main {
    static class State {
        String str;
        int count;

        public State(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static final String GOAL = "123456780";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder start = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                start.append(st.nextToken());
            }
        }

        String initial = start.toString();
        if (initial.equals(GOAL)) {
            System.out.println(0);
            return;
        }

        Queue<State> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.add(new State(initial, 0));
        visited.add(initial);

        while (!queue.isEmpty()) {
            State now = queue.poll();
            String current = now.str;
            int zeroIdx = current.indexOf('0');
            int y = zeroIdx / 3;
            int x = zeroIdx % 3;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || ny >= 3 || nx < 0 || nx >= 3) continue;

                int swapIdx = ny * 3 + nx;
                char[] nextArr = current.toCharArray();

                char temp = nextArr[zeroIdx];
                nextArr[zeroIdx] = nextArr[swapIdx];
                nextArr[swapIdx] = temp;

                String next = new String(nextArr);
                if (!visited.contains(next)) {
                    if (next.equals(GOAL)) {
                        System.out.println(now.count + 1);
                        return;
                    }
                    visited.add(next);
                    queue.add(new State(next, now.count + 1));
                }
            }
        }

        System.out.println(-1);
    }
}
