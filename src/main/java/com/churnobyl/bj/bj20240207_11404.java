package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj20240207_11404 {
	static int[][] dp;
	static int[][] cost;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		dp = new int[n + 1][n + 1];
		cost = new int[n + 1][n + 1];
		Arrays.fill(cost, 100_001);
		StringTokenizer st;
		int s, e, c;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if (c < cost[s][e])
				cost[s][e] = c;
		}
		
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == j)
					continue;
				
				
			}
		}
	}
}