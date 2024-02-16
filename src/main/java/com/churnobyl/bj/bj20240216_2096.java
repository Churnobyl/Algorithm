package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj20240216_2096 {
	static int N;
	static int[][] numbers;
	static int[][][] dp;
	static int[] dx = {-1, 0, 1};
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		numbers = new int[N][3];
		dp = new int[N][3][2]; // 0 : 최대, 1 : 최소
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 3; j++) {
				numbers[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j][0] = numbers[i][j];
				if (i == 0) {
					dp[i][j][1] = numbers[i][j];					
				} else {
					dp[i][j][1] = Integer.MAX_VALUE;										
				}
			}
		}
		
		for (int i = 0; i < 3; i++) {
			queue.add(new int[] {0, i});
		}
		
		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			
			if (point[0] == N - 1) continue;
			
			for (int i = 0; i < 3; i++) {
				int ny = point[0] + 1;
				int nx = point[1] + dx[i];
				
				if (0 <= ny && ny < N && 0 <= nx && nx < 3) {
					if (dp[point[0]][point[1]][0] + numbers[ny][nx] > dp[ny][nx][0] || dp[point[0]][point[1]][1] + numbers[ny][nx] < dp[ny][nx][1]) {
						int[] copied = dp[ny][nx];
						if (dp[point[0]][point[1]][0] + numbers[ny][nx] > dp[ny][nx][0])
							copied[0] = dp[point[0]][point[1]][0] + numbers[ny][nx];
						if (dp[point[0]][point[1]][1] + numbers[ny][nx] < dp[ny][nx][1])
							copied[1] = dp[point[0]][point[1]][1] + numbers[ny][nx];
						dp[ny][nx] = copied;
						queue.add(new int[] {ny, nx});
					}
				}
			}
		}
		
		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;
		
		for (int i = 0; i < 3; i++) {			
			maxValue = Math.max(maxValue, dp[N - 1][i][0]);
			minValue = Math.min(minValue, dp[N - 1][i][1]);
		}
		
		System.out.println(maxValue + " " + minValue);
	}
}