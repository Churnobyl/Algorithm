package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj20240218_9465 {
	static int n;
	static int[][] stickers;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			n = Integer.parseInt(br.readLine());
			stickers = new int[n][2];
			dp = new int[n][3];
			
			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < n; j2++) {
					stickers[j2][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][0] = 0;
			dp[0][1] = stickers[0][0];
			dp[0][2] = stickers[0][1];
			
			for (int j = 1; j < n; j++) {
				dp[j][0] = Math.max(Math.max(dp[j - 1][0], dp[j - 1][1]), dp[j - 1][2]);
				dp[j][1] = Math.max(dp[j - 1][0], dp[j - 1][2]) + stickers[j][0];
				dp[j][2] = Math.max(dp[j - 1][0], dp[j - 1][1]) + stickers[j][1];
			}
			
			System.out.println(Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
		}
	}
}