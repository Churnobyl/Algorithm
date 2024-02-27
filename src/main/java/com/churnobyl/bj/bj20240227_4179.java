package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj20240227_4179 {
	static int R, C;
	static char[][] map;
	static int[][] fireTime, escapeTime;
	static Queue<int[]> fireQueue = new LinkedList<>(), jihunQueue = new LinkedList<>();
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		fireTime = new int[R][C];
        escapeTime = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                fireTime[i][j] = Integer.MAX_VALUE;
                escapeTime[i][j] = Integer.MAX_VALUE;
                
                if (map[i][j] == 'J') {
                    jihunQueue.add(new int[] {i, j});
                    escapeTime[i][j] = 0;
                }
                if (map[i][j] == 'F') {
                    fireQueue.add(new int[] {i, j});
                    fireTime[i][j] = 0;
                }
            }
        }

        spreadFire();
        boolean escaped = escape();

        if (!escaped) System.out.println("IMPOSSIBLE");
	}
	
	static void spreadFire() {
        while (!fireQueue.isEmpty()) {
            int[] current = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];
                if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                    if (map[ny][nx] != '#' && fireTime[ny][nx] == Integer.MAX_VALUE) {
                        fireTime[ny][nx] = fireTime[current[0]][current[1]] + 1;
                        fireQueue.add(new int[] {ny, nx});
                    }
                }
            }
        }
    }
    
    static boolean escape() {
        while (!jihunQueue.isEmpty()) {
            int[] current = jihunQueue.poll();
            if (current[0] == 0 || current[0] == R-1 || current[1] == 0 || current[1] == C-1) {
                System.out.println(escapeTime[current[0]][current[1]] + 1);
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];
                if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                    if (map[ny][nx] != '#' && escapeTime[ny][nx] == Integer.MAX_VALUE && escapeTime[current[0]][current[1]] + 1 < fireTime[ny][nx]) {
                        escapeTime[ny][nx] = escapeTime[current[0]][current[1]] + 1;
                        jihunQueue.add(new int[] {ny, nx});
                    }
                }
            }
        }
        return false;
    }
}