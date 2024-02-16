package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj20240216_11660 {
	static int N, M;
	static int[][] nums;
	static int[][] dp;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N][N];
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());

				int a = 0;
				int b = 0;
				int c = 0;
				if (i - 1 >= 0 && j - 1 >= 0)
					a = dp[i - 1][j - 1];
				if (i - 1 >= 0)
					b = dp[i - 1][j];
				if (j - 1 >= 0)
					c = dp[i][j - 1];

				dp[i][j] = b + c - a + nums[i][j];
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int i1 = Integer.parseInt(st.nextToken()) - 1;
			int j1 = Integer.parseInt(st.nextToken()) - 1;
			int i2 = Integer.parseInt(st.nextToken()) - 1;
			int j2 = Integer.parseInt(st.nextToken()) - 1;
			
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			
			if (i1 - 1 >= 0 && j1 - 1 >= 0) a = dp[i1 - 1][j1 - 1];
			if (i1 - 1 >= 0) b = dp[i1 - 1][j2];
			if (j1 -1 >= 0) c = dp[i2][j1 - 1];
			
			System.out.println(dp[i2][j2] - b - c + a);
		}

	}
}