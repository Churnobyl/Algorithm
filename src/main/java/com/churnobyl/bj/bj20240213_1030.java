package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj20240213_1030 {
	static int s, N, K, R1, R2, C1, C2;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		s = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R1 = Integer.parseInt(st.nextToken());
		R2 = Integer.parseInt(st.nextToken());
		C1 = Integer.parseInt(st.nextToken());
		C2 = Integer.parseInt(st.nextToken());

		map = new int[R2 - R1 + 1][C2 - C1 + 1];

		fractal(0, 0, 0, false); // y, x, seconds, isBlack
		
		for (int i = 0; i < R2 - R1 + 1; i++) {
			for (int j = 0; j < C2 - C1 + 1; j++) {
				bw.append(map[i][j] + "");
			}
			bw.append("\n");
		}

		bw.flush();
		bw.close();
	}

	private static void fractal(int y, int x, int seconds, boolean isBlack) {
		if (seconds == s) {
			if (isBlack && R1 <= y && y <= R2 && C1 <= x && x <= C2) {
				map[y - R1][x - C1] = 1;
			}
			return;
		}
		
		int size = (int) Math.pow(N, s - seconds);
		int blockSize = size / N;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int nextY = y + i * blockSize;
				int nextX = x + j * blockSize;
				
				if (nextY + blockSize - 1 < R1 || nextX + blockSize - 1 < C1 || R2 < nextY || C2 < nextX) {
					continue;
				}
				
				if (isBlack || (i >= (N - K) / 2 && i < (N + K) / 2 && j >= (N - K) / 2 && j < (N + K) / 2)) {					
					fractal(nextY, nextX, seconds + 1, true);
				} else {
					fractal(nextY, nextX, seconds + 1, false);
				}

			}
		}
	}
}