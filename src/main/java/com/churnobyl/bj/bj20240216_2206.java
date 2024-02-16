package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj20240216_2206 {
	static int N, M;
	static int[][] map;
	static int[][][] dp;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dp = new int[N][M][2];

		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = data.charAt(j) - '0';
				dp[i][j][0] = Integer.MAX_VALUE;
				dp[i][j][1] = Integer.MAX_VALUE;
			}
		}

		dp[N - 1][M - 1][0] = 1;
		dp[N - 1][M - 1][1] = 1;

		queue.add(new int[] { N - 1, M - 1, 0 });

		while (!queue.isEmpty()) {
			int[] nxt = queue.poll();

			if (nxt[0] == 0 && nxt[1] == 0)
				continue;

			for (int i = 0; i < 4; i++) {
				int ny = nxt[0] + dy[i];
				int nx = nxt[1] + dx[i];

				if (0 <= ny && ny < N && 0 <= nx && nx < M) {
					if (map[ny][nx] == 0) {
						if (nxt[2] == 0) {
							if (dp[nxt[0]][nxt[1]][0] + 1 < dp[ny][nx][0]) {
								dp[ny][nx][0] = dp[nxt[0]][nxt[1]][0] + 1;
								queue.add(new int[] {ny, nx, 0});
							}
						} else {
							if (dp[nxt[0]][nxt[1]][1] + 1 < dp[ny][nx][1]) {
								dp[ny][nx][1] = dp[nxt[0]][nxt[1]][1] + 1;
								queue.add(new int[] {ny, nx, 1});
							}
						}
					} else {
						if (nxt[2] == 0) {
							dp[ny][nx][1] = dp[nxt[0]][nxt[1]][0] + 1;
							queue.add(new int[] {ny, nx, 1});
						}
					}
				}
			}
		}

		int result = Math.min(dp[0][0][0], dp[0][0][1]);
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
}