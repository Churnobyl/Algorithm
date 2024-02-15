package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bj20240215_2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = size[0];
        int M = size[1];
        int[][] maze = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] nxt = queue.poll();
            int y = nxt[0];
            int x = nxt[1];
            int count = nxt[2];

            if (y == N - 1 && x == M - 1) {
                System.out.println(count);
                break;
            }

            if (visited[y][x]) {
                continue;
            }

            visited[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < M && 0 <= ny && ny < N && maze[ny][nx] == 1 && !visited[ny][nx]) {
                    queue.add(new int[]{ny, nx, count + 1});
                }
            }
        }
    }
}