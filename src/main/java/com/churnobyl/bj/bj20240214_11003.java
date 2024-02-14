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

public class bj20240214_11003 {
	static int N, M, B, height, lowLimit;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		int ansHeight = Integer.MIN_VALUE;
		int t = Integer.MAX_VALUE;
		height = Integer.MIN_VALUE;
		lowLimit = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				height = Math.max(height, map[i][j]);
				lowLimit = Math.min(lowLimit, map[i][j]);
			}
		}
		
		while (height >= lowLimit) {
			int cache = 0;
			int C = B;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (height > map[i][j]) {
						cache += height - map[i][j];
						C -= height - map[i][j];
					} else if (height < map[i][j]) {
						cache += 2 * (map[i][j] - height);
						C += map[i][j] - height;
					}
				}
			}
			
			height--;
			
			if (C < 0)
				continue;
			
			if (cache < t) {
				ansHeight = height + 1;
				t = cache;
			}
		}
		
		bw.append(t + " " + ansHeight);
		bw.flush();
		bw.close();
	}
}