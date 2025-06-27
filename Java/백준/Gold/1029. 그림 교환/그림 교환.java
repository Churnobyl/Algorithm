import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] price;
    static boolean[][][] visited;
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        price = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                price[i][j] = line.charAt(j) - '0';
            }
        }

        visited = new boolean[N][1 << N][10];

        Queue<State> queue = new ArrayDeque<>();
        queue.add(new State(0, 1, 0, 1)); // 현재 소유자, bitmask, 마지막 가격, 인원수
        visited[0][1][0] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            answer = Math.max(answer, cur.count);

            for (int next = 0; next < N; next++) {
                if ((cur.bitmask & (1 << next)) != 0) continue;
                int nextPrice = price[cur.artist][next];
                if (nextPrice < cur.price) continue;

                int nextBitmask = cur.bitmask | (1 << next);
                if (!visited[next][nextBitmask][nextPrice]) {
                    visited[next][nextBitmask][nextPrice] = true;
                    queue.add(new State(next, nextBitmask, nextPrice, cur.count + 1));
                }
            }
        }
        System.out.println(answer);
    }

    static class State {
        int artist, bitmask, price, count;
        State(int a, int b, int c, int d) {
            artist = a; bitmask = b; price = c; count = d;
        }
    }
}
