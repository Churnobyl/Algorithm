package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj20240222_2718 {
	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dp = new int[31];
		dp[0] = 1;
		dp[1] = 1;

		N = Integer.parseInt(br.readLine());
		
		for (int i = 2; i < N + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] * 2;
		}
		
		if (N % 2 == 0) {
			System.out.println((dp[N] + dp[N / 2] + dp[N / 2 - 1] * 2) / 2);
		} else {
			System.out.println((dp[N] + dp[N / 2]) / 2);
		}
	}
}