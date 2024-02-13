package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj20240209_1051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String t = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = t.charAt(j) - '0';
			}
		}
		
		int maxValue = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int j2 = 1; j2 < Math.min(N, M); j2++) {
					if (i + j2 < N && j + j2 < M) {
						if (map[i][j] == map[i + j2][j] && map[i][j] == map[i][j + j2] && map[i][j] == map[i + j2][j + j2]) {
							maxValue = Math.max(maxValue, j2 + 1);
						}
					}
				}
			}
		}
		
		System.out.println(maxValue * maxValue);
	}

}